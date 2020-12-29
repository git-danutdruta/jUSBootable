package ro.rainy.jusbootable.model;

import ro.rainy.jusbootable.handler.ExceptionThrownHandler;
import ro.rainy.jusbootable.handler.InfoDataHandler;
import ro.rainy.jusbootable.handler.UpdateSelectionHandler;
import ro.rainy.jusbootable.handler.VisibilityChangeHandler;
import ro.rainy.jusbootable.model.domain.*;

import java.awt.image.BufferedImage;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:12
 */
public interface JUSBModel {
    void whenExceptionThrown(ExceptionThrownHandler exceptionThrownHandler);

    void whenInfoSend(InfoDataHandler infoDataHandler);

    void whenSelectionChange(UpdateSelectionHandler updateSelectionHandler);

    void whenVisibilityChange(VisibilityChangeHandler visibilityChangeHandler);

    void setVisible(boolean visible);

    boolean isFrameVisible();

    BComboModel<FlashDrive> getUsbComboModel();

    BComboModel<PartitionSchemeType> getPartitionSchemeComboModel();

    BComboModel<TargetSystemType> getTargetSystemComboModel();

    BComboModel<FileSystemType> getFileSystemTypeComboModel();

    BComboModel<ClusterSize> getClusterComboModel();

    BFileChooserModel getFileChooserModel();

    BProgressBarBoundedRangeModel getProgressBarModel();

    BufferedImage getLogo();

    void updateSelection();

    void checkDeviceListForUpdates();

    void makeUSBootable();

    void prepareExit();
}
