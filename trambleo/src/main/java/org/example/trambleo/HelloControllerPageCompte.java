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

    private Employe employeSelected;

    @FXML
    public void initialize() {
        nomCompte.setText(employeSelected.getNom());
        prenomCompte.setText(employeSelected.getPrenom());
        email.setText(employeSelected.getEmail());
        posteCompte.setText(employeSelected.getPoste());

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
