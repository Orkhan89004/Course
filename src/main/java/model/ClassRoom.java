package main.java.model;

public class ClassRoom {
    private int id;
    private String name;
    private String lesson;
    private String teacher;
    private Double time;

    public ClassRoom() {
    }

    public ClassRoom(int id, String name, String lesson, String teacher, Double time) {
        this.id = id;
        this.name = name;
        this.lesson = lesson;
        this.teacher = teacher;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}
