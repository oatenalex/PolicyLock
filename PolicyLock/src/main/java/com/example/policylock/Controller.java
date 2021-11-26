package com.example.policylock;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Controller {
    //For Login
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
    private HBox notification;
    @FXML
    private Button closeNotificationButton;

    private int tries = 3;

    //Username & Password Settings
    private static final String usernameValue = "u";
    private static final String passwordValue = "p";

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
    private int inactivityTimeAllowance = 2;
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

    public void login() throws IOException {

        if (username.getText().equals(usernameValue) && password.getText().equals(passwordValue) && (tries > 0)) {
            Controller.timeOutCompleted = false; //Resets the timeout variable
            Stage stage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("homeResize.fxml"));
            GridPane mainLayout = loader.load();
            stage.getScene().setRoot(mainLayout);
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

    public void closeNotification() { notification.setVisible(false); }

    //Method that handles when the enter key is pressed in text boxes on the enter page
    @FXML
    private void onEnter(ActionEvent event) throws IOException{
        //Checks if the source calling the actionEvent is the Username box or password
        if (event.getSource().getClass().equals(username.getClass()))
            password.requestFocus();
        else{ login();}
    };

    public void home() throws IOException {
        Stage stage = (Stage) homePageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homeResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
    }

    public void devices() throws IOException {
        Stage stage = (Stage) devicesPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("devicesResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void settings() throws IOException {
        Stage stage = (Stage) settingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void permission_settings() throws IOException {
        Stage stage = (Stage) permission_settingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("permission_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void log_settings() throws IOException {
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("log_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void log_log_settings() throws IOException {
        Stage stage = (Stage) log_settingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("log_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        Controller c = loader.getController();
        c.breadcrumb.setText("LOG");
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void breadcrumb_trace() throws IOException {
        Stage stage = (Stage) breadcrumb.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        if (breadcrumb.getText().equals("SETTINGS"))
            loader.setLocation(getClass().getResource("settingsResize.fxml"));
        else
            loader.setLocation(getClass().getResource("logResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void notification_settings() throws IOException {
        Stage stage = (Stage) notification_settingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("notification_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void account_settings() throws IOException {
        Stage stage = (Stage) account_settingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("account_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void log() throws IOException {
        Stage stage = (Stage) logPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("logResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void confirm_logout() throws IOException {
        Stage stage = (Stage) confirm_logoutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("confirm_logoutResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void logout() throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
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
        Stage stage = (Stage) gridPane.getScene().getWindow();
        if (!timeOutCompleted) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("loginResize.fxml"));
            GridPane mainLayout = loader.load();
            Controller c = loader.getController();
            c.notification.setVisible(true);
            stage.getScene().setRoot(mainLayout);
            timeOutCompleted = true;
        }
    }

    public void goToApplicationsPage() throws IOException {
        Stage stage = (Stage) applicationsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("deviceApplications.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();

        applicationsAnchorPane = (AnchorPane) loader.getNamespace().get("applicationsAnchorPane");
        VBox appVBox = new VBox();


        ArrayList<Application> apps = getLocalApplicationList();
        for (Application app : apps) {
            appVBox.getChildren().add(createApplicationButton(app));
        }

        applicationsAnchorPane.getChildren().add(appVBox);
        updateApplicationsForDatabase();
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

    private void updateApplicationsForDatabase() {
        String uri = "mongodb+srv://PolicyLock:PolicyLock@policylock.rrwer.mongodb.net/PolicyLock?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PolicyLock");
            MongoCollection<Document> collection = database.getCollection("Devices");
            Document doc = collection.find(eq("Test1", "Hello World!")).first();
            System.out.println(doc.toJson());
        }
    }
}