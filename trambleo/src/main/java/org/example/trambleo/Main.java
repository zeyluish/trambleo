package org.example.trambleo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FirebaseConfig.initializeFirebase();
        FirestoreExample.addUser("user123", "John Doe", "john.doe@example.com");

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate demain = today.minusDays(1);

        Employe employe1 = new Employe("Gaudin", "Téo", "teogdn.pro@gmail.com", "motDePasse123", "PDG");
        Projet projet1 = new Projet("Test", "description", today, demain);



        System.out.println(employe1.toString());
        System.out.println(projet1.toString());

        employe1.afficherInfo();


    }
}
