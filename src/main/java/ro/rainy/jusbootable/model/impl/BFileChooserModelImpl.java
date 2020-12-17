package ro.rainy.jusbootable.model.impl;

import ro.rainy.jusbootable.model.BFileChooserModel;

import java.io.File;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 17/12/2020__21:37
 */
public class BFileChooserModelImpl implements BFileChooserModel {
    private File file;

    @Override
    public File getSelectedFile() {
        return file;
    }

    @Override
    public void setSelectedFile(File file) {
        this.file = file;
    }
}