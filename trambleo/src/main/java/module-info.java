module org.example.trambleo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;
    requires google.cloud.core;
    requires com.google.auth.oauth2;
    requires com.google.auth;
    requires firebase.admin;
    requires google.cloud.firestore;
    requires com.google.api.apicommon;

    opens org.example.trambleo to javafx.fxml;
    exports org.example.trambleo;
    exports org.example.trambleo.Controller;
    opens org.example.trambleo.Controller to javafx.fxml;
}