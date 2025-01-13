package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerPageCompte {
    @FXML
    public void onEditEmailBouton(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editEmailPopUp.fxml"));
        VBox pageEditEmail = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Modifier Email");
        stage.setScene(new Scene(pageEditEmail));
        stage.show();
    }
    @FXML
    public void onEditPasswordBouton(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editPasswordPopUp.fxml"));
        VBox pageEditPassword = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Modifier Mot de passe");
        stage.setScene(new Scene(pageEditPassword));
        stage.show();
    }
}
