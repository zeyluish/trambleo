package org.example.trambleo;

import java.util.UUID;

public class sousTache {
    UUID idSousTache;
    String nomSousTache;
    String descriptionSousTache;
    boolean isChecked;
    public Tache tacheAssociee;

    public sousTache(String nomSousTache, String descriptionSousTache) {
        this.idSousTache = UUID.randomUUID();
        this.nomSousTache = nomSousTache;
        this.descriptionSousTache = descriptionSousTache;
        this.isChecked = false;
    }

    public String toString(){
        return "identifiant : " + idSousTache + ", nom :" + nomSousTache + ", description :" + descriptionSousTache + ", est completé ?  :" + isChecked;
    }

    public void modifierSousTache(String attribut, String nouvelleValeur){
        switch (attribut.toLowerCase()){
            case "nom":
                this.nomSousTache = nouvelleValeur;
                break;
            case "description" :
                this.descriptionSousTache = nouvelleValeur;
                break;
        }
    }

    public void supprimerSousTache(){

    }
    public void terminerSousTache(){
        this.isChecked = true;
        System.out.println("La sous tâche a été terminée");
    }

    // <editor-fold desc="Getter and setter">
    public UUID getIdSousTache() {
        return idSousTache;
    }

    public void setIdSousTache(UUID idSousTache) {
        this.idSousTache = idSousTache;
    }

    public String getNomSousTache() {
        return nomSousTache;
    }

    public void setNomSousTache(String nomSousTache) {
        this.nomSousTache = nomSousTache;
    }

    public String getDescriptionSousTache() {
        return descriptionSousTache;
    }

    public void setDescriptionSousTache(String descriptionSousTache) {
        this.descriptionSousTache = descriptionSousTache;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    // </editor-fold>
}
