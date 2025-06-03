package org.example.demotaskjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label sum;

    @FXML
    protected void onHelloButtonClick() {
        sum.setText("Welcome to JavaFX Application!");
    }
}