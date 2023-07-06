package org.example.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class Arrow {
    private static final double ARROW_LENGTH = 100.0;
    private static final double ARROW_WIDTH = 10.0;

    private Pane root;

    public Arrow() {
        Pane arrow = new Pane();
        Line line = new Line(0, 0, ARROW_LENGTH, 0);
        line.setStrokeWidth(2);
        line.setFill(Color.CORNFLOWERBLUE);
        line.setStroke(Color.CORNFLOWERBLUE);
        Polygon arrowhead = new Polygon();
        arrowhead.getPoints().addAll(
                (double) ARROW_LENGTH, 0.0,
                (double) ARROW_LENGTH - ARROW_WIDTH, - ARROW_WIDTH / 2,
                (double) ARROW_LENGTH - ARROW_WIDTH, ARROW_WIDTH / 2
        );
        arrowhead.setFill(Color.CORNFLOWERBLUE);
        arrow.getChildren().addAll(line, arrowhead);
        this.root = arrow;
    }

    public Pane getArrow() {
        return this.root;
    }



}
