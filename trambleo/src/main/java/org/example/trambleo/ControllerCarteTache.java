package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ControllerCarteTache {

    @FXML
    Label nomTache;

    @FXML
    Label dateTache;

    @FXML
    HBox carteTache;

    Projet projetSelected;

    public void adapterNomTache(Tache tache) {
        nomTache.setText(tache.getNomTache());
    }
}
