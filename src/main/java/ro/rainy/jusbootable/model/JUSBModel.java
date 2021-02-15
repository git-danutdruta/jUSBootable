package ro.rainy.jusbootable.model;

import ro.rainy.jusbootable.handler.*;
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

    void whenInteractionDialogPopUp(InteractingDataHandler interactingDataHandler);

    void whenSelectionChange(UpdateSelectionHandler updateSelectionHandler);

    void whenVolumeNameChange(UpdateSelectionHandler updateVolumeNameHandler);

    void whenVisibilityChange(VisibilityChangeHandler visibilityChangeHandler);

    void setVisible(boolean visible);

    boolean isFrameVisible();

    BComboModel<FlashDrive> getUsbComboModel();

    BComboModel<PartitionSchemeType> getPartitionSchemeComboModel();

    BComboModel<TargetSystemType> getTargetSystemComboModel();

    BComboModel<FileSystemType> getFileSystemTypeComboModel();

    BComboModel<BSSize> getClusterComboModel();

    BFileChooserModel getFileChooserModel();

    BProgressBarBoundedRangeModel getProgressBarModel();

    BTextDocumentModel getVolumeTextDocModel();

    BufferedImage getLogo();

    void updateSelection();

    void checkDeviceListForUpdates();

    void preStageMakeUSBootable();

    void makeUSBootable();

    void prepareExit();
}
