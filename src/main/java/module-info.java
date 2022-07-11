module com.example.softclinic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.softclinic to javafx.fxml;
    exports com.example.softclinic;
}