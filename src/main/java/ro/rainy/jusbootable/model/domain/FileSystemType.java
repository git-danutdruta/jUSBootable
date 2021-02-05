package ro.rainy.jusbootable.model.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 15/12/2020__23:57
 */
public enum FileSystemType {
    FAT32(OperatingSystem.WINDOWS, "", "FAT32"),
    NTFS_DOS(OperatingSystem.WINDOWS, "", "NTFS"),

    EX_FAT_NIX(OperatingSystem.LINUX, "mkfs.exfat", "EX_FAT"),
    FAT_NIX(OperatingSystem.LINUX, "mkfs.fat", "FAT"),
    MSDOS_NIX(OperatingSystem.LINUX, "mkfs.msdos", "MSDOS"),
    V_FAT_NIX(OperatingSystem.LINUX, "mkfs.vfat", "V_FAT"),
    NTFS_NIX(OperatingSystem.LINUX, "mkfs.ntfs", "NTFS");

    private final String description;
    private final OperatingSystem os;
    private final String utilityProcess;


    FileSystemType(OperatingSystem os, String utilityProcess, String description) {
        this.os = os;
        this.utilityProcess = utilityProcess;
        this.description = description;
    }


    public static FileSystemType[] getFileSystemTypes() {
        return getFileSystemTypes_().get(getCurrentOS()).toArray(new FileSystemType[0]);
    }

    private static Map<OperatingSystem, Set<FileSystemType>> getFileSystemTypes_() {
        return Stream
                .of(FileSystemType.values())
                .collect(Collectors.groupingBy(FileSystemType::getOs, Collectors.toSet()));
    }

    private static OperatingSystem getCurrentOS() {
        OperatingSystem os = null;
        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) {
            os = OperatingSystem.WINDOWS;
        } else if (operSys.contains("nix") || operSys.contains("nux")
                || operSys.contains("aix")) {
            os = OperatingSystem.LINUX;
        } else if (operSys.contains("mac")) {
            os = OperatingSystem.MAC_OS;
            /*} else if (operSys.contains("sunos")) {
                os = OS.SOLARIS;*/
        }
        return os;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public String getDescription() {
        return description;
    }

    public String getUtilityProcess() {
        return utilityProcess;
    }

    @Override
    public String toString() {
        return description;
    }
}
