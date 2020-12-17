package ro.rainy.jusbootable.model;

import java.io.File;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 17/12/2020__21:37
 */
public interface BFileChooserModel {
    void setSelectedFile(File file);
    File getSelectedFile();
}