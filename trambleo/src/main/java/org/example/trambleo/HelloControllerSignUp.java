package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloControllerSignUp {
    @FXML
    public void onBoutonConnecter(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-loginpage.fxml"));
        VBox pageConnexion = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Se connecter");
        stage.setScene(new Scene(pageConnexion));
        stage.show();
        }

    public void onBoutonCreer(MouseEvent event) throws IOException {
        System.out.println("Creer compte");
    }
}