package ro.rainy.jusbootable.model.domain;

import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.util.Objects;

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

    public String getDeviceName() {
        return deviceName;
    }

    public String getDevice() {
        return device;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return deviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashDrive that = (FlashDrive) o;
        return Objects.equals(deviceName, that.deviceName) &&
                Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceName, uuid);
    }
}
