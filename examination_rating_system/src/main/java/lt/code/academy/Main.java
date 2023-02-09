package lt.code.academy;

import lt.code.academy.exam.CreateExam;
import lt.code.academy.exam.ExamQuestionJson;
import lt.code.academy.student.StudentWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        String action;

        do {
            menu();
            action = sc.nextLine();

            main.userAction(action);
        } while (!action.equals("5"));
    }
    private void userAction(String action) throws IOException {

        switch (action) {
            case "1" -> addStudents();
            case "2" -> createExam();
            case "3" -> examAttend();
            case "4" -> rateExam();
            case "5" -> System.out.println("Program is finished");
            default -> System.out.println("There is no such choice");
        }
    }
    public void addStudents() {
        StudentWriteFile studentWriteFile = new StudentWriteFile();
        studentWriteFile.addStudent();
        studentWriteFile.writeToStudentFile();
    }
    public void createExam() {
        CreateExam createExam = new CreateExam();
        ExamQuestionJson examQuestionJson = new ExamQuestionJson();
        createExam.createExamInfo();
        createExam.createQuestionsAndAnswers();
        examQuestionJson.writeExamToFile(createExam.examQuestionDB);
    }
    public void examAttend() throws IOException {
        AttendExam attendExam = new AttendExam();
        attendExam.attend();
    }
    public void rateExam() throws IOException {
        RateExam rateExam = new RateExam();
        rateExam.ratingExam();
    }
    public static void menu() {
        System.out.println(""" 
                1 - Add Student
                2 - Create Exam
                3 - Attend Exam
                4 - Rate Exam
                5 - Finish program """);
    }
}