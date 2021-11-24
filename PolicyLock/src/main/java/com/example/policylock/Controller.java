package com.example.policylock;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

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
    private Button applicationsPageButton;
    @FXML
    private Button local_devicePageButton;
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
    private GridPane gridPane;
    @FXML
    private ImageView background;

    @FXML
    private AnchorPane applicationsAnchorPane;

    //Timer variables used for handling inactivity
    private int inactivityTimeAllowance = 120;
    private PauseTransition inactivityTimeCounter = new PauseTransition();
    public static boolean timeOutCompleted = false; //Variable used to check if timeout has already been completed to fix multiple log in screen issue from multiple anchor panes being activated


    public void highlight_home() { homePageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_home() { homePageButton.setStyle("-fx-text-fill: #909090; -fx-background-color: transparent;"); }

    public void highlight_settings() { settingsPageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_settings() { settingsPageButton.setStyle("-fx-text-fill: #909090; -fx-background-color: transparent;"); }

    public void highlight_breadcrumb() { breadcrumb.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_breadcrumb() { breadcrumb.setStyle("-fx-text-fill: #909090; -fx-background-color: transparent;"); }

    public void highlight_logsettings() { log_settingsPageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_logsettings() { log_settingsPageButton.setStyle("-fx-text-fill: #909090; -fx-background-color: transparent;"); }

    public void highlight_devices() { devicesPageButton.setStyle("-fx-text-fill: #33D7FF; -fx-background-color: transparent;"); }

    public void unhighlight_devices() { devicesPageButton.setStyle("-fx-text-fill: #909090; -fx-background-color: transparent;"); }

    public void home() throws IOException {
        double width, height;
        Stage stage = (Stage) homePageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("homeResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void devices() throws IOException {
        double width, height;
        Stage stage = (Stage) devicesPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("devicesResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void settings() throws IOException {
        double width, height;
        Stage stage = (Stage) settingsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("settingsResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void permission_settings() throws IOException {
        double width, height;
        Stage stage = (Stage) permission_settingsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("permission_settingsResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void log_settings() throws IOException {
        double width, height;
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("log_settingsResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void log_log_settings() throws IOException {
        double width, height;
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("log_settingsResize.fxml"));
        Parent root = loader.load();
        Controller c = loader.getController();
        c.breadcrumb.setText("LOG");
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void breadcrumb_trace() throws IOException {
        double width, height;
        Stage stage = (Stage) breadcrumb.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root;
        if (breadcrumb.getText().equals("SETTINGS"))
            root = FXMLLoader.load(getClass().getResource("settingsResize.fxml"));
        else
            root = FXMLLoader.load(getClass().getResource("logResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void notification_settings() throws IOException {
        double width, height;
        Stage stage = (Stage) notification_settingsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("notification_settingsResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void account_settings() throws IOException {
        double width, height;
        Stage stage = (Stage) account_settingsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("account_settingsResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void log() throws IOException {
        double width, height;
        Stage stage = (Stage) logPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("logResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
    }

    public void confirm_logout() throws IOException {
        double width, height;
        Stage stage = (Stage) confirm_logoutButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("confirm_logoutResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
    }

    public void logout() throws IOException {
        double width, height;
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginResize.fxml"));
        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        background.fitWidthProperty().bind(primaryStage.widthProperty());
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
        double width, height;
        Stage stage = (Stage) gridPane.getScene().getWindow();
        stage.close();
        if (!timeOutCompleted) {
            Stage primaryStage = new Stage();
            width = stage.getScene().getWidth();
            height = stage.getScene().getHeight();
            Parent root = FXMLLoader.load(getClass().getResource("loginResize.fxml"));
            primaryStage.setTitle("PolicyLock");
            primaryStage.setScene(new Scene(root, width, height));
            primaryStage.show();
            background.fitHeightProperty().bind(primaryStage.heightProperty());
            background.fitWidthProperty().bind(primaryStage.widthProperty());
            timeOutCompleted = true;
        }
    }

    public void goToApplicationsPage() throws IOException {
        double width, height;
        Stage stage = (Stage) applicationsPageButton.getScene().getWindow();
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        stage.close();
        pauseInactivityTimer();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deviceApplications.fxml"));
        Parent root = loader.load();

        applicationsAnchorPane = (AnchorPane) loader.getNamespace().get("applicationsAnchorPane");
        VBox appVBox = new VBox();


        ArrayList<Application> apps = getLocalApplicationList();
        for (Application app : apps) {
            appVBox.getChildren().add(createApplicationButton(app));
        }

        applicationsAnchorPane.getChildren().add(appVBox);

        primaryStage.setTitle("PolicyLock");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        root.requestFocus();
    }

    private Button createApplicationButton(Application app) {
        Button newApp = new Button();
        newApp.setText(app.getButtonFormat());
        return newApp;
    }

    /**
     * Gets a list of the applications on a device.
     * Currently only works for Macs that did not move the default location of applications directory.
     * @return List of Application objects
     */
    private ArrayList<Application> getLocalApplicationList() {
        ArrayList<Application> apps = new ArrayList<Application>();
        File f = new File("/Applications");
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        for (File file : files) {
            if (!file.getName().startsWith(".")) {
                String name = file.getName().split("\\.")[0];

                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(file.lastModified());

                Application newApp = new Application(name);
                newApp.setDateLastModified(date);

                apps.add(newApp);
            }
        }
        return apps;
    }
}