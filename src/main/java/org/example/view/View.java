package org.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class View {
    private FXMLLoader loader;
    View(Controller controller) {
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