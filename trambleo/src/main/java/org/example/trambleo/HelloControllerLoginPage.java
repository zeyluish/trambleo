package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloControllerLoginPage {

    @FXML
    TextField emailLogin;
    @FXML
    TextField passwordLogin;
    @FXML
    public void onBoutonCreer1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-signuppage.fxml"));
        VBox pageCreation = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Récupérer la fenetre actuelle.
        stage.setTitle("Créer un compte");
        stage.setScene(new Scene(pageCreation));
        stage.show();
    }

    public void onBoutonConnecter1(MouseEvent event) throws IOException {
        String loginUser = emailLogin.getText();
        String passwordUser = passwordLogin.getText();
        boolean correctLog = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Employe.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values[3].equals(loginUser) && values[4].equals(passwordUser)) {
                    correctLog = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (correctLog) {
            System.out.println("La combinaison est correcte");
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("hello-mesProjets.fxml"));
            Parent projectView = loader2.load();
            Stage currentStage = (Stage) passwordLogin.getScene().getWindow();
            currentStage.setScene(new Scene(projectView));
        } else {
            System.out.println("La combinaison est incorrecte");
        }

    }
}