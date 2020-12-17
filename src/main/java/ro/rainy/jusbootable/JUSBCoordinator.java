package ro.rainy.jusbootable;

import ro.rainy.jusbootable.model.JUSBModel;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:17
 */
public class JUSBCoordinator {
    public JUSBCoordinator(ApplicationStarter applicationStarter, JUSBModel jUsbModel) {

        applicationStarter.whenApplicationStart(() -> {
            jUsbModel.setVisible(true);
        });
    }
}
