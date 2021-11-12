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
    private Button confirm_logoutButton;
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
    private Button permission_settingsPageButton;
    @FXML
    private Button log_settingsPageButton;
    @FXML
    private Button notification_settingsPageButton;
    @FXML
    private Button account_settingsPageButton;
    @FXML
    private Button logPageButton;


    public void login() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void home() throws IOException {
        Stage stage = (Stage) homePageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void devices() throws IOException {
        Stage stage = (Stage) devicesPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("devices.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void settings() throws IOException {
        Stage stage = (Stage) settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void permission_settings() throws IOException {
        Stage stage = (Stage) permission_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("permission_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void log_settings() throws IOException {
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void notification_settings() throws IOException {
        Stage stage = (Stage) notification_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("notification_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void account_settings() throws IOException {
        Stage stage = (Stage) account_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("account_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void log() throws IOException {
        Stage stage = (Stage) logPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void confirm_logout() throws IOException {
        Stage stage = (Stage) confirm_logoutButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("confirm_logout.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void logout() throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}