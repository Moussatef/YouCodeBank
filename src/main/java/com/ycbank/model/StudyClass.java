package com.ycbank.model;

import java.util.List;

class Position{
    public int local;
    public int floor;
    public Position(int local,int floor){this.local=local;this.floor=floor;}
}

public class StudyClass {

    private Long id;
    private Coach coach;
    private List<Student> students;
    private Position position;

    public StudyClass(){

    }

    public StudyClass(Long id, Coach coach, List<Student> students, Position position) {
        this.id = id;
        this.coach = coach;
        this.students = students;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "StudyClass{" +
                "id=" + id +
                ", coach=" + coach +
                ", students=" + students +
                ", position=" + position +
                '}';
    }
}
