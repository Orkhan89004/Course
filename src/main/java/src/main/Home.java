package main.java.src.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Home extends Application {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 800, 600));
        stage = primaryStage;
        stage.show();

    }

    public static void changeScreen(String screenpass) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Home.class.getResource(screenpass));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root,800,600));
    }



    public static void main(String[] args) {
        launch(args);

    }

}
