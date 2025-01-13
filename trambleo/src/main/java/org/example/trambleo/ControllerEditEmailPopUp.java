package org.example.trambleo;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEditEmailPopUp {

    @FXML
    TextField ancienEmail;

    @FXML
    TextField nouveauEmail;

    @FXML
    TextField confirmerEmail;

    public void onModifierEmailBoutonClick() throws IOException {

    }

    public void onAnnulerBoutonClick(){
        Stage stage = (Stage) ancienEmail.getScene().getWindow();
        stage.close();
    }
}
