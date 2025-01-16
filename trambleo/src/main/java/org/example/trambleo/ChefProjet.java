package org.example.trambleo;

import java.time.LocalDate;

import static org.example.trambleo.Projet.projetSelected;

public class ChefProjet extends Employe {
    static ChefProjet chefProjetSelected;

    public ChefProjet(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.poste = "chefProjet";
    }

    @Override
    public String toString() {
        return "ChefProjet{" +
                "isDansEquipe=" + isDansEquipe +
                ", isSupprime=" + isSupprime +
                ", listeProjet=" + listeProjet +
                ", poste='" + poste + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", email='" + email + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", idUtilisateur=" + idUtilisateur +
                '}';
    }
/*
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
*/
    public static void modifierProjet( Projet projet, String nouveauNom, String nouvelleDescription, LocalDate nouvelleDateFin,String nouveauStatut) {
        projet.nomProjet = nouveauNom;
        projet.descriptionProjet = nouvelleDescription;
        projet.dateFinProjet = nouvelleDateFin;
        projet.statutProjet = nouveauStatut;
        Projet.modifierCSV(projet);
    }

    public static Tache creerTache(Projet projet, String nomTache, String description, String priorite, LocalDate dateFin, String etat) {
        projet = projetSelected;
        Tache tache = new Tache(nomTache, description, priorite, dateFin, etat);
        tache.projetAssocie = projet;
        projet.listeTache.add(tache);
        return tache;
    }

    public static void modifierTache( Tache tache, String nouveauNom, String nouvelleDescription, LocalDate nouvelleDateFin,String nouveauStatut) {
        tache.nomTache = nouveauNom;
        tache.descriptionTache = nouvelleDescription;
        tache.dateFinTache = nouvelleDateFin;
        tache.priorite = nouveauStatut;
        //Projet.modifierCSV(projet);
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
