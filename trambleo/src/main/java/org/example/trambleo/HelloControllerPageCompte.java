package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerPageCompte {
    @FXML
    Label nomCompte;

    @FXML
    Label prenomCompte;

    @FXML
    Label email;

    @FXML
    Label posteCompte;

    @FXML
    HBox historiqueProjet;

    String emailUtilisateur;


    //@FXML
    public void initialize() {
        if (Developpeur.developpeurSelected != null) {
            Developpeur devCompte = Developpeur.developpeurSelected;
            nomCompte.setText(devCompte.getNom());
            prenomCompte.setText(devCompte.getPrenom());
            email.setText(devCompte.getEmail());
            posteCompte.setText(devCompte.getPoste());
            emailUtilisateur = devCompte.getEmail();
        } else if (Administrateur.administrateurSelected != null) {
            Administrateur adminCompte = Administrateur.administrateurSelected;
            nomCompte.setText(adminCompte.getNom());
            prenomCompte.setText(adminCompte.getPrenom());
            email.setText(adminCompte.getEmail());
            posteCompte.setText(adminCompte.getPoste());
            emailUtilisateur = adminCompte.getEmail();
        } else if (ChefProjet.chefProjetSelected != null) {
            ChefProjet chefCompte = ChefProjet.chefProjetSelected;
            nomCompte.setText(chefCompte.getNom());
            prenomCompte.setText(chefCompte.getPrenom());
            email.setText(chefCompte.getEmail());
            posteCompte.setText(chefCompte.getPoste());
            emailUtilisateur = chefCompte.getEmail();
        }
        Projet.importProjet();
        historiqueProjet.getChildren().clear();

        for (Projet projet : Projet.listeProjet) {
            if (projet.emailEmployeProjet.contains(emailUtilisateur)&& projet.statutProjet.equals("Termine")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-carteProjet.fxml"));
                    VBox carte = loader.load();

                    HelloControllerCarteProjet controller = loader.getController();
                    controller.adapterTitre(projet);

                    carte.setOnMouseClicked(event -> {
                        try {
                            Projet.projetSelected = projet;
                            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("viewInProject.fxml"));
                            Parent projectView = loader2.load();
                            ControllerViewInpProject controllerViewInpProject = loader2.getController();
                            controllerViewInpProject.adapterProjet(projet.nomProjet, projet.descriptionProjet, projet.dateFinProjet);
                            Stage currentStage = (Stage) historiqueProjet.getScene().getWindow();
                            currentStage.setScene(new Scene(projectView));
                        } catch (IOException e) {
                            System.out.println("Erreur lors de l'ouverture du projet : " + e.getMessage());
                            e.printStackTrace();
                        }
                    });

                    historiqueProjet.getChildren().add(carte);
                    HBox.setMargin(carte, new Insets(10, 10, 10, 10));
                } catch (IOException e) {
                    System.out.println("Erreur lors du chargement de la carte : " + e.getMessage());
                }
            }
        }
    }

    @FXML
    public void onEditEmailBouton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("editEmailPopUp.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onEditPasswordBouton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("editPasswordPopUp.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


}
