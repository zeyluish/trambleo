package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerInfoTache {

    @FXML
    Label nomTache;

    @FXML
    Label descTache;

    @FXML
    Label prioriteTache;

    @FXML
    Label dateFinTache;

    @FXML
    Label listEmploye;

    public void adapterTache(String nom, String desc, String pri, LocalDate date, ArrayList<Employe> liste) {
        nomTache.setText(nom);
        descTache.setText(desc);
        prioriteTache.setText(pri);
        String dateFin = date.toString();
        dateFinTache.setText(dateFin);
        String listeEmploye = liste.toString();
        listEmploye.setText(listeEmploye);
    }
}
