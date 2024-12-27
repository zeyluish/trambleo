package org.example.trambleo;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Tache {
    UUID idTache;
    String nomTache;
    String descriptionTache;
    String commentaire;
    String priorite;
    Date dateFinTache;
    Categorie categorie;
    ArrayList<Employe> listeEmployeTache;

    public Tache(UUID idTache, String nomTache, String descriptionTache, String commentaire, String priorite, Date dateFinTache, Categorie categorie, ArrayList<Employe> listeEmployeTache) {
        this.idTache = idTache;
        this.nomTache = nomTache;
        this.descriptionTache = descriptionTache;
        this.commentaire = commentaire;
        this.priorite = priorite;
        this.dateFinTache = dateFinTache;
        this.categorie = categorie;
        this.listeEmployeTache = listeEmployeTache;
    }

    public String toString() {
        return "identifiant : " + idTache + ", nom : " + nomTache + ", description : " + descriptionTache + ", commentaire : " + commentaire + ", priorité : " + priorite + ", date de fin : " + dateFinTache + ", categorie : " + categorie;
    }

    // <editor-fold desc="Getter and setter">
    public UUID getIdTache() {
        return idTache;
    }

    public void setIdTache(UUID idTache) {
        this.idTache = idTache;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public Date getDateFinTache() {
        return dateFinTache;
    }

    public void setDateFinTache(Date dateFinTache) {
        this.dateFinTache = dateFinTache;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public ArrayList<Employe> getListeEmployeTache() {
        return listeEmployeTache;
    }

    public void setListeEmployeTache(ArrayList<Employe> listeEmployeTache) {
        this.listeEmployeTache = listeEmployeTache;
    }
    // </editor-fold>
}
