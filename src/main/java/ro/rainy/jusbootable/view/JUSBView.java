package ro.rainy.jusbootable.view;

import ro.rainy.jusbootable.handler.ButtonClickHandler;
import ro.rainy.jusbootable.model.USBComboModel;
import ro.rainy.jusbootable.model.domain.FlashDrive;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:08
 */
public interface JUSBView extends Structure {
    void setVisible(boolean visible);


    void setUSBComboBoxModel(USBComboModel<FlashDrive> comboBoxModel);


    void whenUserClickStartButton(ButtonClickHandler startHandler);

    void whenUserClickCloseButton(ButtonClickHandler closeHandler);
}