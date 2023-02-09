package lt.code.academy.student;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StudentWriteFile {
    int Id;
    String name;
    String surname;
    String studentFile = "files\\Students\\students.csv";
    List<Student> students = new ArrayList<>();
    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID:");
        Id = sc.nextInt();
        System.out.println("Enter student name:");
        sc.nextLine();
        name = sc.nextLine();
        System.out.println("Enter student surname:");
        surname = sc.nextLine();

        students.add(new Student(Id, name, surname));
    }
    public void writeToStudentFile() {
        String studentsInfo;

        for (Student student : students) {
            studentsInfo = student.getId() + "," + student.getName() + "," + student.getSurname();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentFile, true))) {
                bw.write(studentsInfo);
                bw.newLine();
            } catch (IOException e) {
                System.out.println("Cannot write to file" + e.getMessage());
            }
        }
    }
}
