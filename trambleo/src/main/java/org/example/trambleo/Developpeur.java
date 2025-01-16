package org.example.trambleo;

public class Developpeur extends Employe{

    static Developpeur developpeurSelected;

    public Developpeur(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.poste = "developpeur";
    }

    public void ajouterCommentaire(String commentaire, Tache tache){
        tache.listeCommentaire.add(commentaire);
        System.out.println("Le commentaire a bien été ajouté");
    }
}
