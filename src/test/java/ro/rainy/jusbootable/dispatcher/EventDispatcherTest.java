package ro.rainy.jusbootable.dispatcher;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import ro.rainy.jusbootable.ContextHolder;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 27/12/2020__23:21
 */
public class EventDispatcherTest extends ContextHolder {

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
