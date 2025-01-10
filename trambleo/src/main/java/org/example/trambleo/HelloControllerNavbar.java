package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerNavbar {
    @FXML
    public void onCompteButtonClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-pageCompte.fxml"));
        VBox pageCompte = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Mon Compte");
        stage.setScene(new Scene(pageCompte));
        stage.show();
    }

    public void onProjetButtonClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-mesProjets.fxml"));
        VBox pageProjet = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Mon Compte");
        stage.setScene(new Scene(pageProjet));
        stage.show();
    }
}
