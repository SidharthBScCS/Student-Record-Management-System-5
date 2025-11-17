package service;

import java.util.Scanner;

public interface RecordActions {

    void addStudent(Scanner scan);

    void deleteStudent(Scanner scan);

    void updateStudent(Scanner scan);

    void searchStudent(Scanner scan);

    void viewAllStudents();
}
