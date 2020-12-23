package main.java.service;

import javafx.collections.ObservableList;
import main.java.model.Student;
import main.java.repository.StudentRepo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentRepo sr;
    public StudentService(){

        sr =new StudentRepo();
    }

    public List<Student> getList(){

        return sr.getStudentList();

    }

    public void addStudent(Student st){

        sr.addStudentToList(st);
    }
    public void deleteStudent(Student st)
    {
        sr.deleteStudentToList(st);


    }
    public void updateStudent(Student st, int oldId){

        sr.updateStudentToList(st,oldId);
    }
    public List<String> validateStudent(Student student) {
        List<String> errors = new ArrayList<>();
        if (student.getId() == 0) {
            errors.add("This id field is a mistake");
        }
        if (student.getName().equals("")) {
            errors.add("This name field can not be empty");
        }
        if (student.getSurname().equals("")) {
            errors.add("This surname field can not be empty");
        }
        if (student.getAge() < 15 || student.getAge() > 40) {
            errors.add("This age field is a mistake");
        }
        return errors;
    }
  }
