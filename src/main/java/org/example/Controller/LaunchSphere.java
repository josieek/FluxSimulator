package org.example.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.SphereView;

public class LaunchSphere extends Application {
    @Override
    public void start(Stage stage) {
        SphereController sphereController = new SphereController(stage);
        SphereView sphereView = new SphereView(sphereController);
        try {
            // load and place the view's scene onto the stage
            stage.setTitle("sphere");
            stage.setScene(sphereView.load());

            sphereController.run();

            // render the stage
            stage.show();
        } catch (IllegalStateException exc) {
            System.err.println("Unable to load GUI.");
        }
    }

}
