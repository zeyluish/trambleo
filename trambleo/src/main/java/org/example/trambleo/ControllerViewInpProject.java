package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    Tache tacheSelected;

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
        stage.setTitle("Vue calendrier");
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
//        Projet projet = Projet.projetSelected;
//        ArrayList<Tache> listeTache = projet.listeTache;
//        VBox VBoxAFaire = new VBox();
//
//        for (Tache tache : listeTache) {
//            VBoxAFaire.getChildren().add(new Button(tache.nomTache));
//        }
//        Scene scene = new Scene(VBoxAFaire);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
    }

    public void initialize() {
        Projet projet = Projet.projetSelected;
        VBoxAFaire.getChildren().clear();
        for(Tache tache : projet.listeTache) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("carteTache.fxml"));
                VBox carte = loader.load();
                ControllerCarteTache controllerCarteTache = loader.getController();
                controllerCarteTache.adapterNomTache(tache);
                carte.setOnMouseClicked(mouseEvent -> {
                    try {
                        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("hello-editTask.fxml"));
                        Parent taskView = loader2.load();
                        Tache.tacheSelected = tache;
                        ControllerInfoTache controllerInfoTache = loader2.getController();
                        controllerInfoTache.adapterTache(tache.nomTache, tache.descriptionTache, tache.priorite, tache.dateFinTache, tache.listeEmployeTache);
                        Stage currentStage = (Stage) VBoxAFaire.getScene().getWindow();
                        currentStage.setScene(new Scene(taskView));
                    } catch (IOException e) {
                        System.out.println("Erreur de l'application");
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
