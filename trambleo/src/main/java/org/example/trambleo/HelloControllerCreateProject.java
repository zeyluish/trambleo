package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelloControllerCreateProject {

    ArrayList<Employe> employeChoisi =  new ArrayList<>();
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
    Label messageConfirmation;


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
        for (Employe employe : employeChoisi) {
            nouveauProjet.listeEmploye.add(employe);
        }
        System.out.println(nouveauProjet);
        messageConfirmation.setText("Le projet a bien été créé");
    }

    @FXML
    public void onAssocierEmployeButtonClick(){
        Employe employeSelectionne = choixEmploye.getSelectionModel().getSelectedItem();
        if (employeSelectionne == null) {
            messageConfirmation.setText("Veuillez sélectionner un employé.");
            return;
        }
        if (employeChoisi.contains(employeSelectionne)) {
            messageConfirmation.setText("L'employé " + employeSelectionne.prenom + " " + employeSelectionne.nom + " est déjà dans la liste.");
        } else {
            employeChoisi.add(employeSelectionne);
            messageConfirmation.setText("L'employé " + employeSelectionne.prenom + " " + employeSelectionne.nom + " a bien été ajouté.");
        }
    }

    public void onAnnulerButtonClick(){ //Fermer la pop up
        Stage stage = (Stage) nomProjet.getScene().getWindow();
        stage.close();
    }
}
