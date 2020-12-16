package ro.rainy.jusbootable.model.domain;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 16/12/2020__21:29
 */
public enum ClusterSize {
    CS_4("4 KB"),
    CS_32("32 KB"),
    CS_128("128 KB");

    String sizeInKiloBytes;

    ClusterSize(String sizeInKiloBytes) {
        this.sizeInKiloBytes = sizeInKiloBytes;
    }

    @Override
    public String toString() {
        return sizeInKiloBytes;
    }
}
