package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    Label messageConfirmation;
    @FXML
    ToggleGroup groupPriorite;

    String prioriteProjet;


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
        //statutEnCours.setSelected(projet.getStatutProjet().equals("En cours"));
        //statutEnRetard.setSelected(projet.getStatutProjet().equals("En retard"));
        //statutTermine.setSelected(projet.getStatutProjet().equals("Termine"));

    }

    public String getSelectedValue() throws IOException {
        RadioButton selectedRadioButton = (RadioButton) groupPriorite.getSelectedToggle();
        prioriteProjet = selectedRadioButton.getText();
        System.out.println(prioriteProjet);
        return prioriteProjet;
    }

    public void onModifierButtonClick() throws IOException {
        String nouveauNomProjet = nomProjet.getText();
        String nouvelleDescriptionProjet = descriptionProjet.getText();
        LocalDate nouvelleDateFinProjet = dateFinProjet.getValue();
        String nouveauStatutProjet = getSelectedValue();
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
