package com.example.softclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroAtendenteController {
    @FXML
    private TextField atendenteNome;

    @FXML
    private TextField atendenteCpf;

    @FXML
    private TextField atendenteCtps;

    @FXML
    private DatePicker atendenteData;


    @FXML
    private RadioButton atendenteSexoH;

    @FXML
    private RadioButton atendenteSexoM;
    @FXML
    private ToggleGroup sexo;

    @FXML
    private TextField atendenteTelefone;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoLimparCampo;

    @FXML
    private Button botaoCancelar;

    public void limparCampos(){

        atendenteData.getEditor().clear();
        atendenteSexoH.setSelected(false);
        atendenteSexoM.setSelected(false);
        atendenteNome.setText("");
        atendenteCpf.setText("");
        atendenteCtps.setText("");
        atendenteTelefone.setText("");
    }
    @FXML
    void cadastrarCliente() {
        RadioButton radio = (RadioButton) sexo.getSelectedToggle();
        String sexo = radio.getText();
        String cpf= atendenteCpf.getText();
        String ctps=atendenteCtps.getText();
        String telefone=atendenteTelefone.getText();
        String arrayNome [] = atendenteNome.getText().split(" ");

        for(int i =0 ;i<arrayNome.length;i++){
            if (arrayNome[i]!=" " && i<1){
                String nome=arrayNome[i];
            }else if (arrayNome[i]!=" " && i>=1){
                String sobrenome=arrayNome[i];
            }
        }
        LocalDate myDate = atendenteData.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String dataNascimento=myFormattedDate;


    }
    @FXML
    void cancelarCadastro() {

    }
}
