package main.java.controller;

import javafx.fxml.Initializable;
import main.java.src.main.Home;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openToStudent(){
        Home.changeScreen("/student.fxml");
    }
    public void openToTeacher(){
        Home.changeScreen("/teacher.fxml");
    }
    public void openToClass(){
        Home.changeScreen("/class.fxml");
    }
}
