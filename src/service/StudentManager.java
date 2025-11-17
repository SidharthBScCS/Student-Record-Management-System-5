package service;

import model.Student;
import exception.StudentNotFoundException;
import utils.FileUtil;
import threads.Loader;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager implements RecordActions {

    private List<Student> studentList;
    private Map<Integer, Student> studentMap;
    private final String dataFile;

    public StudentManager(String dataFile) {
        this.dataFile = dataFile;
        this.studentList = new ArrayList<>();
        this.studentMap = new HashMap<>();

        List<Student> loaded = FileUtil.loadStudents(dataFile);
        for (Student s : loaded) {
            studentList.add(s);
            studentMap.put(s.getRollNo(), s);
        }
    }

    @Override
    public void addStudent(Scanner scan) {
        Student newStudent = new Student();
        newStudent.inputDetails(scan);

        int roll = newStudent.getRollNo();
        if (studentMap.containsKey(roll)) {
            System.out.println("Student with same roll number already exists.");
            return;
        }

        Thread t = new Thread(new Loader("Adding student"));
        t.start();
        try { t.join(); } catch (InterruptedException e) {}

        studentList.add(newStudent);
        studentMap.put(roll, newStudent);
        System.out.println("Student added successfully.");
    }

    @Override
    public void deleteStudent(Scanner scan) {
        System.out.print("Enter roll number to delete: ");
        int roll;

        try {
            roll = Integer.parseInt(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
            return;
        }

        if (!studentMap.containsKey(roll)) {
            System.out.println("Student not found.");
            return;
        }

        Student removed = studentMap.remove(roll);
        studentList.remove(removed);
        System.out.println("Student deleted successfully.");
    }

    @Override
    public void updateStudent(Scanner scan) {
        System.out.print("Enter roll number to update: ");
        int roll;

        try {
            roll = Integer.parseInt(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
            return;
        }

        Student s = studentMap.get(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter updated name: ");
        String input = scan.nextLine().trim();
        if (!input.isEmpty()) s.setName(input);

        System.out.print("Enter updated email: ");
        input = scan.nextLine().trim();
        if (!input.isEmpty()) s.setEmail(input);

        System.out.print("Enter updated course: ");
        input = scan.nextLine().trim();
        if (!input.isEmpty()) s.setCourse(input);

        System.out.print("Enter updated marks: ");
        input = scan.nextLine().trim();
        if (!input.isEmpty()) {
            try {
                double m = Double.parseDouble(input);
                if (m < 0 || m > 100) throw new NumberFormatException();
                s.setMarks(m);
            } catch (NumberFormatException e) {
                System.out.println("Invalid marks.");
            }
        }

        System.out.println("Student updated.");
    }

    @Override
    public void searchStudent(Scanner scan) {
        System.out.println("Search by 1.Roll No or 2.Name");
        String choice = scan.nextLine().trim();

        try {
            if (choice.equals("1")) {
                System.out.print("Enter roll no: ");
                int roll = Integer.parseInt(scan.nextLine().trim());
                Student s = studentMap.get(roll);
                if (s == null) throw new StudentNotFoundException("Student not found.");
                s.displayDetails();
            } else {
                System.out.print("Enter name: ");
                String name = scan.nextLine().trim();

                List<Student> found = studentList.stream()
                        .filter(st -> st.getName().equalsIgnoreCase(name))
                        .collect(Collectors.toList());

                if (found.isEmpty()) throw new StudentNotFoundException("Student not found.");

                for (Student st : found) st.displayDetails();
            }
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    @Override
    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        studentList.sort(Comparator.comparingDouble(Student::getMarks).reversed());

        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            itr.next().displayDetails();
        }
    }

    public void saveToFile() {
        Thread t = new Thread(new Loader("Saving records"));
        t.start();
        try { t.join(); } catch (InterruptedException e) {}
        FileUtil.saveStudents(dataFile, studentList);
        System.out.println("Records saved.");
    }

    public void showFileAttributes() {
        FileUtil.fileAttributes(dataFile);
    }

    public void randomAccessDemo(int nBytes) {
        FileUtil.randomAccessDemo(dataFile, nBytes);
    }
}
