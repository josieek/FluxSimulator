package org.example.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.SphereView;
import org.example.view.WelcomeView;

public class LaunchWelcome extends Application {
    @Override
    public void start(Stage stage) {
        WelcomeController welcomeController = new WelcomeController(stage);
        WelcomeView welcomeView = new WelcomeView(welcomeController);
        try {
            // load and place the view's scene onto the stage
            stage.setTitle("welcome");
            stage.setScene(welcomeView.load());

            welcomeController.run();

            // render the stage
            stage.show();
        } catch (IllegalStateException exc) {
            System.err.println("Unable to load GUI.");
        }
    }

}
