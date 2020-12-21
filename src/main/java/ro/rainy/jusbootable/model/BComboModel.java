package ro.rainy.jusbootable.model;

import javax.swing.*;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__14:42
 */
public interface BComboModel<T> extends ComboBoxModel<T> {
    void addElement(T element);
    void removeElement(T element);
}