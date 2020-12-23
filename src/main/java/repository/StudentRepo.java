package main.java.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    private static List<Student> list = new ArrayList(){{
        add( new Student(1, "Orxan", "Mirzayev", 22));
        add( new Student(2, "Jale", "Yusifova", 25));
        add( new Student(3, "Eltun", "Ferzeliyev", 26));
    }};

    public List<Student> getStudentList() {
        List<Student> newList = new ArrayList<>(list);
        return newList;
    }
    public void addStudentToList(Student st){
        list.add(st);
    }
    public void deleteStudentToList(Student st) {
        list.remove(st);
    }

    public void updateStudentToList(Student st,int oldId){
      for(int i=0;i<list.size();i++){
          Student student=list.get(i);
          if(student.getId()==oldId){
              list.set(i,st);


          }
      }
    }
}
