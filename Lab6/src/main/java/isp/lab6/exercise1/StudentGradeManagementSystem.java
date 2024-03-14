package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentGradeManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();


    public void addStudent(String name, String id, HashMap<String, Integer> grades) {
        boolean exists = false;
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println("A student with the same ID already exists.");
        } else {
            Student student = new Student(name, id, grades);
            studentList.add(student);
            System.out.println("Student added successfully.");
        }
    }


    public void removeStudent(String id) {

        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.remove(i);
                found = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void updateStudent(String id, String name, HashMap<String, Integer> updatedGrades) {


        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                if (!name.isEmpty()) {
                    studentList.get(i).setName(name);
                }


                Set<String> updatedGradesKeys = updatedGrades.keySet();

                for (String key : updatedGradesKeys) {
                    studentList.get(i).getGrades().put(key, updatedGrades.get(key));
                }


                found = true;
                System.out.println("Student information updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public double calculateAverageGrade(String id) {
        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                HashMap<String, Integer> grades = studentList.get(i).getGrades();

                if (grades.isEmpty()) {
                    System.out.println("No grades found for this student.");
                } else {
                    double sum = 0;
                    int count = 0;

                    for (int grade : grades.values()) {
                        sum += grade;
                        count++;
                    }

                    double average = sum / count;
                    System.out.println("Average grade for " + studentList.get(i).getName() + " is " + average);

                    return average;
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }

        return 0;
    }

    public void displayStudents() {
        System.out.println("List of students:");

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i));
        }
    }

    public Student getStudentById(String id) {
        return studentList.stream().filter(s -> s.getId().equals(id)).collect(Collectors.toList()).get(0);
    }
}

