package com.example.softclinic.controller;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

public class MedicoController {

    private Stage myStage;


    @FXML
    private MenuItem mIAddConsulta;

    @FXML
    private MenuItem mIAddPaciente;

    @FXML
    private MenuItem mIAddProntuario;

    @FXML
    private TableView<?> tableMedico;

    @FXML
    private TableView<?> tablePaciente;

    @FXML
    void addConsulta(ActionEvent event) {

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
