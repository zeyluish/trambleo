package org.example.trambleo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Projet {
    UUID idProjet;
    String nomProjet;
    String descriptionProjet;
    LocalDate dateDebutProjet;
    LocalDate dateFinProjet;
    String statutProjet;
    static Projet projetSelected;
    ArrayList<Tache> listeTache = new ArrayList<>();
    ArrayList<Employe> listeEmploye = new ArrayList<>();
    static ArrayList<Projet> listeProjet = new ArrayList<>();
    boolean isSupprime;
    boolean isEquipeAssocie;

    public Projet(UUID idProjet, String nomProjet, String descriptionProjet, LocalDate dateDebutProjet, LocalDate dateFinProjet) {
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
        this.isSupprime = false;
        this.isEquipeAssocie = false;
        this.statutProjet = "Nouveau Projet";
    }

    // <editor-fold desc="Getters and setters">

    public UUID getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(UUID idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public LocalDate getDateDebutProjet() {
        return dateDebutProjet;
    }

    public void setDateDebutProjet(LocalDate dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public LocalDate getDateFinProjet() {
        return dateFinProjet;
    }

    public void setDateFinProjet(LocalDate dateFinProjet) {
        this.dateFinProjet = dateFinProjet;
    }

    public String isStatutProjet() {
        return statutProjet;
    }

    public void setStatutProjet(String statutProjet) {
        this.statutProjet = statutProjet;
    }

    public ArrayList<Tache> getListeTache() {
        return listeTache;
    }

    public void setListeTache(ArrayList<Tache> listeTache) {
        this.listeTache = listeTache;
    }

    public ArrayList<Employe> getListeEmploye() {
        return listeEmploye;
    }

    public void setListeEmploye(ArrayList<Employe> listeEmploye) {
        this.listeEmploye = listeEmploye;
    }

    public boolean isEquipeAssocie() {
        return isEquipeAssocie;
    }

    public void setEquipeAssocie(boolean equipeAssocie) {
        isEquipeAssocie = equipeAssocie;
    }

    public boolean isSupprime() {
        return isSupprime;
    }

    public void setSupprime(boolean supprime) {
        isSupprime = supprime;
    }

    public String getStatutProjet() {
        return statutProjet;
    }

    // </editor-fold>

    public String toString() {
        return "Identifiant : " + idProjet + "\nNom du Projet : " + nomProjet + "\nDescription du Projet : " + descriptionProjet + "\nDate de début : " + dateDebutProjet + "\nDate de fin : " + dateFinProjet + "\nStatut : " + statutProjet + "\nListe des tâches : " + listeTache + "\nListe des employes : " + listeEmploye + "\n";
    }

    public String toCSV(){
        return idProjet + ";" + nomProjet + ";" + descriptionProjet + ";" + dateDebutProjet + ";" + dateFinProjet + ";" + statutProjet + ";" + isSupprime + ";" + isEquipeAssocie + ";" + listeEmploye;
    }
/*
    public static void modifierCSV(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("projets.csv"))) {
            for (Projet projet : listeProjet) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%b,%b\n",
                        projet.getIdProjet(),
                        projet.getNom(),
                        projet.getDescription(),
                        projet.getDateDebut(),
                        projet.getDateFin(),
                        projet.getStatut(),
                        projet.isSupprime(),
                        projet.isEquipeAssocie()
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public static void  importProjet() { //récupérer les projets depuis le CSV
        String filePath = "src/main/resources/Projet.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    try {
                        UUID idProjet = UUID.fromString(parts[0]);
                        String nom = parts[1];
                        String description = parts[2];
                        LocalDate dateDebut = LocalDate.parse(parts[3]);
                        LocalDate dateFin = LocalDate.parse(parts[4]);
                        String statutProjet = parts[5];
                        boolean isSupprime = Boolean.parseBoolean(parts[6]);
                        boolean isEquipeAssocie = Boolean.parseBoolean(parts[7]);

                        boolean exists = false; //Vérifie que le projet n'existe pas déjà pour pas le réafficher
                        for (Projet projet : listeProjet) {
                            if (projet.getIdProjet().equals(idProjet)) {
                                exists = true;
                                System.out.println("Meme id trouvé");
                                break;
                            }
                        }
                        if (!exists) {
                            listeProjet.add(new Projet(idProjet, nom, description, dateDebut, dateFin));

                        }
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


    public void supprimerProjet() {
        this.isSupprime = true;
        System.out.println("Le projet " + nomProjet + "a bien été supprimée.");
    }

    public  void attribuerEmploye(Employe employe) {
        listeEmploye.add(employe);
        employe.listeProjet.add(this);
    }

    public void changerDateDebut(LocalDate dateDebut) {
        this.dateDebutProjet = dateDebut;
    }

    public void changerDateFin(LocalDate dateFin) {
        this.dateFinProjet = dateFin;
    }
}
