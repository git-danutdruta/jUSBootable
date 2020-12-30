package ro.rainy.jusbootable;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import ro.rainy.jusbootable.handler.ApplicationStartHandler;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 30/12/2020__21:33
 */
public class ApplicationStarterTest extends ContextHolder {
    private ApplicationStarter target;
    private ApplicationStartHandler applicationStartedHandler1;
    private ApplicationStartHandler applicationStartedHandler2;

    @Before
    public void setUp() {
        target = new ApplicationStarterImpl();

        applicationStartedHandler1 = context.mock(ApplicationStartHandler.class, "applicationStartedHandler1");
        applicationStartedHandler2 = context.mock(ApplicationStartHandler.class, "applicationStartedHandler2");
    }

    @Test
    public void triggeredListenersOnApplicationStartTest() {
        target.whenApplicationStart(applicationStartedHandler1);
        target.whenApplicationStart(applicationStartedHandler2);

        context.checking(new Expectations() {{
            oneOf(applicationStartedHandler1).applicationStarted();
            oneOf(applicationStartedHandler2).applicationStarted();
        }});

        target.start();
    }
}