package org.example.trambleo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate demain = today.minusDays(1);

        Employe employe1 = new Employe("Gaudin", "Téo", "teogdn.pro@gmail.com", "motDePasse123", "PDG");



        System.out.println(employe1.toString());

        employe1.afficherInfo();


    }
}
