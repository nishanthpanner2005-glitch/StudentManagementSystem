package com.student.management;

import java.util.*;
import java.io.*;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    // Load data when program starts
    public StudentManagement() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
        System.out.println("Student added: " + s.getName());
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void updateStudent(int id, String name, int age, String course, double grade) {
        Student s = searchById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            s.setGrade(grade);
            saveToFile();
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        Student s = searchById(id);
        if (s != null) {
            students.remove(s);
            saveToFile();
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Save all students to file
    private void saveToFile() {
        try {
            FileWriter fw = new FileWriter(FILE_NAME);
            for (Student s : students) {
                fw.write(s.getId() + "," + s.getName() + "," + 
                         s.getAge() + "," + s.getCourse() + "," + 
                         s.getGrade() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    // Load students from file
    private void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String course = parts[3];
                    double grade = Double.parseDouble(parts[4]);
                    students.add(new Student(id, name, age, course, grade));
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}