package lt.code.academy.student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentReadFile {
    ArrayList<Student> students = new ArrayList<>();
    String studentFile = "files\\Students\\students.csv";
    public ArrayList<Student> getData() {

        String readStudent;
        try (BufferedReader br = new BufferedReader(new FileReader(studentFile))) {
            while ((readStudent = br.readLine()) != null) {
                String[] get = readStudent.split(",");
                int Id = Integer.parseInt(get[0]);
                String name = get[1];
                String surname = get[2];
                students.add(new Student(Id, name, surname));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot found a file" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read from file" + e.getMessage());
        }
        return students;
    }
}
