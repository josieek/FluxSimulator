package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Controller.WelcomeController;
import org.example.view.WelcomeView;

public class Main extends Application {

    @Override
    public void start(final Stage stage) {
        WelcomeController controller = new WelcomeController(stage);
        WelcomeView view = new WelcomeView(controller);
        try {
            stage.setTitle("start");
            stage.setScene(view.load());
            stage.show();
            controller.run();
        } catch (IllegalStateException exc) {
            System.err.println("Unable to load GUI " + exc);
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}