package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ControllerCarteTache {

    @FXML
    Label nomTache;

    @FXML
    Label dateTache;

    @FXML
    HBox carteTache;

    @FXML
    Circle cercleStatut;

    Projet projetSelected;

    public void adapterNomTache(Tache tache) {
        nomTache.setText(tache.getNomTache());
        String dateFin = tache.dateFinTache.toString();
        dateTache.setText(dateFin);
        if (tache.priorite.equals("Moyenne")){
            cercleStatut.setFill(Color.web("#FF9D00"));
        } else if (tache.priorite.equals("Elevée")){
            cercleStatut.setFill(Color.web("#FF0004"));
        } else if (tache.priorite.equals("Faible")){
            cercleStatut.setFill(Color.web("#17B702"));
        }
    }
}
