package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerMesProjets {

    @FXML
    HBox carteProjet;
    @FXML
    Button boutonCreerProjet;

    Projet projetSelected;

    public void initialize() {
        if (Developpeur.developpeurSelected != null || ChefProjet.chefProjetSelected != null) {
            boutonCreerProjet.setVisible(false);
        }

        Projet.importProjet(); //Récupérer les projets du CSV
        carteProjet.getChildren().clear();
        for (Projet projet : Projet.listeProjet){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-carteProjet.fxml")); //Ajouter une carte pour chaque projet
                VBox carte = loader.load();

                HelloControllerCarteProjet controller = loader.getController();
                controller.adapterTitre(projet); //Changer l'apparence de la carte selon le projet

                carte.setOnMouseClicked(event -> {
                    try {
                        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("viewInProject.fxml"));
                        Parent projectView = loader2.load();
                        Projet.projetSelected = projet;
                        ControllerViewInpProject controllerViewInpProject = loader2.getController();
                        controllerViewInpProject.adapterProjet(projet.nomProjet,projet.dateFinProjet);
                        Stage currentStage = (Stage) carteProjet.getScene().getWindow();
                        currentStage.setScene(new Scene(projectView));
                    } catch (IOException e) {
                        System.out.println("Erreur de l'application");
                        e.printStackTrace();
                    }
                });

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
