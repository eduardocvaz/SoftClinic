package com.example.softclinic.controller;

import com.example.softclinic.data.MedicoDAO;
import com.example.softclinic.data.PacienteDAO;
import com.example.softclinic.model.Medico;
import com.example.softclinic.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroPacienteController {

    private Stage myStage;

    @FXML
    private TextField pacienteNome;

    @FXML
    private TextField pacienteCpf;

    @FXML
    private DatePicker pacienteData;

    @FXML
    private RadioButton pacienteSexoH;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private RadioButton pacienteSexoM;

    @FXML
    private TextField pacienteTelefone;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoLimparCampo;

    @FXML
    private Button botaoCancelar;

    @FXML
    void cadastrarPaciente( ) {
        RadioButton radio = (RadioButton) sexo.getSelectedToggle();
        String sexo = String.valueOf(radio.getText().equals("Homem") ? 'M' : 'F');
        String cpf= pacienteCpf.getText();
        String telefone=pacienteTelefone.getText();
        String arrayNome [] = pacienteNome.getText().split(" ");
        String nome="";
        String sobrenome="";
        for(int i =0 ;i<arrayNome.length;i++){
            if (arrayNome[i]!=" " && i<1){
                nome=arrayNome[i];
            }else if (arrayNome[i]!=" " && i>=1){
               sobrenome=arrayNome[i];
            }
        }
        LocalDate myDate = pacienteData.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dataNascimento=myFormattedDate;

        Paciente paciente = new Paciente();
        paciente.setCpf(cpf);
        paciente.setNome(nome);
        paciente.setSobrenome(sobrenome);
        paciente.setData_nascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setSexo(sexo);
        new PacienteDAO().insert(paciente);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cadastrado com sucesso!", ButtonType.OK);
        alert.showAndWait();
        this.limparCampos();

    }

    @FXML
    void cancelarCadastro(ActionEvent event) {
        myStage.close();
    }

    @FXML
    void limparCampos( ) {

        pacienteData.getEditor().clear();
        pacienteSexoH.setSelected(false);
        pacienteSexoM.setSelected(false);
        pacienteNome.setText("");
        pacienteCpf.setText("");
        pacienteTelefone.setText("");    }


    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }
}
