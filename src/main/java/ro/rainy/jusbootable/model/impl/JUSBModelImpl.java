package ro.rainy.jusbootable.model.impl;

import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.events.DeviceEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.rainy.jusbootable.dispatcher.EventDispatcher;
import ro.rainy.jusbootable.handler.ExceptionThrownHandler;
import ro.rainy.jusbootable.handler.InfoDataHandler;
import ro.rainy.jusbootable.handler.UpdateSelectionHandler;
import ro.rainy.jusbootable.handler.VisibilityChangeHandler;
import ro.rainy.jusbootable.model.BComboModel;
import ro.rainy.jusbootable.model.BFileChooserModel;
import ro.rainy.jusbootable.model.BProgressBarBoundedRangeModel;
import ro.rainy.jusbootable.model.JUSBModel;
import ro.rainy.jusbootable.model.domain.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:13
 */
public class JUSBModelImpl implements JUSBModel {
    private static final Logger LOG = LoggerFactory.getLogger(JUSBModelImpl.class);

    private final EventDispatcher<VisibilityChangeHandler> visibilityChangeHandlerEventDispatcher;
    private final EventDispatcher<ExceptionThrownHandler> exceptionThrownHandlerEventDispatcher;
    private final EventDispatcher<InfoDataHandler> infoDataHandlerEventDispatcher;
    private final EventDispatcher<UpdateSelectionHandler> updateSelectionEventDispatcher;
    private final BComboModel<FlashDrive> usbComboModel;
    private final BComboModel<PartitionSchemeType> partitionSchemeComboModel;
    private final BComboModel<TargetSystemType> targetSystemComboModel;
    private final BComboModel<FileSystemType> fileSystemTypeComboModel;
    private final BComboModel<ClusterSize> clusterComboModel;
    private final BFileChooserModel fileChooserModel;
    private final BProgressBarBoundedRangeModel progressBarRangeModel;
    private boolean frameVisible;

    public JUSBModelImpl() {
        exceptionThrownHandlerEventDispatcher = new EventDispatcher<>("exceptionThrown");
        infoDataHandlerEventDispatcher = new EventDispatcher<>("pushDataToGUI");
        visibilityChangeHandlerEventDispatcher = new EventDispatcher<>("visibilityChange");
        updateSelectionEventDispatcher = new EventDispatcher<>("updateSelection");
        usbComboModel = new BComboModelImpl<>();
        partitionSchemeComboModel = new BComboModelImpl<>(PartitionSchemeType.values());
        targetSystemComboModel = new BComboModelImpl<>(TargetSystemType.values());
        fileSystemTypeComboModel = new BComboModelImpl<>(FileSystemType.values());
        clusterComboModel = new BComboModelImpl<>(ClusterSize.values());
        fileChooserModel = new BFileChooserModelImpl();
        progressBarRangeModel = new BProgressBarBoundedRangeModelImpl();
    }

    @Override
    public void whenVisibilityChange(VisibilityChangeHandler visibilityChangeHandler) {
        visibilityChangeHandlerEventDispatcher.addListener(visibilityChangeHandler);
    }

    @Override
    public void whenExceptionThrown(ExceptionThrownHandler exceptionThrownHandler) {
        exceptionThrownHandlerEventDispatcher.addListener(exceptionThrownHandler);
    }

    @Override
    public void whenInfoSend(InfoDataHandler infoDataHandler) {
        infoDataHandlerEventDispatcher.addListener(infoDataHandler);
    }

    @Override
    public void whenSelectionChange(UpdateSelectionHandler updateSelectionHandler) {
        updateSelectionEventDispatcher.addListener(updateSelectionHandler);
    }

    @Override
    public void setVisible(boolean visible) {
        LOG.debug("Set frame visible: {}", visible);
        this.frameVisible = visible;
        visibilityChangeHandlerEventDispatcher.dispatch();
    }

    @Override
    public boolean isFrameVisible() {
        return frameVisible;
    }


    @Override
    public BComboModel<FlashDrive> getUsbComboModel() {
        return usbComboModel;
    }

