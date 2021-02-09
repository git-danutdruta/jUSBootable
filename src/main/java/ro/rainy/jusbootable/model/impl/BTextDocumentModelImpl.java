package ro.rainy.jusbootable.model.impl;

import ro.rainy.jusbootable.model.BTextDocumentModel;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import java.lang.reflect.InvocationTargetException;

/**
 * @project: jUSBootable
 * @author: daniel
 * @time: 08/02/2021  21:51
 */
public class BTextDocumentModelImpl implements BTextDocumentModel {
    private String text;

    @Override
    public void insertUpdate(DocumentEvent e) {
        dataUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        dataUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        dataUpdate(e);
    }

    private void dataUpdate(DocumentEvent e) {
        try {
            text = e.getDocument()
                    .getText(e.getDocument().getStartPosition().getOffset(),
                    e.getDocument().getEndPosition().getOffset() - 1);

        } catch (BadLocationException | SecurityException | IllegalArgumentException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public String getText() {
        return text;
    }
}