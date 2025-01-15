package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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


    //@FXML
    public void initialize() {
        if (Developpeur.developpeurSelected != null) {
            Developpeur devCompte = Developpeur.developpeurSelected;
            nomCompte.setText(devCompte.getNom());
            prenomCompte.setText(devCompte.getPrenom());
            email.setText(devCompte.getEmail());
            posteCompte.setText(devCompte.getPoste());
        } else if (Administrateur.administrateurSelected != null) {
            Administrateur adminCompte = Administrateur.administrateurSelected;
            nomCompte.setText(adminCompte.getNom());
            prenomCompte.setText(adminCompte.getPrenom());
            email.setText(adminCompte.getEmail());
            posteCompte.setText(adminCompte.getPoste());
        } else if (ChefProjet.chefProjetSelected != null) {
            ChefProjet chefCompte = ChefProjet.chefProjetSelected;
            nomCompte.setText(chefCompte.getNom());
            prenomCompte.setText(chefCompte.getPrenom());
            email.setText(chefCompte.getEmail());
            posteCompte.setText(chefCompte.getPoste());
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
