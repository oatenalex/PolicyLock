package com.example.policylock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class loginUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginUI.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("PolicyLock");
        stage.setScene(scene);
        stage.show();
    }

    public int dumbTest(){return 3;}

    public static void main(String[] args) {
        launch();
    }
}