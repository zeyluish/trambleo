package org.example.trambleo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerMesProjets {
    public void onNouveauProjetButtonClick() throws IOException { //Ouvrir la page du compte
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createProject.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
