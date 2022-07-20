package com.example.softclinic.controller;

import com.example.softclinic.data.MedicoDAO;
import com.example.softclinic.model.Medico;
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
    private TextField medicoEspecialidade;

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
        int ctps= Integer.parseInt( medicoCtps.getText());
        String cr=medicoCr.getText();
        String telefone=medicoTelefone.getText();
        String arrayNome [] = medicoNome.getText().split(" ");
        String especialidade=medicoEspecialidade.getText();
        String nome="";
        String sobrenome="";
        for(int i =0 ;i<arrayNome.length;i++){
            if (arrayNome[i]!=" " && i<1){
                nome=arrayNome[i];
            }else if (arrayNome[i]!=" " && i>=1){
               sobrenome=arrayNome[i];
            }
        }
        LocalDate myDate = medicoData.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String dataNascimento=myFormattedDate;
        Medico medico = new Medico(cpf, nome,sobrenome, dataNascimento,telefone,ctps,cr,sexo,especialidade);
        new MedicoDAO().insert(medico);

    }

    @FXML
    void cancelarCadastro( ) {

        medicoData.getEditor().clear();
        medicoSexoH.setSelected(false);
        medicoSexoM.setSelected(false);
        medicoNome.setText("");
        medicoCpf.setText("");
        medicoCtps.setText("");
        medicoTelefone.setText("");
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


