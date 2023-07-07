package org.example.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.example.Controller.SphereController;
import org.example.Controller.WelcomeController;

import java.io.IOException;

public class WelcomeView implements ViewInterface{
    private FXMLLoader loader;
    public WelcomeView(WelcomeController controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("welcome.fxml"));
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