    @Override
    public BComboModel<PartitionSchemeType> getPartitionSchemeComboModel() {
        return partitionSchemeComboModel;
    }

    @Override
    public BComboModel<TargetSystemType> getTargetSystemComboModel() {
        return targetSystemComboModel;
    }

    @Override
    public BComboModel<FileSystemType> getFileSystemTypeComboModel() {
        return fileSystemTypeComboModel;
    }

    @Override
    public BComboModel<ClusterSize> getClusterComboModel() {
        return clusterComboModel;
    }

    @Override
    public BFileChooserModel getFileChooserModel() {
        return fileChooserModel;
    }

    @Override
    public BProgressBarBoundedRangeModel getProgressBarModel() {
        return progressBarRangeModel;
    }


    @Override
    public BufferedImage getLogo() {
        try {
            return ImageIO.read(new File("static/logo.png"));
        } catch (IOException e) {
//            LOG.error(e.getMessage());
            exceptionThrownHandlerEventDispatcher.dispatch(e);
        }
        return null;
    }

    @Override
    public void updateSelection() {
        File file = fileChooserModel.getSelectedFile();
        if (file != null) {
            updateSelectionEventDispatcher.dispatch(file.getName());
        }
    }

    @Override
    public void checkDeviceListForUpdates() {
        LOG.info("Initiate flash drives checker");
        USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager(2500L);
        LOG.debug("Register listener for new coming events");
        driveDetector.addDriveListener(event -> {
            final FlashDrive element = new FlashDrive(event.getStorageDevice());
            usbComboModel.removeElement(element);
            if (event.getEventType() == DeviceEventType.CONNECTED) {
                LOG.debug("New device connected: {}", element);
                usbComboModel.addElement(element);
            }
        });
    }

    @Override
    public void makeUSBootable() {
        //todo check if file is set
        FlashDrive selectedDrive = (FlashDrive) usbComboModel.getSelectedItem();
        if (selectedDrive == null) {
            exceptionThrownHandlerEventDispatcher.dispatch(new Exception("There's no flash drive selected/inserted "));
            return;
        }
        File file = fileChooserModel.getSelectedFile();
        if (file == null) {
            exceptionThrownHandlerEventDispatcher.dispatch(new Exception("A valid file should be selected"));
            return;
        }


        // -- Linux --

        // Run a shell command
        //umount
        //mkfs.vfat
        //sudo dd bs=4M if=path/to/input.iso of=/dev/sd<?> conv=fdatasync  status=progress

        try {
            String deviceIndicativ = selectedDrive.getDevice();
            int umountCode = executeProcess("Unmounting drive", "umount", deviceIndicativ);
            if (umountCode == 0) {
                int mkfsVFatCode = executeProcess("Formatting drive", "mkfs.vfat", deviceIndicativ);
                if (mkfsVFatCode == 0) {
                    int ddCode = executeProcess("Disk d.", "dd", "bs=4M",
                            String.format("if=%s", file.getAbsolutePath()),
                            String.format("of=%s", deviceIndicativ),
                            "conv=fdatasync",
                            "status=progress");
                    if (ddCode == 0) {
                        progressBarRangeModel.setValue(100);
                        infoDataHandlerEventDispatcher.dispatch("Operation successful");
                    } else {
                        infoDataHandlerEventDispatcher.dispatch("Cannot create bootable flash drive");
                    }
                } else {
                    infoDataHandlerEventDispatcher.dispatch("Cannot format the flash drive\n Start application as administrator!");
                }
            } else {
                infoDataHandlerEventDispatcher.dispatch("Cannot unmount the flash drive");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            exceptionThrownHandlerEventDispatcher.dispatch(e);
        }

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\dd");

        // Run a bat file
        //processBuilder.command("C:\\Users\\Daniel\\dd.bat");

    }

    private int executeProcess(String processAlias, String... args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(args);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            LOG.debug(line);
        }
        int exitVal = process.waitFor();
        LOG.debug("{} ended with code {}", processAlias, exitVal);

        return exitVal;
    }

    @Override
    public void prepareExit() {
        LOG.info("Shutdown signal ...");
        LOG.debug("======================================================\n");
        System.exit(0);
    }
}