package com.student.management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement manager = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.print("ID: "); int id = sc.nextInt();
        System.out.print("Name: "); String name = sc.next();
        System.out.print("Age: "); int age = sc.nextInt();
        System.out.print("Course: "); String course = sc.next();
        System.out.print("Grade: "); double grade = sc.nextDouble();
        manager.addStudent(new Student(id, name, age, course, grade));

        do {
        	
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. View All Students");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Exit");
            
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.viewAll();
                    break;
                case 2:
                    System.out.print("Enter ID: "); int sid = sc.nextInt();
                    Student found = manager.searchById(sid);
                    System.out.println(found != null ? found : "Not found.");
                    break;
                case 3:
                    System.out.print("Enter ID to update: "); int uid = sc.nextInt();
                    System.out.print("New Name: "); String uname = sc.next();
                    System.out.print("New Age: "); int uage = sc.nextInt();
                    System.out.print("New Course: "); String ucourse = sc.next();
                    System.out.print("New Grade: "); double ugrade = sc.nextDouble();
                    manager.updateStudent(uid, uname, uage, ucourse, ugrade);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: "); int did = sc.nextInt();
                    manager.deleteStudent(did);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}