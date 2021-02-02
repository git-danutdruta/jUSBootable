package ro.rainy.jusbootable.model.domain;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 15/12/2020__23:57
 */
public enum FileSystemType {
    FAT32("FAT32"),
    EX_FAT("exFAT"),
    NTFS("NTFS");

    private String description;

    FileSystemType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
