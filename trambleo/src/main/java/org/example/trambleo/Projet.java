package org.example.trambleo;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Projet {
    UUID idProjet = UUID.randomUUID();
    String nomProjet;
    String descriptionProjet;
    Date dateDebutProjet;
    Date dateFinProjet;
    boolean statutProjet;
    ArrayList<Tache> listeTache;
    ArrayList<Employe> listeEmploye;

    public Projet(String nomProjet, String descriptionProjet, Date dateDebutProjet, Date dateFinProjet) {
        this.nomProjet = nomProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
    }
}
