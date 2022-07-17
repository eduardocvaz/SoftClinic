package com.example.softclinic.controller;

import com.example.softclinic.application.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField userPassword;

    @FXML
    private TextField userLogin;

    @FXML
    private Button loginCancel;

    @FXML
    private Button loginEnter;

    @FXML
    protected void enterProgramButton() throws IOException {
        if(userPassword.getText().equals("1234") && userLogin.getText().equals("root")){
            HelloApplication p =new HelloApplication();
            Stage s2 = new Stage();
            p.start(s2);
        }

    }

    public void cancelLogin() {
        userPassword.setText("");
        userLogin.setText("");
    }
}
