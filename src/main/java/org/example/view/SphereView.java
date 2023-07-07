package org.example.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.example.Controller.SphereController;

import java.io.IOException;

public class SphereView implements ViewInterface {
    private FXMLLoader loader;
    public SphereView(SphereController controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("GaussGui.fxml"));
        this.loader.setController(controller);
    }

    public Scene load() throws IllegalStateException {
        try {
            return this.loader.load();
        } catch (IOException exc) {
            throw new IllegalStateException("Unable to load layout." + exc);
        }
    }
}
