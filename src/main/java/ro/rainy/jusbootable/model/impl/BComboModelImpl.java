package ro.rainy.jusbootable.model.impl;

import ro.rainy.jusbootable.model.BComboModel;

import javax.swing.*;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__14:42
 */
public class BComboModelImpl<T> extends DefaultComboBoxModel<T> implements BComboModel<T> {

    public BComboModelImpl() {
    }

    public BComboModelImpl(T[] items) {
        super(items);
    }
}