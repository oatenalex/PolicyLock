package com.example.policylock;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.util.Duration;
import javafx.event.EventHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import xmlwise.Plist;

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
    private static final String USERNAME_VALUE = "u";
    private static final String PASSWORD_VALUE = "p";

    //Log out Buttons
    @FXML
    private Button confirmLogoutButton;
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
    private Button applicationNameButton;
    @FXML
    private Button localDevicePageButton;
    @FXML
    private Button settingsPageButton;
    @FXML
    private Button permissionSettingsPageButton;
    @FXML
    private Button logSettingsPageButton;
    @FXML
    private Button breadcrumb;
    @FXML
    private Button notificationSettingsPageButton;
    @FXML
    private Button accountSettingsPageButton;
    @FXML
    private Button logPageButton;

    //Background anchorpane on which each UI element is placed. Use for inactivity timer
    @FXML
    private GridPane gridPane;

    @FXML
    private AnchorPane applicationsAnchorPane;

    //Timer variables used for handling inactivity
    private int inactivityTimeAllowance = 2;
    private PauseTransition inactivityTimeCounter = new PauseTransition();
    private static boolean timeOutCompleted = false; //Variable used to check if timeout has already been completed to fix multiple log in screen issue from multiple anchor panes being activated

    //File Path Variables
    private static final String APPLICATIONS_PATH = "/Applications"; // for mac only

    //Breadcrumb Styling
    private static final String HIGHLIGHT_STYLE = "-fx-text-fill: #33D7FF; -fx-background-color: transparent;";
    private static final String UNHIGHLIGHT_STYLE = "-fx-text-fill: #909090; -fx-background-color: transparent;";

    public void highlightHome() { homePageButton.setStyle(HIGHLIGHT_STYLE); }

    public void unhighlightHome() { homePageButton.setStyle(UNHIGHLIGHT_STYLE); }

    public void highlightSettings() { settingsPageButton.setStyle(HIGHLIGHT_STYLE); }

    public void unhighlightSettings() { settingsPageButton.setStyle(UNHIGHLIGHT_STYLE); }

    public void highlightBreadcrumb() { breadcrumb.setStyle(HIGHLIGHT_STYLE); }

    public void unhighlightBreadcrumb() { breadcrumb.setStyle(UNHIGHLIGHT_STYLE); }

    public void highlightLogSettings() { logSettingsPageButton.setStyle(HIGHLIGHT_STYLE); }

    public void unhighlightLogSettings() { logSettingsPageButton.setStyle(UNHIGHLIGHT_STYLE); }

    public void highlightDevices() { devicesPageButton.setStyle(HIGHLIGHT_STYLE); }

    public void unhighlightDevices() { devicesPageButton.setStyle(UNHIGHLIGHT_STYLE); }

    public void highlightLocalDevice() { applicationsPageButton.setStyle(HIGHLIGHT_STYLE); }

    public void unhighlightLocalDevice() { applicationsPageButton.setStyle(UNHIGHLIGHT_STYLE); }

    public void login() throws IOException {

        if (username.getText().equals(USERNAME_VALUE) && password.getText().equals(PASSWORD_VALUE) && (tries > 0)) {
            Controller.timeOutCompleted = false; //Resets the timeout variable
            Stage stage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            if (loginButton.getText().equals("Login"))
                loader.setLocation(getClass().getResource("homeResize.fxml"));
            else
                loader.setLocation(getClass().getResource("account_settingsResize.fxml"));
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
        else { login(); }
    }

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

    public void permissionSettings() throws IOException {
        Stage stage = (Stage) permissionSettingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("permission_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void logSettings() throws IOException {
        Stage stage = (Stage) logSettingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("log_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void logLogSettings() throws IOException {
        Stage stage = (Stage) logSettingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("log_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        Controller c = loader.getController();
        c.breadcrumb.setText("LOG");
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void breadcrumbTrace() throws IOException {
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

    public void notificationSettings() throws IOException {
        Stage stage = (Stage) notificationSettingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("notification_settingsResize.fxml"));
        GridPane mainLayout = loader.load();
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();
    }

    public void accountSettingsLogin() throws IOException {
        Stage stage = (Stage) accountSettingsPageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("account_settingsLogin.fxml"));
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

    public void confirmLogout() throws IOException {
        Stage stage = (Stage) confirmLogoutButton.getScene().getWindow();
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
        if (!timeOutCompleted) {
            Stage stage = (Stage) gridPane.getScene().getWindow();
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


        ArrayList<Application> apps = getLocalApplications();
        for (Application app : apps) {
            appVBox.getChildren().add(createApplicationButton(app));
        }

        applicationsAnchorPane.getChildren().add(appVBox);
        updateApplicationsForDatabase();
    }

    private Button createApplicationButton(Application app) {
        Button newApp = new Button();
        newApp.setText(app.getButtonFormat());
        newApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    goToApplicationPage(newApp);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        });
        return newApp;
    }
    //permissions and log of a specific application
    public void goToApplicationPage(Button newApp) throws IOException {
        String applicationName = newApp.getText().substring(newApp.getText().indexOf(" ") + 1, newApp.getText().indexOf("Last Modified"));
        applicationName.trim();
        Stage stage = (Stage) newApp.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("application.fxml"));
        GridPane mainLayout = loader.load();
        Controller c = loader.getController();
        c.applicationNameButton.setText(applicationName);
        stage.getScene().setRoot(mainLayout);
        pauseInactivityTimer();

    }


    /**
     * Gets a list of the applications on a device.
     * Currently, only works for Macs that did not move the default location of applications directory.
     * @return List of Application objects
     */
    public ArrayList<Application> getLocalApplications() {
        ArrayList<Application> apps = new ArrayList<>();
        File f = new File(APPLICATIONS_PATH);
        ArrayList<File> files = new ArrayList<>(Arrays.asList(f.listFiles()));
        for (File file : files) {
            if (!file.getName().startsWith(".")) {
                String name = file.getName().split("\\.")[0];

                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(file.lastModified());

                Application newApp = new Application(name);
                newApp.setDateLastModified(date);

                ArrayList<File> pckContents = new ArrayList<>(Arrays.asList(file.listFiles()));
                for (File content: pckContents) {
                    if (content.getName().equals("Contents")) {
                        ArrayList<File> folders = new ArrayList<>(Arrays.asList(content.listFiles()));
                        for (File folder : folders) {
                            if (folder.getName().equals("Resources")) {
                                File appIcon = getApplicationIcon(folder);
                                newApp.setIcon(appIcon);
                            }
                            else if (folder.getName().endsWith(".plist")) {
                                ArrayList<Permission> perms = parsePermissions(folder);
                                newApp.setPermissions(perms);
                            }
                        }
                    }
                }

                apps.add(newApp);
            }
        }
        return apps;
    }

    /**
     * Retrieves the application icon from the Resources folder
     * @param folder Resources folder
     * @return File pointing to the application icon
     */
    public File getApplicationIcon(File folder) {
        ArrayList<File> resources = new ArrayList<>(Arrays.asList(folder.listFiles()));
        for (File icon : resources) {
            if (icon.getName().endsWith(".icns")) {
                return icon;
            }
        }
        return new File("Images/DefaultIcon.icns");
    }

    /**
     * Parses the permissions of an application's Info.plist file
     * @param plist Info.plist file
     * @return ArrayList of Permission objects
     */
    public ArrayList<Permission> parsePermissions(File plist) {
        ArrayList<Permission> perms = new ArrayList<>();
        try {
            Map<String, Object> properties = Plist.load(plist.getPath());
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                buildPermissionList(perms, entry);   //Edits original array as array pointer is passed to function
            }
            return perms;
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            perms.add(new Permission("ERROR", "Could not read permissions"));
            return perms;
        }
    }

public void buildPermissionList(ArrayList<Permission> perms, Map.Entry<String, Object> entry){
    try {
        if (entry.getKey().startsWith("NS")) {
            perms.add(new Permission(entry.getKey().substring(2), entry.getValue().toString()));
        }
    }
    catch (Exception exception) {
        System.out.println("Caught it here: " + exception);
    }
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