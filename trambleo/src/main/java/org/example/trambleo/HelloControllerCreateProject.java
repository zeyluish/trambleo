package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloControllerCreateProject {

    @FXML
    TextField nomProjet;
    @FXML
    TextField descriptionProjet;
    @FXML
    DatePicker dateDebutProjet;
    @FXML
    DatePicker dateFinProjet;
    @FXML
    ComboBox<Employe> choixEmploye;


    @FXML
    public void initialize() {
        Employe.importEmploye();
        choixEmploye.getItems().addAll(Employe.listeEmploye);
    }

    @FXML
    public void onCreerProjetButtonClick() throws IOException {
        String nomProjetText = nomProjet.getText();
        String descriptionProjetText = descriptionProjet.getText();
        LocalDate dateDebutProjetDate = dateDebutProjet.getValue();
        LocalDate dateFinProjetDate = dateFinProjet.getValue();
        Projet nouveauProjet = Administrateur.creerProjet(nomProjetText,descriptionProjetText,dateDebutProjetDate,dateFinProjetDate);//Appel de la fonction pour créer un projet
        System.out.println(nouveauProjet);
    }

    @FXML
    public void onAssocierEmployeButtonClick(){

    }
    public void onAnnulerButtonClick(){ //Fermer la pop up
        Stage stage = (Stage) nomProjet.getScene().getWindow();
        stage.close();
    }
}
