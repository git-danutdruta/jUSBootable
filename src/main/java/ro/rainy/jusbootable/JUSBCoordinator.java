package ro.rainy.jusbootable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.rainy.jusbootable.model.JUSBModel;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:17
 */
public class JUSBCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(JUSBCoordinator.class);

    public JUSBCoordinator(ApplicationStarter applicationStarter, JUSBModel jUsbModel) {

        applicationStarter.whenApplicationStart(() -> {
            LOG.info("Starting jUSBootable application");
            jUsbModel.setVisible(true);
            jUsbModel.checkDeviceListForUpdates();
        });
    }
}