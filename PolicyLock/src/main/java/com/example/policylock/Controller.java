package com.example.policylock;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {
    //Log out Buttons
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
    private Button breadcrumb;
    @FXML
    private Button notification_settingsPageButton;
    @FXML
    private Button account_settingsPageButton;
    @FXML
    private Button logPageButton;

    //Background anchorpane on which each UI element is placed. Use for inactivity timer
    @FXML
    private AnchorPane anchorPane;

    //Timer variables used for handling inactivity
    private int inactivityTimeAllowance = 5;
    private PauseTransition inactivityTimeCounter = new PauseTransition();
    public static boolean timeOutCompleted = false; //Variable used to check if timeout has already been completed to fix multiple log in screen issue from multiple anchor panes being activated
    /*
    public void highlight(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;");
    }

    public void unhighlight(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-text-fill: WHITE; -fx-background-color: transparent;");
    }

    idk how to encompass all the highlights and unhighlits into 1 method */
    public void highlight_home() { homePageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_home() { homePageButton.setStyle("-fx-text-fill: WHITE; -fx-background-color: transparent;"); }

    public void highlight_settings() { settingsPageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_settings() { settingsPageButton.setStyle("-fx-text-fill: WHITE; -fx-background-color: transparent;"); }

    public void highlight_breadcrumb() { breadcrumb.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_breadcrumb() { breadcrumb.setStyle("-fx-text-fill: WHITE; -fx-background-color: transparent;"); }

    public void highlight_logsettings() { log_settingsPageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_logsettings() { log_settingsPageButton.setStyle("-fx-text-fill: WHITE; -fx-background-color: transparent;"); }

    public void home() throws IOException {
        Stage stage = (Stage) homePageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void devices() throws IOException {
        Stage stage = (Stage) devicesPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("devices.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void settings() throws IOException {
        Stage stage = (Stage) settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void permission_settings() throws IOException {
        Stage stage = (Stage) permission_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("permission_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void log_settings() throws IOException {
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void log_log_settings() throws IOException {
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("log_settings.fxml"));
        Parent root = loader.load();
        Controller c = loader.getController();
        c.breadcrumb.setText("LOG");
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void breadcrumb_trace() throws IOException {
        Stage stage = (Stage) breadcrumb.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root;
        if (breadcrumb.getText().equals("SETTINGS"))
            root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        else
            root = FXMLLoader.load(getClass().getResource("log.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void notification_settings() throws IOException {
        Stage stage = (Stage) notification_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("notification_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void account_settings() throws IOException {
        Stage stage = (Stage) account_settingsPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("account_settings.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void log() throws IOException {
        Stage stage = (Stage) logPageButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
    }

    public void confirm_logout() throws IOException {
        Stage stage = (Stage) confirm_logoutButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("confirm_logout.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();
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

    public void pauseInactivityTimer(){
        inactivityTimeCounter.stop();
    }
    public void inactivityTimer(){
        inactivityTimeCounter.setDuration(Duration.seconds(inactivityTimeAllowance));
        inactivityTimeCounter.setOnFinished( event -> {
            try {
                appTimeOut();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        inactivityTimeCounter.play();
    }

    private void appTimeOut() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        if (!timeOutCompleted) {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("inactive.fxml"));
            primaryStage.setTitle("PolicyLock");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            timeOutCompleted = true;
        }
    }
}