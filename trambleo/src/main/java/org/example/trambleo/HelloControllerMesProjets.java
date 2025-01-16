package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerMesProjets {

    @FXML
    GridPane carteProjet;
    @FXML
    Button boutonCreerProjet;

    Projet projetSelected;
    Developpeur devSelected;
    Administrateur adminSelected;
    ChefProjet chefSelected;
    String emailUtilisateur;

    public void initialize() {
        if (Developpeur.developpeurSelected != null || ChefProjet.chefProjetSelected != null) {
            boutonCreerProjet.setVisible(false);
        }
        if (Developpeur.developpeurSelected != null) {
            devSelected = Developpeur.developpeurSelected;
            emailUtilisateur = devSelected.getEmail();
        } else if (ChefProjet.chefProjetSelected != null) {
            chefSelected = ChefProjet.chefProjetSelected;
            emailUtilisateur = chefSelected.getEmail();
        } else if (Administrateur.administrateurSelected != null) {
            adminSelected = Administrateur.administrateurSelected;
            emailUtilisateur = adminSelected.getEmail();
        }

        Projet.importProjet(); // Récupérer les projets du CSV
        carteProjet.getChildren().clear();
        carteProjet.setAlignment(Pos.CENTER);
        carteProjet.setHgap(20);
        carteProjet.setVgap(50);
        carteProjet.setPadding(new Insets(20, 20, 20, 20));

        int colonne = 0;
        int ligne = 0;

        for (Projet projet : Projet.listeProjet) {
            if (projet.emailEmployeProjet.contains(emailUtilisateur)) {
                try {
                    System.out.println(projet.emailEmployeProjet);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-carteProjet.fxml")); // Ajouter une carte pour chaque projet
                    VBox carte = loader.load();

                    HelloControllerCarteProjet controller = loader.getController();
                    controller.adapterTitre(projet); // Changer l'apparence de la carte selon le projet

                    carte.setOnMouseClicked(event -> {
                        try {
                            Projet.projetSelected = projet;
                            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("viewInProject.fxml"));
                            Parent projectView = loader2.load();
                            ControllerViewInpProject controllerViewInpProject = loader2.getController();
                            controllerViewInpProject.setControllerMesProjets(this);
                            controllerViewInpProject.adapterProjet(projet.nomProjet, projet.descriptionProjet, projet.dateFinProjet);
                            Stage currentStage = (Stage) carteProjet.getScene().getWindow();
                            currentStage.setScene(new Scene(projectView));
                        } catch (IOException e) {
                            System.out.println("Erreur de l'application");
                            e.printStackTrace();
                        }
                    });

                    carteProjet.add(carte, colonne, ligne);
                    GridPane.setMargin(carte, new Insets(10, 10, 10, 10));

                    colonne++;
                    if (colonne == 5) {
                        colonne = 0;
                        ligne++;
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (Projet.listeProjet.size() < 5) {
                carteProjet.setAlignment(Pos.CENTER);
            }
        }
    }


    public void onNouveauProjetButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createProject.fxml")));
        Scene scene = new Scene(loader.load());
        HelloControllerCreateProject controllerCreateProject = loader.getController();
        controllerCreateProject.setControllerMesProjets(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
