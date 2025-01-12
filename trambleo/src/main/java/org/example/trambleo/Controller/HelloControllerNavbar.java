package org.example.trambleo.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerNavbar {
    @FXML
    public void onCompteButtonClick(MouseEvent event) throws IOException { //Ouvrir la page du compte
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-pageCompte.fxml"));
        VBox pageCompte = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Mon Compte");
        stage.setScene(new Scene(pageCompte));
        stage.show();
    }

    public void onProjetButtonClick(MouseEvent event) throws IOException { //Ouvrir la page des projets
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-mesProjets.fxml"));
        VBox pageProjet = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Mon Compte");
        stage.setScene(new Scene(pageProjet));
        stage.show();
    }
}
