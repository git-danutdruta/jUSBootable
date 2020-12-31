package ro.rainy.jusbootable;

import org.junit.Before;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 31/12/2020__18:40
 */
public class JUSBCoordinatorTest extends ContextHolder{

    private ApplicationStarter applicationStarter;

    @Before
    public void setUp(){
        applicationStarter = context.mock(ApplicationStarter.class);
    }


}