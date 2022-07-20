package com.example.softclinic.application;

import com.example.softclinic.controller.AdministratorController;
import com.example.softclinic.controller.AtendenteController;
import com.example.softclinic.controller.MedicoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {


    @FXML
    void abriTelaAdministrador(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdministratorController.class.getResource("/com/example/softclinic/view/administrator-view.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Stage stageClient = new Stage();
            stageClient.setTitle("Tela Administrador");
            Scene scene = new Scene(page);
            stageClient.setResizable(false);
            stageClient.setScene(scene);

            AdministratorController controller = fxmlLoader.getController();
            controller.setMyStage(stageClient);
            stageClient.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abriTelaAtendente(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AtendenteController.class.getResource("/com/example/softclinic/view/atendente-view.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Stage stageClient = new Stage();
            stageClient.setTitle("Tela Atendente");
            Scene scene = new Scene(page);
            stageClient.setResizable(false);
            stageClient.setScene(scene);

            AtendenteController controller = fxmlLoader.getController();
            controller.setMyStage(stageClient);
            stageClient.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abriTelaMedico(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MedicoController.class.getResource("/com/example/softclinic/view/medico-view.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Stage stageClient = new Stage();
            stageClient.setTitle("Tela Medico");
            Scene scene = new Scene(page);
            stageClient.setResizable(false);
            stageClient.setScene(scene);

            MedicoController controller = fxmlLoader.getController();
            controller.setMyStage(stageClient);
            stageClient.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}