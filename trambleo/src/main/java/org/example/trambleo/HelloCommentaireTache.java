package org.example.trambleo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloCommentaireTache {
    @FXML
    TextField commentaire;


    @FXML
    public void onAnnulerButtonClick(){
        Stage stage = (Stage) commentaire.getScene().getWindow();
        stage.close();

    }
    @FXML
    public void onAjouterButtonClick(){
        String commentaireTache = commentaire.getText();
        Tache tacheSelect = Tache.tacheSelected;
        tacheSelect.listeCommentaire.add(commentaireTache);
        System.out.println(tacheSelect.getListeCommentaire());
        Stage stage = (Stage) commentaire.getScene().getWindow();
        stage.close();
    }
}
