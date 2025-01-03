package org.example.trambleo;

import java.util.ArrayList;
import java.util.UUID;

public class Categorie {
    UUID idCategorie = UUID.randomUUID();
    String nomCategorie;
    ArrayList<Tache> listeTache;

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
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
}
