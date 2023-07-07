package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.example.view.Arrow;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class PlaneController implements ControllerInterface {
    private Stage stage;

    @FXML
    private Button increaseButton;

    @FXML
    private Button decreaseButton;

    @FXML
    private VBox vBox;

    @FXML
    private Label answer;

    @FXML
    private Button increaseArea;
    @FXML
    private Button decreaseArea;
    @FXML
    private Rectangle plane;
    @FXML
    private Button backButton;

    private ArrayList<Pane> arrows;
    private double width;

    private static double area = 0.5;

    public PlaneController(Stage stage) {
        this.stage = stage;
        this.arrows = new ArrayList<Pane>();
    }

    public void run() {
        this.increaseButton.setStyle("-fx-background-color: #6495ED");
        this.decreaseButton.setStyle("-fx-background-color: #6495ED");
        this.increaseArea.setStyle("-fx-background-color: #C0C0C0");
        this.decreaseArea.setStyle("-fx-background-color: #C0C0C0");
        this.width = this.plane.getWidth();
        this.decreaseButton.setDisable(true);
        this.backButton.setOnAction(e -> {
            LaunchWelcome launchWelcome = new LaunchWelcome();
            launchWelcome.start(this.stage);
        });
        this.increaseButton.setOnAction(e -> {
            Pane arrow = new Arrow().getArrow();
            this.vBox.getChildren().add(arrow);
            this.arrows.add(arrow);
            this.decreaseButton.setDisable(false);
            this.disableIncrease();
            this.disableDecrease();
            this.setAnswer();
                });
        this.decreaseButton.setOnAction(e -> {
            this.vBox.getChildren().remove(this.arrows.get(0));
            this.arrows.remove(this.arrows.get(0));
            this.disableIncrease();
            this.disableDecrease();
            this.setAnswer();
        });
        this.increaseArea.setOnAction(e -> {
            this.width += 5;
            this.plane.setWidth(this.width);
            if(this.width >= 75) {
                this.increaseArea.setDisable(true);
            }
            this.decreaseArea.setDisable(false);
            this.setAnswer();
        });
        this.decreaseArea.setOnAction(e -> {
            this.width -= 5;
            this.plane.setWidth(this.width);
            if(this.width <= 0) {
                this.decreaseArea.setDisable(true);
            }
            this.increaseArea.setDisable(false);
            this.setAnswer();
        });
    }

    private void disableIncrease() {
        if(this.arrows.size() >= 10) {
            this.increaseButton.setDisable(true);
        } else {
            this.increaseButton.setDisable(false);
        }
    }

    private void disableDecrease() {
        if(this.arrows.size() <= 0) {
            this.decreaseButton.setDisable(true);
        }
    }

    private double flux() {
        return this.plane.getWidth() * this.plane.getHeight() * this.arrows.size() * Math.pow(10, -2);
    }

    private void setAnswer() {
        BigDecimal bd = new BigDecimal(Double.toString(this.flux()));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        this.answer.setText(bd.doubleValue() + " Wb");
    }
}
