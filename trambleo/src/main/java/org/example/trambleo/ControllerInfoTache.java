package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    ListView<String> listEmploye;
    @FXML
    ListView<String> listCommentaire;

    private ControllerViewInpProject controllerViewInpProject;

    public void setControllerViewInpProject(ControllerViewInpProject controllerViewInpProject) {
        this.controllerViewInpProject = controllerViewInpProject;
    }

    public void adapterTache(String nom, String desc, String pri, LocalDate date, ArrayList<Employe> liste) {
        nomTache.setText(nom);
        descTache.setText(desc);
        prioriteTache.setText(pri);
        String dateFin = date.toString();
        dateFinTache.setText(dateFin);
        afficherEmployes();
        afficherCommentaires();
    }

    private void afficherCommentaires() {
        Tache tacheSelect = Tache.tacheSelected;
        listCommentaire.getItems().clear();
        for (String commentaire : tacheSelect.getListeCommentaire()) {
            listCommentaire.getItems().add(commentaire);
        }
    }
    private void afficherEmployes() {
        Tache tacheSelect = Tache.tacheSelected;
        listEmploye.getItems().clear();
        for (Employe employe : tacheSelect.getListeEmployeTache()) {
            String employeString = employe.getNom() + " " + employe.getPrenom();
            listEmploye.getItems().add(employeString);
        }
    }


    @FXML
    public void onSupprimerTacheButton() {
        Tache tacheSelect = Tache.tacheSelected;
        Projet projetSelect = Projet.projetSelected;
        projetSelect.listeTache.remove(tacheSelect);
        Stage stage = (Stage) nomTache.getScene().getWindow();
        stage.close();
        controllerViewInpProject.initialize();
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
    public void onAjouterCommentaireButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-commentaireTache.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
