package main.java.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Student;
import main.java.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepo {
    private static List<Teacher> list = new ArrayList(){{
        add( new Teacher(1, "Elsen", "Kerimov", 35));
        add( new Teacher(2, "Oqtay", "Yunusov", 65));
        add( new Teacher(3, "Qudret", "Mirzayev", 45));
    }};

    public List<Teacher> getTeacherToList(){
        List<Teacher> newlist= new ArrayList<>(list);
        return newlist;
    }
   public void addTeacherToTable(Teacher tr){
        list.add(tr);
   }
    public void deleteTeacherToList(Teacher tr) {
        list.remove(tr);
    }

    public void updateTeacherToList(Teacher tr,int oldId){
        for(int i=0;i<list.size();i++){
            Teacher tea=list.get(i);
            if(tea.getId()==oldId){
                list.set(i,tr);


            }
        }
    }
}
