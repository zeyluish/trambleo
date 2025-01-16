package org.example.trambleo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Tache {
    UUID idTache;
    String nomTache;
    String descriptionTache;
    String priorite;
    LocalDate dateFinTache;
    boolean isSupprime;
    Projet projetAssocie;
    ArrayList<String> listeCommentaire;
    ArrayList<Employe> listeEmployeTache;
    static Tache tacheSelected;

    public Tache( String nomTache, String descriptionTache, String priorite, LocalDate dateFinTache) {
        this.idTache = UUID.randomUUID();
        this.nomTache = nomTache;
        this.descriptionTache = descriptionTache;
        this.priorite = priorite;
        this.dateFinTache = dateFinTache;
        this.listeEmployeTache = new ArrayList<>();
        this.listeCommentaire = new ArrayList<>();
        this.isSupprime = false;
    }

    public String toString() {
        return "identifiant : " + idTache + ", nom : " + nomTache + ", description : " + descriptionTache + ", priorité : " + priorite + ", date de fin : " + dateFinTache;
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


    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public LocalDate getDateFinTache() {
        return dateFinTache;
    }

    public void setDateFinTache(LocalDate dateFinTache) {
        this.dateFinTache = dateFinTache;
    }

    public ArrayList<Employe> getListeEmployeTache() {
        return listeEmployeTache;
    }

    public void setListeEmployeTache(ArrayList<Employe> listeEmployeTache) {
        this.listeEmployeTache = listeEmployeTache;
    }

    public ArrayList<String> getCommentaire() {
        return listeCommentaire;
    }

    public void setCommentaire(ArrayList<String> commentaire) {
        this.listeCommentaire = commentaire;
    }

    public boolean isSupprime() {
        return isSupprime;
    }

    public void setSupprime(boolean supprime) {
        isSupprime = supprime;
    }

    public Projet getProjetAssocie() {
        return projetAssocie;
    }

    public void setProjetAssocie(Projet projetAssocie) {
        this.projetAssocie = projetAssocie;
    }

    public ArrayList<String> getListeCommentaire() {
        return listeCommentaire;
    }

    public void setListeCommentaire(ArrayList<String> listeCommentaire) {
        this.listeCommentaire = listeCommentaire;
    }

    public static Tache getTacheSelected() {
        return tacheSelected;
    }

    public static void setTacheSelected(Tache tacheSelected) {
        Tache.tacheSelected = tacheSelected;
    }

    // </editor-fold>
}
