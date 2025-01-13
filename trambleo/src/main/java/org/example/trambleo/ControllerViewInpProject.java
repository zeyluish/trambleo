package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class ControllerViewInpProject {
    @FXML
    Label nomProjet;
    @FXML
    Label dateFinProjet;

    public void adapterProjet(String nom, LocalDate dateFin) {
        nomProjet.setText(nom);
        String dateFinProjet2 = dateFin.toString();
        dateFinProjet.setText(dateFinProjet2);
    }
}
