package com.example.policylock;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrect;
    @FXML
    private Button loginButton;

    public void login() throws IOException {
        if (username.getText().toString().equals("winemoms") && password.getText().toString().equals("6969")) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            primaryStage.setTitle("PolicyLock");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }

        else {
            incorrect.setText("Incorrect username or password");
        }
    }
}
