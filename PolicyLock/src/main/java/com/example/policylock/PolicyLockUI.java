package com.example.policylock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class PolicyLockUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        initUI(stage);
    }

    private void initUI(Stage stage) {
        // Documentationing the shit out of this project pt1
        // This is the Login screen, should take the user to devices screen upon proper authentication
        // idk what proper authentication means either
        var root = new StackPane();
        var scene = new Scene(root, 1250, 1000);
        var lbl = new Label("Login");
        lbl.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
        root.getChildren().add(lbl);
        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}