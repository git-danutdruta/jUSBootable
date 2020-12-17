package ro.rainy.jusbootable.view;

import ro.rainy.jusbootable.handler.ButtonClickHandler;
import ro.rainy.jusbootable.handler.SelectionChangeHandler;
import ro.rainy.jusbootable.model.BComboModel;
import ro.rainy.jusbootable.model.domain.*;

import java.awt.*;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:08
 */
public interface JUSBView extends Structure {
    void setVisible(boolean visible);

    void setIconImage(Image image);

    void setUSBComboBoxModel(BComboModel<FlashDrive> usbComboBoxModel);

    void setPartitionSchemeComboBoxModel(BComboModel<PartitionSchemeType> partitionSchemeTypeComboModel);

    void setTargetSystemComboBoxModel(BComboModel<TargetSystemType> targetSystemTypeComboModel);

    void setFileSystemComboBoxModel(BComboModel<FileSystemType> fileSystemComboBoxModel);

    void setClusterComboBoxModel(BComboModel<ClusterSize> fileSystemComboBoxModel);


    void whenUserClickStartButton(ButtonClickHandler startHandler);

    void whenUserClickCloseButton(ButtonClickHandler closeHandler);

    void whenUserClickBootSelectionButton(ButtonClickHandler bootSelectionHandler);

    void whenFileChooserSelectionChange(SelectionChangeHandler selectionChangeHandler);
}