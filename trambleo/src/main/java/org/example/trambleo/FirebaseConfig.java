package org.example.trambleo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {
    public static void initializeFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("C:\\Users\\ambre\\IdeaProjects\\trambleo\\trambleo\\trambleo-firebase-adminsdk-m1st9-c69fbf5c5d.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://trambleo-default-rtdb.europe-west1.firebasedatabase.app/") // Remplacez par l'URL de votre BDD Firebase
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase initialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to initialize Firebase.");
        }
    }
}
