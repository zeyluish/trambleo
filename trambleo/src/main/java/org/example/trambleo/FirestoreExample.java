package org.example.trambleo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class FirestoreExample {
    public static void addUser(String userId, String name, String email) {
        try {
            Firestore db = FirestoreOptions.getDefaultInstance().getService();

            // Créer un objet utilisateur
            Map<String, Object> user = new HashMap<>();
            user.put("name", name);
            user.put("email", email);

            // Ajouter l'utilisateur à la collection "users"
            DocumentReference docRef = db.collection("users").document(userId);
            ApiFuture<WriteResult> result = docRef.set(user);

            // Afficher le résultat
            System.out.println("Write result: " + result.get().getUpdateTime());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to add user.");
        }
    }
}
