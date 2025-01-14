package org.example.trambleo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Employe {
    UUID idUtilisateur = UUID.randomUUID();
    String nom;
    String prenom;
    String email;
    String motDePasse;
    String poste; // au sein de l'entreprise
    String role; // au sein du projet
    ArrayList<Projet> listeProjet = new ArrayList<Projet>();
    static ArrayList<Employe> listeEmploye = new ArrayList<>();
    boolean isSupprime;
    boolean isDansEquipe;

    public Employe(String nom, String prenom, String email, String motDePasse, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.poste = poste;
        this.isSupprime = false;
        this.isDansEquipe = false;
    }

    public static void  importEmploye() {
        String filePath = "src/main/resources/Employe.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    try {
                        UUID idUtilisateur = UUID.randomUUID();
                        String nom = parts[0];
                        String prenom = parts[1];
                        String email = parts[2];
                        String motDePasse = parts[3];
                        String poste = parts[4];
                        Employe employe = new Employe(nom, prenom, email, motDePasse, poste);
                        listeEmploye.add(employe);
                    } catch (NumberFormatException e) {
                        System.out.println("Erreur de conversion sur cette ligne : " + line);
                    }
                } else {
                    System.out.println("Ligne mal formée, ignorée : " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // <editor-fold desc="Getters and setters">

    public UUID getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(UUID idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Projet> getListeProjet() {
        return listeProjet;
    }

    public void setListeProjet(ArrayList<Projet> listeProjet) {
        this.listeProjet = listeProjet;
    }

    public boolean isSupprime() {
        return isSupprime;
    }

    public void setSupprime(boolean supprime) {
        isSupprime = supprime;
    }

    public boolean isDansEquipe() {
        return isDansEquipe;
    }

    public void setDansEquipe(boolean dansEquipe) {
        isDansEquipe = dansEquipe;
    }

    // </editor-fold>

    public String toString() {
        return "Identifiant : " + idUtilisateur + "\nNom : " + nom + "\nPrénom : " + prenom + "\nEmail : " + email + "\nMot de passe : " + motDePasse + "\nPoste : " + poste + "\nRôle : " + role + "\nListe des projets : " + listeProjet.size() + "\n";
    }

    public void creerEmploye(String nom, String prenom, String email, String motDePasse, String poste) {
        Employe newEmploye = new Employe(nom, prenom, email, motDePasse, poste);
    }

    public void modifierEmploye(String attribut, String nouvelleValeur) {
        switch (attribut.toLowerCase()) {
            case "nom":
                this.nom = nouvelleValeur;
                break;
            case "prenom":
                this.prenom = nouvelleValeur;
                break;
            case "email":
                this.email = nouvelleValeur;
                break;
            case "motDePasse":
                this.motDePasse = nouvelleValeur;
                break;
            case "poste":
                this.poste = nouvelleValeur;
                break;
        }
    }

    public void supprimerEmploye() {
        this.isSupprime = true;
        System.out.println("L'employé " + prenom + " " + nom + " a bien été supprimé");
    }

    public void afficherInfo() {
        System.out.println("Les informations de " + this.prenom + " " + this.nom + " sont :" + "\nIdentifiant : " + idUtilisateur + "\nNom : " + nom + "\nPrénom : " + prenom + "\nEmail : " + email + "\nMot de passe : " + motDePasse + "\nPoste : " + poste + "\n");
    }

    public void afficherHistorique() {
        System.out.println("L'historique de travail de " + this.prenom + " " + this.nom + " est :" + "\n" + listeProjet);
    }
}
