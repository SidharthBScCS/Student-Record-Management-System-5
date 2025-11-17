package main;

import service.StudentManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String DATA_FILE = "students.txt"; 
        StudentManager manager = new StudentManager(DATA_FILE);
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System 5 by SIDHARTH 2401720003");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Sort by Marks");
            System.out.println("7. Save and Exit");
            System.out.print("Enter choice: ");

            String choice = scan.nextLine().trim();

            switch (choice) {

                case "1":
                    manager.addStudent(scan);
                    break;

                case "2":
                    manager.viewAllStudents();
                    break;

                case "3":
                    manager.searchStudent(scan);
                    break;

                case "4":
                    manager.deleteStudent(scan);
                    break;

                case "5":
                    manager.updateStudent(scan);
                    break;

                case "6":
                    manager.viewAllStudents();  
                    break;

                case "7":
                    manager.saveToFile();
                    System.out.println("Exiting... Thank you by SIDHARTH 2401720003");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
