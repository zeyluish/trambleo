package org.example.trambleo;

public class Developpeur extends Employe{

    static Developpeur developpeurSelected;

    public Developpeur(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.poste = "developpeur";
    }

    public void creerSousTache(String nomSousTache){
        sousTache sousTache = new sousTache(nomSousTache);
        System.out.println("La sous tache a bien été créer");
    }
    public void terminerSousTache(sousTache sousTache){
        sousTache.isChecked = true;
        System.out.println("La sous tache a bien été terminé");

    }
    public void supprimerSousTache(sousTache sousTache){
        sousTache.isSupprime = true;
        System.out.println("La sous tache a été supprimée");

    }
    public void modifierSousTache(sousTache sousTache, String nouveauNom){
        sousTache.nomSousTache = nouveauNom;
        System.out.println("Le nom a bien été modifié");

    }
    public void modifierPrioriteTache(Tache tache, String nouvellePriorite){
        tache.priorite = nouvellePriorite;
        System.out.println("La priorité a bien été changé");
    }
    public void ajouterCommentaire(String commentaire, Tache tache){
        tache.listeCommentaire.add(commentaire);
        System.out.println("Le commentaire a bien été ajouté");
    }
}
