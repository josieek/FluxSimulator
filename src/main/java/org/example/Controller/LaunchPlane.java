package org.example.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.PlaneView;
import org.example.view.SphereView;

public class LaunchPlane extends Application {
    @Override
    public void start(Stage stage) {
        PlaneController planeController = new PlaneController(stage);
        PlaneView planeView = new PlaneView(planeController);
        try {
            // load and place the view's scene onto the stage
            stage.setTitle("sphere");
            stage.setScene(planeView.load());

            planeController.run();

            // render the stage
            stage.show();
        } catch (IllegalStateException exc) {
            System.err.println("Unable to load GUI.");
        }
    }

}
