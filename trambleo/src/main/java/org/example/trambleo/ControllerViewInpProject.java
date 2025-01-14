package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import org.controlsfx.control.action.Action;

import java.awt.event.MouseEvent;
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

    public void onVueCalendrierButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-vueCalendrier.fxml"));
        VBox pageCalendrier = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Mon Compte");
        stage.setScene(new Scene(pageCalendrier));
        stage.show();
    }
}
