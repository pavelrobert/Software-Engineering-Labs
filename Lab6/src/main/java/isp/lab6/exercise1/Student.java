package isp.lab6.exercise1;

import java.util.HashMap;

class Student {
    private String name;
    private String id;
    private HashMap<String, Integer> grades;

    public Student(String name, String id, HashMap<String, Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Grades: " + grades;
    }
}