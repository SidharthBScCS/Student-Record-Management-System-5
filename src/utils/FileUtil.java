package utils;

import model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Student> loadStudents(String fileName) {
        List<Student> list = new ArrayList<>();
        File f = new File(fileName);

        if (!f.exists()) {
            System.out.println("Data file not found");
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                try {
                    int roll = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String course = parts[3].trim();
                    double marks = Double.parseDouble(parts[4].trim());

                    Student s = new Student(roll, name, email, course, marks);
                    list.add(s);
                } catch (NumberFormatException ex) {
                    System.out.println("Skipping invalid record: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }

    public static void saveStudents(String fileName, List<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void fileAttributes(String fileName) {
        File f = new File(fileName);
        System.out.println("File Attributes by SIDHARTH 2401720003");
        System.out.println("Name: " + f.getName());
        System.out.println("Path: " + f.getAbsolutePath());
        System.out.println("Readable: " + f.canRead());
        System.out.println("Writable: " + f.canWrite());
        System.out.println("Size: " + f.length() + " bytes");
    }

    public static void randomAccessDemo(String fileName, int bytesToRead) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            byte[] data = new byte[bytesToRead];
            int read = raf.read(data);

            if (read > 0) {
                System.out.println("Random Access (first " + read + " bytes)");
                System.out.println(new String(data, 0, read));
            } else {
                System.out.println("RandomAccessFile: Nothing to read");
            }

        } catch (FileNotFoundException e) {
            System.out.println("RandomAccessFile: File not found");
        } catch (IOException e) {
            System.out.println("RandomAccessFile error: " + e.getMessage());
        }
    }
}
