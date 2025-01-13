module org.example.trambleo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;

    opens org.example.trambleo to javafx.fxml;
    exports org.example.trambleo;
}