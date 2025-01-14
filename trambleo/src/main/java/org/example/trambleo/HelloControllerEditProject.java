package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

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
    @FXML
    Label messageConfirmation;

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
        String nouveauNomProjet = nomProjet.getText();
        String nouvelleDescriptionProjet = descriptionProjet.getText();
        LocalDate nouvelleDateFinProjet = dateFinProjet.getValue();
        String nouveauStatutProjet = statutEnCours.isSelected() ? "En cours" : statutEnRetard.isSelected() ? "En retard" : statutTermine.isSelected() ? "Termine" : null;
        if (!nouveauNomProjet.equals("") && !nouvelleDescriptionProjet.equals("") && nouvelleDateFinProjet != null) {
            ChefProjet.modifierProjet(projet, nouveauNomProjet, nouvelleDescriptionProjet,nouvelleDateFinProjet, nouveauStatutProjet);
            Projet.projetSelected = projet;
            Stage stage = (Stage) nomProjet.getScene().getWindow();
            stage.close();

        } else {
            messageConfirmation.setText("Il faut remplir tout les champs");
        }
    }
}
