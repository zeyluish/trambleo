package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    Label descriptionProjet;
    @FXML
    Label dateFinProjet;
    @FXML
    VBox VBoxAFaire;
    @FXML
    VBox VBoxEnCours;
    @FXML
    VBox VBoxFait;
    @FXML
    HBox employeEncart;
    @FXML
    Button supprimerProjet;
    @FXML
    Button modifierProjet;

    Tache tacheSelected;
    private HelloControllerMesProjets controllerMesProjets;

    public void setControllerMesProjets(HelloControllerMesProjets controllerMesProjets) {
        this.controllerMesProjets = controllerMesProjets;
    }

    public void adapterProjet(String nom, String description, LocalDate dateFin) {
        nomProjet.setText(nom);
        descriptionProjet.setText(description);
        String dateFinProjet2 = dateFin.toString();
        dateFinProjet.setText(dateFinProjet2);
    }

    public void onModifierProjetButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-editProject.fxml")));
        Scene scene = new Scene(loader.load());
        HelloControllerEditProject controller = loader.getController();
        controller.setProjet(Projet.projetSelected);
        HelloControllerEditProject controllerEditProject = loader.getController();
        controllerEditProject.setControllerViewInpProject(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void onAddTacheAFaire() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createtask.fxml")));
        Scene scene = new Scene(loader.load());
        HelloControllerCreateTask controllerCreateTask = loader.getController();
        controllerCreateTask.setControllerViewInpProject(this);
        controllerCreateTask.setEtat("aFaire");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onAddTacheEnCours() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createtask.fxml")));
        Scene scene = new Scene(loader.load());
        HelloControllerCreateTask controllerCreateTask = loader.getController();
        controllerCreateTask.setControllerViewInpProject(this);
        controllerCreateTask.setEtat("enCours");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onAddTacheFait() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((this.getClass().getResource("hello-createtask.fxml")));
        Scene scene = new Scene(loader.load());
        HelloControllerCreateTask controllerCreateTask = loader.getController();
        controllerCreateTask.setControllerViewInpProject(this);
        controllerCreateTask.setEtat("fait");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onSupprimerButtonClick() throws IOException {
        Projet projetSelect = Projet.projetSelected;
        Projet.supprimerCSV(projetSelect);
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("hello-mesProjets.fxml"));
        Parent projectView = loader2.load();
        controllerMesProjets.initialize();
        Stage currentStage = (Stage) VBoxAFaire.getScene().getWindow();
        Projet.listeProjet.remove(projetSelect);
        currentStage.setScene(new Scene(projectView));
    }

    public void initialize() {
        Projet projet = Projet.projetSelected;

        if (Developpeur.developpeurSelected != null || ChefProjet.chefProjetSelected != null) {
            supprimerProjet.setVisible(false);
        }
        if (Developpeur.developpeurSelected != null) {
            modifierProjet.setVisible(false);
        }

        VBoxAFaire.getChildren().clear();
        VBoxAFaire.setSpacing(10);

        VBoxEnCours.getChildren().clear();
        VBoxEnCours.setSpacing(10);

        VBoxFait.getChildren().clear();
        VBoxFait.setSpacing(10);

        employeEncart.setSpacing(5);
        employeEncart.getChildren().clear();

        for (String email : projet.emailEmployeProjet) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("rondEmploye.fxml"));
                VBox rondEmploye = loader.load();

                ControllerRondEmploye controllerRondEmploye = loader.getController();
                controllerRondEmploye.adapterEmail(email);

                employeEncart.getChildren().add(rondEmploye);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Tache tache : projet.listeTache) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("carteTache.fxml"));
                VBox carte = loader.load();
                VBox.setMargin(carte, new Insets(0, 25, 0, 25));

                ControllerCarteTache controllerCarteTache = loader.getController();
                controllerCarteTache.adapterNomTache(tache);

                // Configurer un clic pour modifier la tâche
                carte.setOnMouseClicked(mouseEvent -> {
                    try {
                        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("infoTache.fxml"));
                        Parent taskView = loader2.load();

                        Tache.tacheSelected = tache;
                        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("hello-editTask.fxml"));
                        ControllerEditTask controllerEditTask = loader3.getController();
                        //controllerEditTask.setControllerViewInpProject(this);
                        ControllerInfoTache controllerInfoTache = loader2.getController();
                        controllerInfoTache.adapterTache(tache.nomTache, tache.descriptionTache, tache.priorite, tache.dateFinTache, tache.listeEmployeTache);
                        controllerInfoTache.setControllerViewInpProject(this);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(taskView));
                        stage.show();
                    } catch (IOException e) {
                        System.out.println("Erreur de l'application");
                        e.printStackTrace();
                    }
                });

                // Ajouter la carte au conteneur VBoxAFaire
                if ("aFaire".equals(tache.getEtat())) {
                    VBoxAFaire.getChildren().add(carte);
                } else if ("enCours".equals(tache.getEtat())) {
                    VBoxEnCours.getChildren().add(carte);
                } else if ("fait".equals(tache.getEtat())) {
                    VBoxFait.getChildren().add(carte);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
