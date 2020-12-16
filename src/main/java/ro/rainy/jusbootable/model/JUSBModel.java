package ro.rainy.jusbootable.model;

import ro.rainy.jusbootable.handler.VisibilityChangeHandler;
import ro.rainy.jusbootable.model.domain.*;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:12
 */
public interface JUSBModel {
    void whenVisibilityChange(VisibilityChangeHandler visibilityChangeHandler);

    void setVisible(boolean visible);

    boolean isFrameVisible();

    BComboModel<FlashDrive> getUsbComboModel();

    BComboModel<PartitionSchemeType> getPartitionSchemeComboModel();

    BComboModel<TargetSystemType> getTargetSystemComboModel();

    BComboModel<FileSystemType> getFileSystemTypeComboModel();

    BComboModel<ClusterSize> getClusterComboModel();
}
