package com.example.softclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroPacienteController {
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
        String sexo = radio.getText();
        String cpf= pacienteCpf.getText();
        String telefone=pacienteTelefone.getText();
        String arrayNome [] = pacienteNome.getText().split(" ");

        for(int i =0 ;i<arrayNome.length;i++){
            if (arrayNome[i]!=" " && i<1){
                String nome=arrayNome[i];
            }else if (arrayNome[i]!=" " && i>=1){
                String sobrenome=arrayNome[i];
            }
        }
        LocalDate myDate = pacienteData.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String dataNascimento=myFormattedDate;


    }

    @FXML
    void cancelarCadastro( ) {

    }

    @FXML
    void limparCampos( ) {

        pacienteData.getEditor().clear();
        pacienteSexoH.setSelected(false);
        pacienteSexoM.setSelected(false);
        pacienteNome.setText("");
        pacienteCpf.setText("");
        pacienteTelefone.setText("");    }
}
