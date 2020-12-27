package ro.rainy.jusbootable.dispatcher;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 27/12/2020__23:21
 */
@RunWith(JUnit4.class)
public class EventDispatcherTest {
    JUnit4Mockery context = new JUnit4Mockery();
    private TestListener testListener;

    @Before
    public void setUp() {
        testListener = context.mock(TestListener.class, "testListener");
    }

    @Test
    public void dispatchMethodTriggerListenerBehaviorTest() {
        EventDispatcher<TestListener> updateListenerEventDispatcher = new EventDispatcher<>("test");
        updateListenerEventDispatcher.addListener(testListener);

        context.checking(new Expectations() {{
            oneOf(testListener).test();
        }});

        updateListenerEventDispatcher.dispatch();
    }


    interface TestListener {
        void test();
    }
}
