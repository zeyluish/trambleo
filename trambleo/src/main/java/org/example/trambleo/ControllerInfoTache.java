package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerInfoTache {

    @FXML
    Label nomTache;

    @FXML
    Label descTache;

    @FXML
    Label prioriteTache;

    @FXML
    Label dateFinTache;

    @FXML
    Label listEmploye;

    public void adapterTache(String nom, String desc, String pri, LocalDate date, ArrayList<Employe> liste) {
        nomTache.setText(nom);
        descTache.setText(desc);
        prioriteTache.setText(pri);
        String dateFin = date.toString();
        dateFinTache.setText(dateFin);
        String listeEmploye = liste.toString();
        String employesString = "";
        for (Employe employe : liste) {
            employesString += employe.getNom() + " " + employe.getPrenom() + "\n";
        }
        listEmploye.setText(employesString);
    }

    @FXML
    public void onSupprimerTacheButton() {
    }
    public void onModifierTacheButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-editTask.fxml")));
        Scene scene = new Scene(loader.load());
        ControllerEditTask controller = loader.getController();
        controller.setTache(Tache.tacheSelected);
        //HelloControllerEditProject controllerEditProject = loader.getController();
        //controllerEditProject.setControllerViewInpProject(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
    public void onAjouterCommentaireButton(){

    }
}
