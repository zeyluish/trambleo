package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerMesProjets {

    @FXML
    HBox carteProjet;

    public void initialize() {
        Projet.importProjet();
        carteProjet.getChildren().clear();
        for (Projet projet : Projet.listeProjet){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-carteProjet.fxml"));
                VBox carte = loader.load();

                HelloControllerCarteProjet controller = loader.getController();
                controller.adapterTitre(projet);

                // Ajouter la carte au conteneur
                carteProjet.getChildren().add(carte);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void onNouveauProjetButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createProject.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
