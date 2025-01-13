package org.example.trambleo;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class ControllerEditEmailPopUp {

    @FXML
    TextField ancienEmail;
    @FXML
    TextField nouveauEmail;
    @FXML
    TextField confirmerEmail;


    public void onModifierEmailBoutonClick() throws IOException {
        String ancienEmailText = ancienEmail.getText();
        String nouveauEmailText = nouveauEmail.getText();

    }
}
