package ro.rainy.jusbootable.controller;

import org.junit.Before;
import org.junit.Test;
import ro.rainy.jusbootable.ContextHolder;
import ro.rainy.jusbootable.handler.ExceptionThrownHandler;
import ro.rainy.jusbootable.handler.VisibilityChangeHandler;
import ro.rainy.jusbootable.model.JUSBModel;
import ro.rainy.jusbootable.view.JUSBView;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 30/12/2020__21:25
 */
public class JUSBControllerTest extends ContextHolder {
    private JUSBView view;
    private JUSBModel model;

    private VisibilityChangeHandler visibilityChangeHandler;
    private ExceptionThrownHandler exceptionThrownHandler;

    @Before
    public void setUp() {
        model = context.mock(JUSBModel.class);
        view = context.mock(JUSBView.class);
    }

    @Test
    public void test() {

    }
}