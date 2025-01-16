package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ControllerRondEmploye {
    @FXML
    Label employeNom;

    @FXML
    VBox  rondEmploye;

    public void adapterEmail(String email) {
        employeNom.setText(email);
    }
}
