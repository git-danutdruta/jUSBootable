package ro.rainy.jusbootable.view.component;

import ro.rainy.jusbootable.model.BFileChooserModel;
import ro.rainy.jusbootable.model.impl.BFileChooserModelImpl;

import javax.swing.*;
import java.io.File;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 17/12/2020__21:36
 */
public class BFileChooser extends JFileChooser {
    private BFileChooserModel fileChooserModel;

    public BFileChooser() {
        super();
        fileChooserModel = new BFileChooserModelImpl();//todo replace with defaultFileChooserModel
    }

    @Override
    public void setSelectedFile(File file) {
        super.setSelectedFile(file);
        fileChooserModel.setSelectedFile(file);
    }

    public void setFileChooserModel(BFileChooserModel fileChooserModel) {
        this.fileChooserModel = fileChooserModel;
    }
}