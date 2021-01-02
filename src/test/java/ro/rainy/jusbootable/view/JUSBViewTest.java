package ro.rainy.jusbootable.view;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import ro.rainy.jusbootable.ContextHolder;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 02/01/2021__19:17
 */
public class JUSBViewTest extends ContextHolder {
    private JUSBView view;

    @Before
    public void setUp() {
        view = context.mock(JUSBView.class);
    }

    @Test
    public void setVisibilityOnViewTest() {
        context.checking(new Expectations() {{
            oneOf(view).setVisible(true);
            oneOf(view).setVisible(false);
        }});
    }
}