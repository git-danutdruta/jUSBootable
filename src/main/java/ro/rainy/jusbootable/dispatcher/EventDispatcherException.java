package ro.rainy.jusbootable.dispatcher;

public class EventDispatcherException extends RuntimeException {
    public EventDispatcherException(Throwable throwable) {
        super(throwable);
    }
}