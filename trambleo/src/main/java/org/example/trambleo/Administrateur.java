package org.example.trambleo;

import java.time.LocalDate;
import java.util.Locale;

public class Administrateur extends Employe {
    public Administrateur(String nom, String prenom, String email, String motDePasse, String poste) {
        super(nom, prenom, email, motDePasse, poste);
        this.poste = "administrateur";
    }

    public static Projet creerProjet(String nomProjet, String descriptionProjet, LocalDate dateDebutProjet, LocalDate dateFinProjet) {
        Projet nouveauProjet = new Projet(nomProjet,descriptionProjet,dateDebutProjet,dateFinProjet);
        System.out.println("Le projet a bien été créé");
        return nouveauProjet;
    }
    public static void modifierProjet(Projet projet, String attribut, String nouvelleValeur) {
        switch (attribut.toLowerCase()) {
            case "nomprojet":
                projet.nomProjet = nouvelleValeur;
                break;
            case "descriptionprojet":
                projet.descriptionProjet = nouvelleValeur;
                break;
        }
    }
    public static void modifierDateProjet(Projet projet, String attribut, LocalDate nouvelleDate) {
        switch (attribut.toLowerCase()) {
            case "datedebut":
                projet.dateDebutProjet = nouvelleDate;
                break;
            case "datefin":
                projet.dateFinProjet = nouvelleDate;
        }
    }
    public void supprimerProjet(Projet projet){
        projet.isSupprime = true;
        System.out.println("Le projet a bien été supprimé");
    }
    public void attribuerEmploye(){


    }
    public void modifierPoste(Employe employe, String nouveauPoste){
        employe.poste = nouveauPoste;
    }
    public void supprimerPoste(Employe employe){
        employe.poste = null;
        System.out.println("Le poste de l'employé a bien été supprimé");

    }
    public void virerEmploye(Employe employe){
        employe.isSupprime = true;
        System.out.println("L'employé a bien été viré");
    }
}