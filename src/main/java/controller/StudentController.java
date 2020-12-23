package main.java.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.java.model.Student;
import main.java.service.StudentService;
import main.java.src.main.Home;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private TableView<Student> tv = new TableView<>();
    @FXML
    private TableColumn<Student, Integer> id;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> surname;
    @FXML
    private TableColumn<Student, Integer> age;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSurname;
    @FXML
    private TextField txtAge;

    private StudentService ss;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ss = new StudentService();
        creatTable();
        numberFrom(txtId);
        numberFrom(txtAge);
        clickItem();
    }


    private void creatTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));

        tv.setItems(FXCollections.observableArrayList(ss.getList()));
    }

    public void addButtonClickAction() {
        addStudentToTable();
        creatTable();
        clearFields();

    }

    public void updateButtonClickAction() {
        updateStudentFromTable();
        clearFields();
    }

    public void deleteButtonClickAction() {
        deleteStudentFromTable();
        clearFields();
    }

    private void addStudentToTable() {
        Student st = new Student();
        st.setId(Integer.parseInt(txtId.getText()));
        st.setName(txtName.getText());
        st.setSurname(txtSurname.getText());
        st.setAge(Integer.parseInt(txtAge.getText()));
        List<String> errors = ss.validateStudent(st);
        if (errors.isEmpty()) {
            ss.addStudent(st);
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }

    public void numberFrom(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                textField.setText(newValue.replaceAll("[^\\d]", ""));
        });

    }

    public void deleteStudentFromTable() {
        int action = JOptionPane.showConfirmDialog(null, "Do You really want Delete", "Delete", JOptionPane.YES_NO_OPTION);
        if (action == 0) {
            Student st = tv.getSelectionModel().getSelectedItem();
            ss.deleteStudent(st);
            creatTable();
            clearFields();
        }
    }

    private void clearFields() {
        txtName.clear();
        txtSurname.clear();
        txtAge.clear();
        txtId.clear();
    }

    public void updateStudentFromTable() {
        Student st = new Student();
        int oldId = tv.getSelectionModel().getSelectedItem().getId();
        st.setId(Integer.parseInt(txtId.getText()));
        st.setName(txtName.getText());
        st.setSurname(txtSurname.getText());
        st.setAge(Integer.parseInt(txtAge.getText()));
        List<String> errors = ss.validateStudent(st);
        if (errors.isEmpty()) {
            ss.updateStudent(st, oldId);
            creatTable();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }

    }


    public void clickItem() {
        tv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Student st = tv.getSelectionModel().getSelectedItem();
                if (st != null) {
                    txtAge.setText(String.valueOf(st.getAge()));
                    txtId.setText(String.valueOf(st.getId()));
                    txtName.setText(st.getName());
                    txtSurname.setText(st.getSurname());
                }
            }
        });

    }

    public void backToStudentHome() {
        Home.changeScreen("/home.fxml");
    }

}

