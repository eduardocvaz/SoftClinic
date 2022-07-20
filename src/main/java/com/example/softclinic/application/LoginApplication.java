package com.example.softclinic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginApplication extends Application {
    private Stage s1 =new Stage();
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("/com/example/softclinic/view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.s1.setTitle("Login Screen!");
        this.s1.setScene(scene);
        this.s1.setResizable(false);
        this.s1.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
