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

    private Projet projet;

    public void onAnnulerButtonClick(){
        Stage stage = (Stage) nomProjet.getScene().getWindow();
        stage.close();
    }

    public void setProjet(Projet projet){
        this.projet = projet;
        nomProjet.setText(projet.getNomProjet());
        descriptionProjet.setText(projet.getDescriptionProjet());
        dateFinProjet.setValue(projet.getDateFinProjet());
        statutEnCours.setSelected(projet.getStatutProjet().equals("En cours"));
        statutEnRetard.setSelected(projet.getStatutProjet().equals("En retard"));
        statutTermine.setSelected(projet.getStatutProjet().equals("Termine"));

    }

    public void onModifierButtonClick(){

    }
}
