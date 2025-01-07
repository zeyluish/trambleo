package org.example.trambleo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
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
    ArrayList<sousTache> listeSousTache;

    public Tache( String nomTache, String descriptionTache, String priorite, Date dateFinTache, Categorie categorie) {
        this.idTache = UUID.randomUUID();
        this.nomTache = nomTache;
        this.descriptionTache = descriptionTache;
        this.priorite = priorite;
        this.dateFinTache = dateFinTache;
        this.categorie = categorie;
        this.listeEmployeTache = new ArrayList<>();
        this.listeSousTache = new ArrayList<>();
    }

    public String toString() {
        return "identifiant : " + idTache + ", nom : " + nomTache + ", description : " + descriptionTache + ", priorité : " + priorite + ", date de fin : " + dateFinTache + ", categorie : " + categorie;
    }

    public void modifierTache(String attribut, String nouvelleValeur) {
        switch (attribut.toLowerCase()){
            case "nom":
                this.nomTache = nouvelleValeur;
                break;
            case "description" :
                this.descriptionTache = nouvelleValeur;
                break;
            case "priorite":
                this.priorite = nouvelleValeur;
                break;
            case "date" : //Pas sure de ça
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    this.dateFinTache = sdf.parse(nouvelleValeur);
                } catch (ParseException e) {
                    System.out.println("Format de date invalide.'dd-MM-yyyy'.");
                }
                break;
            case "categorie" :
                this.categorie = getCategorie(); //A changer
                break;
        }
    }

    public void supprimerTache() {

    }

    public void attribuerEmploye(Employe employe){
        if (!listeEmployeTache.contains(employe)) {
            listeEmployeTache.add(employe);
            System.out.println(listeEmployeTache);
        } else {
            System.out.println("L'employé est déjà dans la liste");
        }
    }

    public void creerSousTache(sousTache sousTache){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom de la sous-tâche : ");
        String nomSousTache = scanner.nextLine();
        System.out.println("Entrez la description de la sous-tâche");
        String descriptionSousTache = scanner.nextLine();
        sousTache nouvelleSousTache = new sousTache(nomSousTache, descriptionSousTache);
        listeSousTache.add(nouvelleSousTache);
        sousTache.tacheAssociee = this;
        System.out.println("La sous tâche a été créer");
    }

    public void changerDateFin(){

    }

    public void ajouterCommentaire(String commentaire) {
        this.commentaire = commentaire;
        System.out.println("Le commentaire est : " + commentaire);
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
