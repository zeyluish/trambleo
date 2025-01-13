package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void onModifierProjetButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-editProject.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
