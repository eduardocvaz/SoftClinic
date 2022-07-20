package com.example.softclinic.controller;

import com.example.softclinic.data.MedicoDAO;
import com.example.softclinic.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroMedicoController {

    private Stage myStage;

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
        String sexo = String.valueOf(radio.getText().equals("Homem") ? 'M' : 'F');
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
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dataNascimento=myFormattedDate;
        Medico medico = new Medico();
        medico.setCpf(cpf);
        medico.setNome(nome);
        medico.setSobrenome(sobrenome);
        medico.setData_nascimento(dataNascimento);
        medico.setTelefone(telefone);
        medico.setNumeroCTPS(ctps);
        medico.setCr(cr);
        medico.setSexo(sexo);
        medico.setEspecialidade(especialidade);
        new MedicoDAO().insert(medico);

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

        medicoData.getEditor().clear();
        medicoSexoH.setSelected(false);
        medicoSexoM.setSelected(false);
        medicoNome.setText("");
        medicoCpf.setText("");
        medicoCtps.setText("");
        medicoTelefone.setText("");
    }


    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }

}


