package com.example.policylock;

import javafx.event.ActionEvent;
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
    //Log in & Log out Buttons/Text Fields
    @FXML
    private Button loginButton;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrect;

    private static final String usernameValue = "winemoms";
    private static final String passwordValue = "6969";

    public void login() throws IOException {
        if (username.getText().equals(usernameValue) && password.getText().equals(passwordValue)) {
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

            //Resets the login screen
            username.setText("");
            password.setText("");
            username.requestFocus();
        }
    }

    //Method that handles when the enter key is pressed in text boxes on the enter page
    @FXML
    private void onEnter(ActionEvent event) throws IOException{
        //Checks if the source calling the actionEvent is the Username box or password
        if (event.getSource().getClass().equals(username.getClass()))
            password.requestFocus();
        else{ login();}
    };
}