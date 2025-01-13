package org.example.trambleo;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelloControllerCreateTask {

    ArrayList<Employe> employeChoisi =  new ArrayList<>();

    @FXML
    TextField nomTache;

    @FXML
    TextField descTache;

    @FXML
    RadioButton radFaible;

    @FXML
    RadioButton radMoyenne;

    @FXML
    RadioButton radEleve;

    @FXML
    DatePicker dateFin;

    @FXML
    ComboBox<Employe> comboEmploye;

    @FXML
    Label messageConfirmation;

    @FXML
    public void initialize() {
        Employe.importEmploye();
        comboEmploye.getItems().addAll(Employe.listeEmploye);
    }

    @FXML
    public void onAttribuerEmployeBouton() throws IOException {
        Employe employeSelectionne = comboEmploye.getSelectionModel().getSelectedItem();
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

    String prioriteTache;

    @FXML
    public void onFaible() throws IOException {
        String prioriteTache = "Faible";
    }

    @FXML
    public void onMoyenne() throws IOException {
        String prioriteTache = "Moyenne";
    }

    @FXML
    public void onEleve() throws IOException {
        String prioriteTache = "Eleve";
    }

    //^^^^^^^^^^^^^^^^^^//
    //Essayer de voir si c'est possible de selectionner d'un radiobutton

    @FXML
    public void onCreerTacheBouton() throws IOException {
        /*String nomTacheText = nomTache.getText();
        String descriptionTacheText = descTache.getText();
        LocalDate dateFinTacheDate = dateFin.getValue();
        Projet nouvelleTache = ChefProjet.creerTache(nomProjet,nomTacheText,descriptionTacheText,prioriteTache,dateFinTacheDate);
        for (Employe employe : employeChoisi) {
            nouvelleTache.listeEmploye.add(employe);
        }
        System.out.println(nouvelleTache);*/
        messageConfirmation.setText("La tâche a bien été créée");
    }

    //^^^^^^^^^^^^^^^^^^^//
    // Faire en sorte que le nomProjet soit défini et ça devrait marcher

    public void onAnnulerTacheBouton(){ //Fermer la pop up
        Stage stage = (Stage) dateFin.getScene().getWindow();
        stage.close();
    }
}
