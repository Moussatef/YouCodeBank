package com.ycbank.model;

import java.util.List;

public class Department {

    private Long id;
    private String name;
    private List<Employee> employees;
    private int floor;

    public Department(){
        this.id = 1L + (long) (Math.random() * (10L - 1L));
    }

    public Department(String name, List<Employee> employees, int floor) {
        this.id = 1L + (long) (Math.random() * (10L - 1L));
        this.name = name;
        this.employees = employees;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                ", floor=" + floor +
                '}';
    }
}
