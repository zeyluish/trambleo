package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloControllerCreateTask {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}