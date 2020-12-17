package ro.rainy.jusbootable;

import ro.rainy.jusbootable.handler.ApplicationStartHandler;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 08/12/2020__23:05
 */
public interface ApplicationStarter {
    void whenApplicationStart(ApplicationStartHandler startHandler);

    void start();
}
