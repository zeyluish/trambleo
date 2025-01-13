package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    public void onCreerProjetButtonClick() throws IOException {
        String nomProjetText = nomProjet.getText();
        String descriptionProjetText = descriptionProjet.getText();
        LocalDate dateDebutProjetDate = dateDebutProjet.getValue();
        LocalDate dateFinProjetDate = dateFinProjet.getValue();
        Projet nouveauProjet = Administrateur.creerProjet(nomProjetText,descriptionProjetText,dateDebutProjetDate,dateFinProjetDate);
        System.out.println(nouveauProjet);

    }
}
