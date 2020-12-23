package main.java.controller;

import javafx.fxml.Initializable;
import main.java.src.main.Home;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void openToClassA(){
        Home.changeScreen("/classa.fxml");
    }
    public void openToClassB(){
        Home.changeScreen("/classb.fxml");

    }
    public void openToClassC(){
        Home.changeScreen("/classc.fxml");

    }
    public void backToHome(){
        Home.changeScreen("/home.fxml");
    }
}
