package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class WelcomeController {
    private Stage stage;
    @FXML
    private Button startSphere;

    @FXML
    private Button startPlane;

    public WelcomeController(Stage stage) {
        this.stage = stage;
    }

    public void run() {
        this.startSphere.setShape(new Circle(30));
        this.startSphere.setMaxSize(60, 60);
        this.startSphere.setOnAction(e -> {
            LaunchSphere launchSphere = new LaunchSphere();
            launchSphere.start(this.stage);
        });
        this.startPlane.setOnAction(e -> {
            LaunchPlane launchPlane = new LaunchPlane();
            launchPlane.start(this.stage);
        });
    }
}
