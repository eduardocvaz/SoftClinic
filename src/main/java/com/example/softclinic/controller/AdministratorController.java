package com.example.softclinic.controller;

import com.example.softclinic.data.AtendenteDAO;
import com.example.softclinic.data.MedicoDAO;
import com.example.softclinic.data.PacienteDAO;
import com.example.softclinic.model.Atendente;
import com.example.softclinic.model.Medico;
import com.example.softclinic.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

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
    private TableView<Atendente> tableAtendente;

    @FXML
    private TableColumn<Atendente, String> tableAtendCpf;

    @FXML
    private TableColumn<Atendente, String> tableAtendNome;

    @FXML
    private TableColumn<Atendente, String> tableAtendSobrenome;

    @FXML
    private TableColumn<Atendente, String> tableAtendTelefone;

    ArrayList<Atendente> atendList = new ArrayList<Atendente>();

    ObservableList<Atendente> observableAtendenteList = FXCollections.observableArrayList();

    @FXML
    private TableView<Medico> tableMedico;

    @FXML
    private TableColumn<Medico, String> tableMediCpf;

    @FXML
    private TableColumn<Medico, String> tableMediNome;

    @FXML
    private TableColumn<Medico, String> tableMediSobrenome;

    @FXML
    private TableColumn<Medico, String> tableMediTelefone;

    ArrayList<Medico> mediList = new ArrayList<Medico>();

    ObservableList<Medico> observableMediList = FXCollections.observableArrayList();

    @FXML
    private TableView<Paciente> tablePaciente;

    @FXML
    private TableColumn<Paciente, String> tablePaciCpf;

    @FXML
    private TableColumn<Paciente, String> tablePaciNome;

    @FXML
    private TableColumn<Paciente, String> tablePaciSobrenome;

    @FXML
    private TableColumn<Paciente, String> tablePaciTelefone;

    ArrayList<Paciente> paciList = new ArrayList<Paciente>();

    ObservableList<Paciente> observablePaciList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tableAtendCpf.setCellValueFactory(new PropertyValueFactory<Atendente, String>("cpf"));
        tableAtendNome.setCellValueFactory(new PropertyValueFactory<Atendente, String>("nome"));
        tableAtendSobrenome.setCellValueFactory(new PropertyValueFactory<Atendente, String>("sobrenome"));
        tableAtendTelefone.setCellValueFactory(new PropertyValueFactory<Atendente, String>("telefone"));

        tablePaciCpf.setCellValueFactory(new PropertyValueFactory<Paciente, String>("cpf"));
        tablePaciNome.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nome"));
        tablePaciSobrenome.setCellValueFactory(new PropertyValueFactory<Paciente, String>("sobrenome"));
        tablePaciTelefone.setCellValueFactory(new PropertyValueFactory<Paciente, String>("telefone"));

        tableMediCpf.setCellValueFactory(new PropertyValueFactory<Medico, String>("cpf"));
        tableMediNome.setCellValueFactory(new PropertyValueFactory<Medico, String>("nome"));
        tableMediSobrenome.setCellValueFactory(new PropertyValueFactory<Medico, String>("sobrenome"));
        tableMediTelefone.setCellValueFactory(new PropertyValueFactory<Medico, String>("telefone"));

    }


    @FXML
    void addAtendente(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(CadastroAtendenteController.class.getResource("/com/example/softclinic/view/cadastroAtendente-view.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Stage stageClient = new Stage();
            stageClient.setTitle("Tela Cadastro Atendente");
            Scene scene = new Scene(page);
            stageClient.setResizable(false);
            stageClient.setScene(scene);

            CadastroAtendenteController controller = fxmlLoader.getController();
            controller.setMyStage(stageClient);
            stageClient.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addConsulta(ActionEvent event) {

    }

    @FXML
    void addMedico(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(CadastroMedicoController.class.getResource("/com/example/softclinic/view/cadastroMedico-view.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Stage stageClient = new Stage();
            stageClient.setTitle("Tela Cadastro Medico");
            Scene scene = new Scene(page);
            stageClient.setResizable(false);
            stageClient.setScene(scene);

            CadastroMedicoController controller = fxmlLoader.getController();
            controller.setMyStage(stageClient);
            stageClient.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addPaciente(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(CadastroPacienteController.class.getResource("/com/example/softclinic/view/cadastroPaciente-view.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Stage stageClient = new Stage();
            stageClient.setTitle("Tela Cadastro Paciente");
            Scene scene = new Scene(page);
            stageClient.setResizable(false);
            stageClient.setScene(scene);

            CadastroPacienteController controller = fxmlLoader.getController();
            controller.setMyStage(stageClient);
            stageClient.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addProntuario(ActionEvent event) {

    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }

    @FXML
    void listarAtendentes(ActionEvent event) {
        try {
            atendList = (ArrayList<Atendente>) new AtendenteDAO().search();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            return;
        }

        observableAtendenteList = FXCollections.observableArrayList();
        observableAtendenteList.addAll(atendList);
        tableAtendente.setItems(observableAtendenteList);
    }


    @FXML
    void listarMedicos(ActionEvent event) {
        try {
            mediList = (ArrayList<Medico>) new MedicoDAO().search();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            return;
        }

        observableMediList = FXCollections.observableArrayList();
        observableMediList.addAll(mediList);
        tableMedico.setItems(observableMediList);
    }

    @FXML
    void listarPacientes(ActionEvent event) {
        try {
            paciList = (ArrayList<Paciente>) new PacienteDAO().search();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            return;
        }

        observablePaciList = FXCollections.observableArrayList();
        observablePaciList.addAll(paciList);
        tablePaciente.setItems(observablePaciList);
    }
}
