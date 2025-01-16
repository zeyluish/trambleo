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

    private HelloControllerMesProjets controllerMesProjets;

    public void setControllerMesProjets( HelloControllerMesProjets controllerMesProjets) {
        this.controllerMesProjets = controllerMesProjets;
    }

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
        ArrayList<String> emailEmployeProjet = new ArrayList<>();
        String statutProjet = "En cours";
        if (nomProjetText.equals("") || descriptionProjetText.equals("") || dateDebutProjetDate == null || dateFinProjetDate == null) { //Vérification de mise en forme
            messageConfirmation.setText("Il faut que tout les champs soient remplis");
            return;
        }
        if (dateDebutProjetDate.isAfter(dateFinProjetDate)) {
            messageConfirmation.setText("La date de fin doit être après la date de début");
            return;
        }
        Projet nouveauProjet = Administrateur.creerProjet(nomProjetText,descriptionProjetText,dateDebutProjetDate,dateFinProjetDate, statutProjet,emailEmployeProjet );//Appel de la fonction pour créer un projet
        for (Employe employe : employeChoisi) {
            System.out.println("Employe : " + employe);
            nouveauProjet.listeEmploye.add(employe);
            employe.listeProjet.add(nouveauProjet);
        }
        Projet.saveProjet(nouveauProjet);
        System.out.println(nouveauProjet);
        controllerMesProjets.initialize();
        Stage stage = (Stage) nomProjet.getScene().getWindow();
        stage.close(); //Fermer la pop up
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
        Stage stage = (Stage) dateFinProjet.getScene().getWindow();
        stage.close();
    }
}
