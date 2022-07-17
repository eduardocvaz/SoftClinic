module com.example.softclinic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    exports com.example.softclinic.model;
    opens com.example.softclinic.model to javafx.fxml;
    exports com.example.softclinic.controller;
    opens com.example.softclinic.controller to javafx.fxml;
    exports com.example.softclinic.application;
    opens com.example.softclinic.application to javafx.fxml;
}