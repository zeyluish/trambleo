package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloControllerCarteProjet {

    @FXML
    Label titreProjetCarte;
    @FXML
    Label statutProjet;
    @FXML
    Circle rondStatutProjet;

    @FXML
    public void adapterTitre(Projet projet) {
        titreProjetCarte.setText(projet.getNomProjet());
        statutProjet.setText(projet.getStatutProjet());
        if (projet.statutProjet.equals("En cours")){
            rondStatutProjet.setFill(Color.web("#FF9D00"));
        } else if (projet.statutProjet.equals("En retard")){
            rondStatutProjet.setFill(Color.web("#FF0004"));
        } else if (projet.statutProjet.equals("Termine")){
            rondStatutProjet.setFill(Color.web("#17B702"));
        }
    }
}
