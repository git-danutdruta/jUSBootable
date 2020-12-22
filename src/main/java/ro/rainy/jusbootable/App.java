package ro.rainy.jusbootable;

import ro.rainy.jusbootable.controller.JUSBController;
import ro.rainy.jusbootable.model.JUSBModel;
import ro.rainy.jusbootable.model.impl.JUSBModelImpl;
import ro.rainy.jusbootable.view.JUSBView;
import ro.rainy.jusbootable.view.impl.JUSBViewImpl;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        ApplicationStarter starter = new ApplicationStarterImpl();

        JUSBView view = new JUSBViewImpl("<:: jUSBootable ::>");
        JUSBModel model = new JUSBModelImpl();
        JUSBController controller = new JUSBController(view, model);

        JUSBCoordinator coordinator = new JUSBCoordinator(starter, model);

        starter.start();
    }
}