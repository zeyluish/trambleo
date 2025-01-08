package org.example.trambleo;

import java.util.ArrayList;
import java.util.UUID;

public class Categorie {
    UUID idCategorie = UUID.randomUUID();
    String nomCategorie;
    ArrayList<Tache> listeTache = new ArrayList<>();
    boolean isSupprime;

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
        this.isSupprime = false;
    }

    // <editor-fold desc="Getters and setters">

    public UUID getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(UUID idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public ArrayList<Tache> getListeTache() {
        return listeTache;
    }

    public void setListeTache(ArrayList<Tache> listeTache) {
        this.listeTache = listeTache;
    }

    // </editor-fold>

    public String toString() {
        return "Identifiant : " + idCategorie + "\nNom du categorie : " + nomCategorie + "\nListe de tache : " + listeTache;
    }

    public void creerCategorie(String nomCategorie) {
        Categorie categorie = new Categorie(nomCategorie);
    }

    public void modifierCategrie(String nouveauNom) {
        this.nomCategorie = nouveauNom;
        System.out.println("Le nouveau nom de cette catégorie est " + this.nomCategorie + ".");
    }

    public void supprimerCategorie(String nomCategorie) {
        this.isSupprime = true;
        System.out.println("La catégorie " + nomCategorie + " a bien été supprimée.");
    }
}
