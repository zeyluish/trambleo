package org.example.trambleo;

import java.util.UUID;

public class sousTache {
    UUID idSousTache;
    String nomSousTache;

    boolean isChecked;
    boolean isSupprime;
    public Tache tacheAssociee;

    public sousTache(String nomSousTache) {
        this.idSousTache = UUID.randomUUID();
        this.nomSousTache = nomSousTache;
        this.isChecked = false;
        this.isSupprime = false;
    }

    public void creerSousTache(String nom) {
        sousTache sousTacheCreer = new sousTache(nom);
    }

    public String toString(){
        return "identifiant : " + idSousTache + ", nom :" + nomSousTache + ", est completé ?  :" + isChecked;
    }

    public void modifierNom(String nouveauNom){
        this.nomSousTache = nouveauNom;
        System.out.println("Le nom a bien été modifié");
    }

    public void supprimerSousTache(){
        this.isSupprime = true;
        System.out.println("La sous tâche a été supprimée");
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


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    // </editor-fold>
}
