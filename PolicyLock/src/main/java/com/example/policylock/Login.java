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
import javafx.scene.image.ImageView;
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
    @FXML
    private Label triesLabel;
    @FXML
    private ImageView background;


    private int tries = 3;

    //Username & Password Settings
    private static final String usernameValue = "u";
    private static final String passwordValue = "p";

    public void login() throws IOException {
        if (username.getText().equals(usernameValue) && password.getText().equals(passwordValue) && (tries > 0)) {
            Controller.timeOutCompleted = false; //Resets the timeout variable
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            stage.setWidth(900);
            stage.setHeight(580);
            background.fitHeightProperty().bind(stage.heightProperty());
            background.fitWidthProperty().bind(stage.widthProperty());
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("homeResize.fxml"));
            primaryStage.setTitle("PolicyLock");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            root.requestFocus();
        }

        else {
            incorrect.setText("Incorrect username or password");
            tries -= 1;

            //Limited amount of tries
            if (tries > 0)
            {
                triesLabel.setText("Attempts Left: " + tries);
            }
            else{
                incorrect.setText("You have been locked out");
                triesLabel.setText("");
            }


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