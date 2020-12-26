package main.java.controller;

import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.model.Student;
import main.java.model.Teacher;
import main.java.service.TeacherService;
import main.java.src.main.Home;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private TableView<Teacher> table = new TableView<>();
    @FXML
    private TableColumn<Teacher, Integer> id;
    @FXML
    private TableColumn<Teacher, String> name;
    @FXML
    private TableColumn<Teacher, String> surname;
    @FXML
    private TableColumn<Teacher, Integer> age;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSurname;
    @FXML
    private TextField txtAge;
    private TeacherService ts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ts = new TeacherService();
        createToTable();
        numberTeacher(txtId);
        numberTeacher(txtAge);
        clickItem();
    }

    public void createToTable() {
        id.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Teacher, String>("surname"));
        age.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("age"));
        table.setItems(FXCollections.observableArrayList(ts.getTeacherList()));

    }


    public void addButtonClikAction() {
        addTeacherToTable();
        clearFields();
        createToTable();
    }

    public void updateButtonClickAction(){
        updateTeacherFromTable();
        clearFields();
    }

    public void deleteButtonClickAction(){
        deleteTeacherFromTable();
        clearFields();
    }

    public void addTeacherToTable() {
        Teacher tr = new Teacher();
        tr.setId(Integer.parseInt(txtId.getText()));
        tr.setName(txtName.getText());
        tr.setSurname(txtSurname.getText());
        tr.setAge(Integer.parseInt(txtAge.getText()));
        List<String> errors = ts.validateTeacher(tr);
        if (errors.isEmpty()) {
            ts.addTeacherTable(tr);
        }else{
            JOptionPane.showMessageDialog(null,errors);
        }
    }

    public void clearFields() {
        txtAge.clear();
        txtId.clear();
        txtName.clear();
        txtSurname.clear();
    }

    public void numberTeacher(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                textField.setText(newValue.replaceAll("[^\\d]", ""));
        });

    }

    public void deleteTeacherFromTable() {
        int action = JOptionPane.showConfirmDialog(null, "Do You really want Delete", "Delete", JOptionPane.YES_NO_OPTION);
        if (action == 0) {
            Teacher tr = table.getSelectionModel().getSelectedItem();
            ts.deleteTeacher(tr);
            createToTable();
            clearFields();
        }
    }

    public void updateTeacherFromTable() {
        Teacher tr = new Teacher();
        int oldId = table.getSelectionModel().getSelectedItem().getId();
        tr.setId(Integer.parseInt(txtId.getText()));
        tr.setName(txtName.getText());
        tr.setSurname(txtSurname.getText());
        tr.setAge(Integer.parseInt(txtAge.getText()));
        List<String> errors = ts.validateTeacher(tr);
        if (errors.isEmpty()) {
            ts.updateTeacher(tr, oldId);
            createToTable();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }

    }


    public void clickItem() {
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Teacher tr = table.getSelectionModel().getSelectedItem();
                if (tr != null) {
                    txtId.setText(String.valueOf(tr.getId()));
                    txtName.setText(tr.getName());
                    txtSurname.setText(tr.getSurname());
                    txtAge.setText(String.valueOf(tr.getAge()));

                }
            }
        });
    }

    public void backToHome() {

        Home.changeScreen("/home.fxml");
    }

}

