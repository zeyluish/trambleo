package org.example.trambleo;

import java.time.LocalDate;

public class ChefProjet extends Employe {

    public ChefProjet(String nom, String prenom, String email, String motDePasse, String poste) {
        super(nom, prenom, email, motDePasse, poste);
    }

    @Override
    public String toString() {
        return "ChefProjet{" +
                "isDansEquipe=" + isDansEquipe +
                ", isSupprime=" + isSupprime +
                ", listeProjet=" + listeProjet +
                ", role='" + role + '\'' +
                ", poste='" + poste + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", email='" + email + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", idUtilisateur=" + idUtilisateur +
                '}';
    }

    public static void attribuerEmployeEquipe(Equipe equipe, Employe employe) {
        equipe.listeMembre.add(employe);
        employe.isDansEquipe = true;
        System.out.println("L'employé" + employe.prenom + " " + employe.nom + " a bien été ajouté à l'équipe " + equipe.nomEquipe + ".");
    }

    public static void retirerEmployeEquipe(Equipe equipe, Employe employe) {
        equipe.listeMembre.remove(employe);
        employe.isDansEquipe = false;
        System.out.println("L'employé" + employe.prenom + " " + employe.nom + " a bien été retiré de l'équipe " + equipe.nomEquipe + ".");
    }

    public static void creerEquipe(String nomEquipe) {
        Equipe nouvelleEquipe = new Equipe(nomEquipe);
        System.out.println("L'équipe a bien été créee");
    }

    public static void modifierEquipe(Equipe equipe, String nouveauNomEquipe) {
        equipe.nomEquipe = nouveauNomEquipe;
        System.out.println("L'équipe a bien été modifié");
    }

    public static void attribuerProjetEquipe(Equipe equipe, Projet projet) {
        equipe.isProjetAssocie = true;
        projet.isEquipeAssocie = true;
        System.out.println("L'équipe " + equipe.nomEquipe + " a bien été attribuée au projet " + projet.nomProjet + ".");
    }

    public static void retirerProjetEquipe(Equipe equipe, Projet projet) {
        equipe.isProjetAssocie = false;
        projet.isEquipeAssocie = false;
        System.out.println("L'équipe " + equipe.nomEquipe + " a bien été retirée du projet " + projet.nomProjet + ".");
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

    public static void creerTache(Projet projet, String nomTache, String description, String priorite, LocalDate dateFin) {
        Tache tache = new Tache(nomTache, description, priorite, dateFin);
        tache.projetAssocie = projet;
        projet.listeTache.add(tache);
    }

    public static void modifierTache(Tache tache, String attribut, String nouvelleValeur) {
        switch (attribut.toLowerCase()){
            case "nom":
                tache.nomTache = nouvelleValeur;
                break;
            case "description" :
                tache.descriptionTache = nouvelleValeur;
                break;
            case "priorite":
                tache.priorite = nouvelleValeur;
                break;
        }
    }

    public static void modifierDateTache(Tache tache, String attribut, LocalDate dateFin) {
        switch (attribut.toLowerCase()){
            case "datedebut":
                tache.dateFinTache = dateFin;
                break;
        }
    }

    public static void supprimerTache(Projet projet, Tache tache) {
        tache.isSupprime = true;
        //tache.projetAssocie = null; je ne sais pas si je valide cette ligne car si on veut faire un système de recover c'est mieux que la tache même si elle est supprimer qu'elle reste associée à un projet ou alors on fait une corbeille dans le modèle d'un projet et on associe donc la tache à la corbeille.
        projet.listeTache.remove(tache);
    }

    public static void attribuerEmployeTache(Tache tache, Employe employe) {
        tache.listeEmployeTache.add(employe);
    }

    public static void retirerEmployeTache(Tache tache, Employe employee) {
        tache.listeEmployeTache.remove(employee);
    }

    public static void modifierStatutProjet(Projet projet, String statutProjet) {
        projet.statutProjet = statutProjet;
    }
    
}
