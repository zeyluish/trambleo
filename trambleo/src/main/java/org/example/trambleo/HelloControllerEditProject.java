package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerEditProject {
    @FXML
    TextField nomProjet;
    @FXML
    TextField descriptionProjet;
    @FXML
    DatePicker dateFinProjet;
    @FXML
    CheckBox statutEnCours;
    @FXML
    CheckBox statutEnRetard;
    @FXML
    CheckBox statutTermine;

    public void onAnnulerButtonClick(){
        Stage stage = (Stage) nomProjet.getScene().getWindow();
        stage.close();
    }
}
