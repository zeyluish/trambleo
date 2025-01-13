package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloControllerLoginPage {
    @FXML
    public void onBoutonCreer1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-signuppage.fxml"));
        VBox pageCreation = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Créer un compte");
        stage.setScene(new Scene(pageCreation));
        stage.show();
    }

    public void onBoutonConnecter1(MouseEvent event) throws IOException {
        System.out.println("Se connecter");
    }
}