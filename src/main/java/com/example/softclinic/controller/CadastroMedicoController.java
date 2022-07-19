package com.example.softclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroMedicoController {
    @FXML
    private TextField medicoNome;

    @FXML
    private TextField medicoCpf;

    @FXML
    private TextField medicoCtps;

    @FXML
    private DatePicker medicoData;

    @FXML
    private RadioButton medicoSexoH;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private RadioButton medicoSexoM;

    @FXML
    private TextField medicoTelefone;

    @FXML
    private TextField medicoCr;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoLimparCampo;

    @FXML
    private Button botaoCancelar;

    @FXML
    void cadastrarMedico( ) {
        RadioButton radio = (RadioButton) sexo.getSelectedToggle();
        String sexo = radio.getText();
        String cpf= medicoCpf.getText();
        String ctps=medicoCtps.getText();
        String cr=medicoCr.getText();
        String telefone=medicoTelefone.getText();
        String arrayNome [] = medicoNome.getText().split(" ");

        for(int i =0 ;i<arrayNome.length;i++){
            if (arrayNome[i]!=" " && i<1){
                String nome=arrayNome[i];
            }else if (arrayNome[i]!=" " && i>=1){
                String sobrenome=arrayNome[i];
            }
        }
        LocalDate myDate = medicoData.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String dataNascimento=myFormattedDate;

    }

    @FXML
    void cancelarCadastro( ) {

    }

    @FXML
    void limparCampos( ) {

        medicoData.getEditor().clear();
        medicoSexoH.setSelected(false);
        medicoSexoM.setSelected(false);
        medicoNome.setText("");
        medicoCpf.setText("");
        medicoCtps.setText("");
        medicoTelefone.setText("");
    }

}


