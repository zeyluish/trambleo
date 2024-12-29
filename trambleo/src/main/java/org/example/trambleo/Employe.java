package org.example.trambleo;

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
    ArrayList<Projet> listeProjet;

    public Employe(String nom, String prenom, String email, String motDePasse, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.poste = poste;
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

    // </editor-fold>

    public String toString() {
        return "Identifiant : " + idUtilisateur + "\nNom : " + nom + "\nPrénom : " + prenom + "\nEmail : " + email + "\nMot de passe : " + motDePasse + "\nPoste : " + poste + "\nRôle : " + role + "\nListe des projets : " + listeProjet + "\n";
    }
}
