package ro.rainy.jusbootable.model.domain;

import net.samuelcampos.usbdrivedetector.USBStorageDevice;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__14:35
 */
public class FlashDrive {
    private final String deviceName;
    private final String device;
    private final String uuid;

    public FlashDrive(String deviceName, String device, String uuid) {
        this.deviceName = deviceName;
        this.device = device;
        this.uuid = uuid;
    }


    public FlashDrive(USBStorageDevice usbDevice) {
        this.deviceName = usbDevice.getDeviceName();
        this.device = usbDevice.getDevice();
        this.uuid = usbDevice.getUuid();
    }

    @Override
    public String toString() {
        return deviceName;
    }
}
