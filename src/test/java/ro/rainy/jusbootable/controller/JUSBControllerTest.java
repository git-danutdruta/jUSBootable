package ro.rainy.jusbootable.controller;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import ro.rainy.jusbootable.ContextHolder;
import ro.rainy.jusbootable.InstanceCatcher;
import ro.rainy.jusbootable.handler.ExceptionThrownHandler;
import ro.rainy.jusbootable.handler.InfoDataHandler;
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

    private InstanceCatcher<VisibilityChangeHandler> visibilityChangeHandlerCatcher;
    private InstanceCatcher<ExceptionThrownHandler> exceptionThrownHandlerInstanceCatcher;
    private InstanceCatcher<InfoDataHandler> infoDataHandlerInstanceCatcher;

    @Before
    public void setUp() {
        model = context.mock(JUSBModel.class);
        view = context.mock(JUSBView.class);

        visibilityChangeHandlerCatcher = new InstanceCatcher<>();
        exceptionThrownHandlerInstanceCatcher = new InstanceCatcher<>();
        infoDataHandlerInstanceCatcher = new InstanceCatcher<>();

        context.checking(new Expectations() {
            {
                oneOf(model).whenExceptionThrown(with(exceptionThrownHandlerInstanceCatcher));
                oneOf(model).whenInfoSend(with(infoDataHandlerInstanceCatcher));
                oneOf(model).whenVisibilityChange(with(visibilityChangeHandlerCatcher));
            }
        });

//        new JUSBController(view, model);
    }

    @Test
    public void test() {
    }

}