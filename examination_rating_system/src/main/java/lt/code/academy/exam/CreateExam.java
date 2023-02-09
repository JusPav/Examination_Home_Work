package lt.code.academy.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateExam {
    public ExamQuestionDB examQuestionDB;
    ArrayList<ExamAnswer> examAnswers = new ArrayList<>();
    Exam exam = new Exam();
    Scanner sc = new Scanner(System.in);
    public void createExamInfo() {

        System.out.println("Enter Exam ID");
        int examId = sc.nextInt();
        System.out.println("Enter Exam name");
        sc.nextLine();
        String examName = sc.nextLine();
        System.out.println("Enter Exam type");
        String examType = sc.nextLine();
        exam = new Exam(examId, examName, examType);
    }
    public void createQuestionsAndAnswers() {

        int questionNumb = 0;
        String action = "";
        Answer correctAnswers;

        while (!action.equals("EXIT")) {
            questionNumb++;
            System.out.printf("Question Nr. %s", questionNumb + ". Enter correct answer A,B,C,D\n");
            String correct = sc.nextLine().toUpperCase();

            switch (correct) {
                case "A" -> correctAnswers = Answer.A;
                case "B" -> correctAnswers = Answer.B;
                case "C" -> correctAnswers = Answer.C;
                case "D" -> correctAnswers = Answer.D;
                default -> {
                    System.out.println("There is no such choice");
                    continue;
                }
            }
            examAnswers.add(new ExamAnswer(questionNumb, correctAnswers));
            System.out.println("Continue press ENTER. Finish type Exit");
            action = sc.nextLine().toUpperCase();
        }
        examQuestionDB = new ExamQuestionDB(exam, examAnswers);
    }
}






