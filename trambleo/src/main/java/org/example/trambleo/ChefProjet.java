package org.example.trambleo;

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

    public void attribuerEmployeEquipe(Employe employe) {
        
    }
}
