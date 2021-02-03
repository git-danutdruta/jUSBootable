package ro.rainy.jusbootable.model.domain.os;

/**
 * @project: jUSBootable
 * @author: daniel
 * @time: 03/02/2021  19:25
 */
public enum OperatingSystem {
    WINDOWS("Windows"),
    MAC_OS("MacOS"),
    LINUX("Linux");

    private String description;

    OperatingSystem(String description) {
        this.description = description;
    }
}