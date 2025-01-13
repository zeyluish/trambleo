package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloControllerCarteProjet {

    @FXML
    Label titreProjetCarte;
    public void adapterTitre(Projet projet) {
        titreProjetCarte.setText(projet.getNomProjet());
    }
}
