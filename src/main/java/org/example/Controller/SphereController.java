package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class SphereController implements ControllerInterface {
    private Stage stage;
    private ArrayList<StackPane> posCharges;
    private ArrayList<StackPane> negCharges;

    @FXML
    private Button posButton;
    @FXML
    private Button negButton;

    @FXML
    private Sphere sphere;

    @FXML
    private HBox hBox;

    @FXML
    private Button delPos;

    @FXML
    private Button delNeg;

    @FXML
    private Label answer;

    @FXML
    private Button backButton;


    public SphereController(Stage stage) {
        this.posCharges = new ArrayList<StackPane>();
        this.negCharges = new ArrayList<StackPane>();
        this.stage = stage;
    }

    public void run() {
        this.negButton.setStyle("-fx-background-color: #4169E1");
        this.delNeg.setStyle("-fx-background-color: #4169E1");
        this.posButton.setStyle("-fx-background-color: #DC143C");
        this.delPos.setStyle("-fx-background-color: #DC143C");
        this.delPos.setDisable(true);
        this.delNeg.setDisable(true);
        HBox.setHgrow(this.hBox, Priority.ALWAYS);
        this.backButton.setOnAction(e -> {
            LaunchWelcome launchWelcome = new LaunchWelcome();
            launchWelcome.start(this.stage);
        });
        this.posButton.setOnAction(e -> {
            StackPane charge = this.createCharge("+", Color.valueOf("#DC143C"));
            this.posCharges.add(charge);
            this.hBox.getChildren().add(charge);
            if(this.posCharges.size() + this.negCharges.size() >= 4) {
                this.posButton.setDisable(true);
                this.negButton.setDisable(true);
            }
            this.setAnswer();
            this.delPos.setDisable(false);
        });
        this.negButton.setOnAction(e -> {
            StackPane charge = this.createCharge("-", Color.valueOf("#4169E1"));
            this.hBox.getChildren().add(charge);
            this.negCharges.add(charge);
            if(this.posCharges.size() + this.negCharges.size() >= 4) {
                this.posButton.setDisable(true);
                this.negButton.setDisable(true);
            }
            this.setAnswer();
            this.delNeg.setDisable(false);
        });
        this.delPos.setOnAction(e -> {
            this.delPosCharge();
            this.setAnswer();
        });
        this.delNeg.setOnAction(e -> {
            this.delNegCharge();
            this.setAnswer();
        });
    }

    private StackPane createCharge(String charge, Color color) {
        StackPane stack = new StackPane();
        Circle posCharge = new Circle(10, color);
        Text text = new Text(charge);
        stack.getChildren().addAll(posCharge, text);
        return stack;
    }

    private void delPosCharge() {
        if(this.posCharges.size() > 0 ) {
            this.hBox.getChildren().remove(this.posCharges.get(0));
            this.posCharges.remove(0);
            if(this.posCharges.size() <= 0) {
                this.delPos.setDisable(true);
            }
            this.posButton.setDisable(false);
            this.negButton.setDisable(false);
        }
    }

    private void delNegCharge() {
        if(this.negCharges.size() > 0 ) {
            this.hBox.getChildren().remove(this.negCharges.get(0));
            this.negCharges.remove(0);
            if(this.negCharges.size() <= 0) {
                this.delNeg.setDisable(true);
            }
        }
        this.negButton.setDisable(false);
        this.posButton.setDisable(false);
    }

    private double flux() {
        double flux = (((this.posCharges.size() - this.negCharges.size()) * 1.6 * Math.pow(10, -19))
                / (8.9 * Math.pow(10, -12))) * Math.pow(10, 9);
        return flux;
    }

    private void setAnswer() {
        BigDecimal bd = new BigDecimal(Double.toString(this.flux()));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        this.answer.setText(bd.doubleValue() + " nWb");
    }

}
