package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import org.controlsfx.control.action.Action;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerViewInpProject {
    @FXML
    Label nomProjet;
    @FXML
    Label dateFinProjet;

    @FXML
    VBox VBoxAFaire;

    public void adapterProjet(String nom, LocalDate dateFin) {
        nomProjet.setText(nom);
        String dateFinProjet2 = dateFin.toString();
        dateFinProjet.setText(dateFinProjet2);
    }

    public void onModifierProjetButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-editProject.fxml")));
        Scene scene = new Scene(loader.load());
        HelloControllerEditProject controller = loader.getController();
        controller.setProjet(Projet.projetSelected);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onVueCalendrierButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-vueCalendrier.fxml"));
        VBox pageCalendrier = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Mon Compte");
        stage.setScene(new Scene(pageCalendrier));
        stage.show();
    }

    public void onAddTacheAFaire() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createtask.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public  void onAddTacheEnCours() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createtask.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onAddTacheFait() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createtask.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onRefreshBoutonClick() throws IOException {
        Projet projet = Projet.projetSelected;
        ArrayList<Tache> listeTache = projet.listeTache;
        VBox VBoxAFaire = new VBox();

        for (Tache tache : listeTache) {
            VBoxAFaire.getChildren().add(new Button(tache.nomTache));
        }
        Scene scene = new Scene(VBoxAFaire);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
