package com.example.softclinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AdministratorController {

    private Stage myStage;



    @FXML
    private MenuItem mIAddAtendente;

    @FXML
    private MenuItem mIAddConsulta;

    @FXML
    private MenuItem mIAddMedico;

    @FXML
    private MenuItem mIAddPaciente;

    @FXML
    private MenuItem mIAddProntuario;

    @FXML
    private TableView<?> tableAtendente;

    @FXML
    private TableView<?> tableMedico;

    @FXML
    private TableView<?> tablePaciente;

    @FXML
    void addAtendente(ActionEvent event) {

    }

    @FXML
    void addConsulta(ActionEvent event) {

    }

    @FXML
    void addMedico(ActionEvent event) {

    }

    @FXML
    void addPaciente(ActionEvent event) {

    }

    @FXML
    void addProntuario(ActionEvent event) {

    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }
}
