package main.java.service;

import javafx.collections.ObservableList;
import main.java.model.Student;
import main.java.model.Teacher;
import main.java.repository.TeacherRepo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    TeacherRepo tre;

    public TeacherService() {
        tre = new TeacherRepo();
    }

    public List<Teacher> getTeacherList() {

        return tre.getTeacherToList();
    }

    public void addTeacherTable(Teacher tr) {
        tre.addTeacherToTable(tr);
    }

    public void deleteTeacher(Teacher tr) {
        tre.deleteTeacherToList(tr);


    }

    public void updateTeacher(Teacher tr, int oldId) {

        tre.updateTeacherToList(tr, oldId);
    }

    public List<String> validateTeacher(Teacher teacher) {
        List<String> errors = new ArrayList<>();
        if (teacher.getId() == 0) {
            errors.add("This id field is a mistake ");

        }
        if (teacher.getName().equals("")) {
            errors.add("This name field can not be empty");
        }
        if (teacher.getSurname().equals("")) {
            errors.add("This surname field can not be empty");
        }
        if (teacher.getAge() < 30 || teacher.getAge() > 50) {
            errors.add("this age field is a mistake");
        }
        return errors;
    }
}

