package ro.rainy.jusbootable.model.domain;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 15/12/2020__23:57
 */
public enum FileSystemType {
    EX_FAT("exFAT"),
    FAT32("FAT32"),
    NTFS("NTFS");

    String description;

    FileSystemType(String description) {
        this.description = description;
    }
}
