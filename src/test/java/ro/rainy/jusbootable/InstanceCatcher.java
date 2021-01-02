package ro.rainy.jusbootable;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class InstanceCatcher<T> extends BaseMatcher<T> {
    private T instance;

    public T getInstance() {
        return instance;
    }

    public boolean matches(Object o) {
        try {
            instance = (T) o;
            return true;
        } catch (ClassCastException ex) {
            return false;
        }
    }

    public void describeTo(Description description) {
        description.appendText("any old Object");
    }
}