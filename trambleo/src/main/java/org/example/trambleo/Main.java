package org.example.trambleo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date dateActuelle = new Date();
        long timestamp =  1672531200000L;
        Date date2 = new Date(timestamp);

        Employe employe1 = new Employe("Gaudin", "Téo", "teogdn.pro@gmail.com", "motDePasse123", "PDG");
        Projet projet1 = new Projet("Test", "description", dateActuelle, date2);



        System.out.println(employe1.toString());
        System.out.println(projet1.toString());

        employe1.afficherInfo();
    }
}
