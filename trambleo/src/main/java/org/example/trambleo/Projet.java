package org.example.trambleo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Projet {
    UUID idProjet = UUID.randomUUID();
    String nomProjet;
    String descriptionProjet;
    LocalDate dateDebutProjet;
    LocalDate dateFinProjet;
    String statutProjet;
    ArrayList<Tache> listeTache = new ArrayList<>();
    ArrayList<Employe> listeEmploye = new ArrayList<>();
    boolean isSupprime;
    boolean isEquipeAssocie;

    public Projet(String nomProjet, String descriptionProjet, LocalDate dateDebutProjet, LocalDate dateFinProjet) {
        this.nomProjet = nomProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
        this.isSupprime = false;
        this.isEquipeAssocie = false;
        this.statutProjet = "Nouveau Projet";
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

    public LocalDate getDateDebutProjet() {
        return dateDebutProjet;
    }

    public void setDateDebutProjet(LocalDate dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public LocalDate getDateFinProjet() {
        return dateFinProjet;
    }

    public void setDateFinProjet(LocalDate dateFinProjet) {
        this.dateFinProjet = dateFinProjet;
    }

    public String isStatutProjet() {
        return statutProjet;
    }

    public void setStatutProjet(String statutProjet) {
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

    public void creerProjet(String nomProjet, String descriptionProjet, LocalDate dateDebutProjet, LocalDate dateFinProjet) {
        Projet newProjet = new Projet(nomProjet, descriptionProjet, dateDebutProjet, dateFinProjet);
    }

    public void modifierProjet(String attribut, String nouvelleValeur) {
        switch (attribut.toLowerCase()) {
            case "nomprojet":
                this.nomProjet = nouvelleValeur;
                break;
            case "descriptionprojet":
                this.descriptionProjet = nouvelleValeur;
                break;
        }
    }

    public void modifierDateProjet(String attribut, LocalDate nouvelleDate) {
        switch (attribut.toLowerCase()) {
            case "datedebut":
                this.dateDebutProjet = nouvelleDate;
                break;
            case "datefin":
                this.dateFinProjet = nouvelleDate;
        }
    }

    public void supprimerProjet() {
        this.isSupprime = true;
        System.out.println("Le projet " + nomProjet + "a bien été supprimée.");
    }

    public  void attribuerEmploye(Employe employe) {
        listeEmploye.add(employe);
        employe.listeProjet.add(this);
    }

    public void changerDateDebut(LocalDate dateDebut) {
        this.dateDebutProjet = dateDebut;
    }

    public void changerDateFin(LocalDate dateFin) {
        this.dateFinProjet = dateFin;
    }
}
