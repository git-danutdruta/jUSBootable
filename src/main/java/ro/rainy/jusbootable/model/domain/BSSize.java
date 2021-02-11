package ro.rainy.jusbootable.model.domain;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 16/12/2020__21:29
 */
public enum BSSize {
    CS_4("4 KiB", 4),
    CS_8("8 KiB", 8),
    CS_32("32 KiB", 32),
    CS_128("128 KiB", 128),
    CS_1M("1024 KiB", 1024),
    CS_4M("4096 Kib", 4096);

    String sizeInKibiBytes;
    int bytes;

    BSSize(String sizeInKibiBytes, int bytes) {
        this.sizeInKibiBytes = sizeInKibiBytes;
        this.bytes = bytes;
    }

    public int getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return sizeInKibiBytes;
    }
}
