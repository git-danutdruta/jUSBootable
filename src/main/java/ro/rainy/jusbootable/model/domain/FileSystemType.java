package ro.rainy.jusbootable.model.domain;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 15/12/2020__23:57
 */
public enum FileSystemType {
    FAT32(OperatingSystem.WINDOWS, "", "FAT32"),
    NTFS_DOS(OperatingSystem.WINDOWS, "", "NTFS"),

    EX_FAT_NIX(OperatingSystem.LINUX, "mkfs.exfat", "EX_FAT_NIX"),
    FAT_NIX(OperatingSystem.LINUX, "mkfs.fat", "FAT"),
    MSDOS_NIX(OperatingSystem.LINUX, "mkfs.msdos", "MSDOS"),
    V_FAT_NIX(OperatingSystem.LINUX, "mkfs.vfat", "V_FAT"),
    NTFS_NIX(OperatingSystem.LINUX, "mkfs.ntfs", "NTFS");

    private String description;
    private OperatingSystem os;
    private String utilityProcess;


    FileSystemType(OperatingSystem os, String utilityProcess, String description) {
        this.os = os;
        this.utilityProcess = utilityProcess;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
