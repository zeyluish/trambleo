package org.example.trambleo;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Projet {
    UUID idProjet = UUID.randomUUID();
    String nomProjet;
    String descriptionProjet;
    Date dateDebutProjet;
    Date dateFinProjet;
    boolean statutProjet;
    ArrayList<Tache> listeTache = new ArrayList<>();
    ArrayList<Employe> listeEmploye = new ArrayList<>();

    public Projet(String nomProjet, String descriptionProjet, Date dateDebutProjet, Date dateFinProjet) {
        this.nomProjet = nomProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
    }

    // <editor-fold desc="Getters and setters">

    public UUID getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(UUID idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public Date getDateDebutProjet() {
        return dateDebutProjet;
    }

    public void setDateDebutProjet(Date dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public Date getDateFinProjet() {
        return dateFinProjet;
    }

    public void setDateFinProjet(Date dateFinProjet) {
        this.dateFinProjet = dateFinProjet;
    }

    public boolean isStatutProjet() {
        return statutProjet;
    }

    public void setStatutProjet(boolean statutProjet) {
        this.statutProjet = statutProjet;
    }

    public ArrayList<Tache> getListeTache() {
        return listeTache;
    }

    public void setListeTache(ArrayList<Tache> listeTache) {
        this.listeTache = listeTache;
    }

    public ArrayList<Employe> getListeEmploye() {
        return listeEmploye;
    }

    public void setListeEmploye(ArrayList<Employe> listeEmploye) {
        this.listeEmploye = listeEmploye;
    }

    // </editor-fold>

    public String toString() {
        return "Identifiant : " + idProjet + "\nNom du Projet : " + nomProjet + "\nDescription du Projet : " + descriptionProjet + "\nDate de début : " + dateDebutProjet + "\nDate de fin : " + dateFinProjet + "\nStatut : " + statutProjet + "\nListe des tâches : " + listeTache + "\nListe des employes : " + listeEmploye + "\n";
    }


}
