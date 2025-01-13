package org.example.trambleo;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEditPasswordPopUp {

    @FXML
    TextField ancienPassword;
    @FXML
    TextField nouveauPassword;
    @FXML
    TextField confirmerPassword;

    @FXML
    public void onModifierPasswordBouton() throws IOException {
        System.out.println("valider");
    }

    @FXML
    public void onAnnulerBoutonClick(){
        Stage stage = (Stage) ancienPassword.getScene().getWindow();
        stage.close();
    }
}
