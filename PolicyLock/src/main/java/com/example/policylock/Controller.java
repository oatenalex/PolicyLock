package com.example.policylock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;


public class Controller {
    //Log in & Log out Buttons
    @FXML
    private Button loginButton;
    @FXML
    private Button logoutButton;

    //Page switching buttons
    @FXML
    private Button homePageButton;
    @FXML
    private Button devicesPageButton;
    @FXML
    private Button settingsPageButton;
    @FXML
    private Button logPageButton;
    @FXML
    private Button log_settingsPageButton;
    @FXML
    private Button notification_settingsPageButton;


    public void login() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void home() throws IOException {
        Stage stage = (Stage) homePageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void devices() throws IOException {
        Stage stage = (Stage) devicesPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("devices.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void settings() throws IOException {
        Stage stage = (Stage) settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void logout() throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void log() throws IOException {
        Stage stage = (Stage) logPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void log_settings() throws IOException {
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log_settings.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void notification_settings() throws IOException {
        Stage stage = (Stage) notification_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("notification_settings.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}