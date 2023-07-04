module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    requires jdk.jfr;
    requires java.desktop;
    requires java.logging;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;

    requires java.sql;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.view;
    opens org.example.view to javafx.fxml;
}

