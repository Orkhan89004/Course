package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.java.model.ClassRoom;
import main.java.src.main.Home;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassController implements Initializable {
    @FXML
    private TableView<ClassRoom> tv = new TableView<>();
    @FXML
    private TableColumn<ClassRoom, Integer> id;
    @FXML
    private TableColumn<ClassRoom, String> name;
    @FXML
    private TableColumn<ClassRoom, String> lesson;
    @FXML
    private TableColumn<ClassRoom, String> teacher;
    @FXML
    private TableColumn<ClassRoom, Double> time;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLesson;
    @FXML
    private TextField txtTeacher;
    @FXML
    private TextField txtTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void backToHome() {
        Home.changeScreen("/home.fxml");
    }
}
