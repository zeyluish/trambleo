package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class ControllerEditTask {
    @FXML
    TextField nomTache;
    @FXML
    TextField descriptionTache;
    @FXML
    DatePicker dateFinTache;
    @FXML
    ToggleGroup groupPriorite;

    private Tache tache;
    String prioriteTache;

    private ControllerViewInpProject controllerViewInpProject;

    public void setControllerViewInpProject(ControllerViewInpProject controllerViewInpProject) {
        this.controllerViewInpProject = controllerViewInpProject;
    }

    @FXML
    public void setTache(Tache tache){
        this.tache = tache;
        nomTache.setText(tache.getNomTache());
        descriptionTache.setText(tache.getDescriptionTache());
        dateFinTache.setValue(tache.getDateFinTache());
    }

    public String getSelectedValue() throws IOException {
        RadioButton selectedRadioButton = (RadioButton) groupPriorite.getSelectedToggle();
        prioriteTache = selectedRadioButton.getText();
        System.out.println(prioriteTache);
        return prioriteTache;
    }

    public void onModifierTacheButton() throws IOException {
        String nouveauNomTache = nomTache.getText();
        String nouvelleDescriptionTache = descriptionTache.getText();
        LocalDate nouvelleDateFinTache = dateFinTache.getValue();
        String nouveauStatutTache = getSelectedValue();
        if (!nouveauNomTache.equals("") && !nouvelleDescriptionTache.equals("") && nouvelleDateFinTache != null) {
            ChefProjet.modifierTache(tache, nouveauNomTache, nouvelleDescriptionTache,nouvelleDateFinTache, nouveauStatutTache);
            //Projet.projetSelected = projet;
            Stage stage = (Stage) nomTache.getScene().getWindow();
            stage.close();
            //controllerViewInpProject.initialize();

        } else {
           // messageConfirmation.setText("Il faut remplir tout les champs");
        }
    }
    public void onAnnulerTacheButton(){
        Stage stage = (Stage) nomTache.getScene().getWindow();
        stage.close();
    }
}


