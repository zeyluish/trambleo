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
    ArrayList<sousTache> listeSousTache;

    public Tache( String nomTache, String descriptionTache, String priorite, LocalDate dateFinTache) {
        this.idTache = UUID.randomUUID();
        this.nomTache = nomTache;
        this.descriptionTache = descriptionTache;
        this.priorite = priorite;
        this.dateFinTache = dateFinTache;
        this.listeEmployeTache = new ArrayList<>();
        this.listeSousTache = new ArrayList<>();
        this.listeCommentaire = new ArrayList<>();
        this.isSupprime = false;
    }

    public String toString() {
        return "identifiant : " + idTache + ", nom : " + nomTache + ", description : " + descriptionTache + ", priorité : " + priorite + ", date de fin : " + dateFinTache;
    }

    public void supprimerTache() { //Sur l'interface graphique on fera disparaitre la tache
        this.isSupprime = true;
        System.out.println("La tâche a bien été supprimée");
    }

    public void attribuerEmploye(Employe employe){
        if (!listeEmployeTache.contains(employe)) {
            listeEmployeTache.add(employe);
            System.out.println(listeEmployeTache);
        } else {
            System.out.println("L'employé est déjà dans la liste");
        }
    }

    public void creerSousTache(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom de la sous-tâche : ");
        String nomSousTache = scanner.nextLine();
        sousTache nouvelleSousTache = new sousTache(nomSousTache);
        listeSousTache.add(nouvelleSousTache);
        nouvelleSousTache.tacheAssociee = this;
        System.out.println("La sous tâche a été créer");
    }

    public void changerDateFin(LocalDate nouvelleDateFin){
        this.dateFinTache = nouvelleDateFin;
        System.out.println("La date de fin a été modifié au : " + this.dateFinTache);

    }

    public void ajouterCommentaire(String nouveauCommentaire) {
        this.listeCommentaire.add(nouveauCommentaire);
        System.out.println("Le commentaire est : " + nouveauCommentaire);
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

    public ArrayList<sousTache> getListeSousTache() {
        return listeSousTache;
    }

    public void setListeSousTache(ArrayList<sousTache> listeSousTache) {
        this.listeSousTache = listeSousTache;
    }

    // </editor-fold>
}
