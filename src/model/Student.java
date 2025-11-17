package model;

import java.util.Scanner;

public class Student extends Person {

    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student() {
        super();
    }

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public void inputDetails(Scanner scan) {


        System.out.print("Enter Roll No: ");
        while (true) {
            try {
                rollNo = Integer.parseInt(scan.nextLine().trim());
                if (rollNo <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid roll number. Enter again: ");
            }
        }


        System.out.print("Enter Name: ");
        while (true) {
            name = scan.nextLine().trim();
            if (!name.isEmpty()) break;
            System.out.print("Name cannot be empty. Enter Name: ");
        }


        System.out.print("Enter Email: ");
        while (true) {
            email = scan.nextLine().trim();
            if (!email.isEmpty()) break;
            System.out.print("Email cannot be empty. Enter Email: ");
        }

    
        System.out.print("Enter Course: ");
        while (true) {
            course = scan.nextLine().trim();
            if (!course.isEmpty()) break;
            System.out.print("Course cannot be empty. Enter Course: ");
        }


        System.out.print("Enter Marks (0-100): ");
        while (true) {
            try {
                marks = Double.parseDouble(scan.nextLine().trim());
                if (marks < 0 || marks > 100) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid marks. Enter again (0-100): ");
            }
        }

        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B+";
        else if (marks >= 60) grade = "B";
        else if (marks >= 50) grade = "C";
        else if (marks >= 40) grade = "D";
        else grade = "F";
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    @Override
    public void displayInfo() {
        displayDetails();
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        calculateGrade();
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks;
    }
}
