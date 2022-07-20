package com.example.softclinic.controller;

import com.example.softclinic.data.AtendenteDAO;
import com.example.softclinic.data.MedicoDAO;
import com.example.softclinic.model.Atendente;
import com.example.softclinic.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroAtendenteController {

    private Stage myStage;
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
        String sexo = String.valueOf(radio.getText().equals("Homem") ? 'M' : 'F');
        String cpf= atendenteCpf.getText();
        int ctps= Integer.parseInt( atendenteCtps.getText());
        String telefone=atendenteTelefone.getText();
        String arrayNome [] = atendenteNome.getText().split(" ");
        String nome ="";
        String sobrenome="";
        for(int i =0 ;i<arrayNome.length;i++){
            if (arrayNome[i]!=" " && i<1){
                nome=arrayNome[i];
            }else if (arrayNome[i]!=" " && i>=1){
                sobrenome=arrayNome[i];
            }
        }
        LocalDate myDate = atendenteData.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dataNascimento=myFormattedDate;
        Atendente atendente = new Atendente();
        atendente.setCpf(cpf);
        atendente.setNome(nome);
        atendente.setSobrenome(sobrenome);
        atendente.setData_nascimento(dataNascimento);
        atendente.setNumeroCTPS(ctps);
        atendente.setSexo(sexo);
        atendente.setTelefone(telefone);
        new AtendenteDAO().insert(atendente);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cadastrado com sucesso!", ButtonType.OK);
        alert.showAndWait();
        this.limparCampos();

    }
    @FXML
    void cancelarCadastro(ActionEvent event) {
        myStage.close();
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }
}
