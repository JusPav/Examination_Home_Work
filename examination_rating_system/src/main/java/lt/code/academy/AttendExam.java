package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.code.academy.exam.ExamReadAnswersJson;
import lt.code.academy.exam.ExamAnswer;
import lt.code.academy.exam.*;
import lt.code.academy.student.Student;
import lt.code.academy.student.StudentAnswer;
import lt.code.academy.student.StudentReadFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class AttendExam implements Serializable {
    int Id;
    private String name;
    private String surname;
    private Student student;
    public void attend() throws IOException {
        Scanner sc = new Scanner(System.in);
        StudentReadFile getStudent = new StudentReadFile();

        System.out.println("Enter ID of student");
        boolean checkID = true;
        while (checkID) {
            Id = sc.nextInt();
            for (Student readStudent : getStudent.getData()) {
                if (Id == readStudent.getId()) {
                    name = readStudent.getName();
                    surname = readStudent.getSurname();
                    student = readStudent;
                    checkID = false;
                }
            }
            if (checkID) {
                System.out.println("There is no student by such ID");
                return;
            }
            System.out.println("Welcome: " + name + " " + surname);
            ArrayList<String> result = new ArrayList<>();
            List<File> files = List.of(Objects.requireNonNull(new File("files\\PassByStudents\\").listFiles()));
            for (File fill : files) {
                if (fill.isFile()) {
                    result.add(fill.getName());
                }
            }
            boolean hadAttended = true;
            ObjectMapper mapper = new ObjectMapper();
            StudentAnswer getID;

            for (String fileName : result) {
                getID = mapper.readValue(new File("files\\PassByStudents\\" + fileName), StudentAnswer.class); {
                    if (student.getId() == getID.getStudent().getId()) {
                        System.out.println("The student is already attended this exam");
                        hadAttended = false;
                    }
                }
            }
            if (hadAttended) {
                System.out.println("Exam is started");
                ExamReadAnswersJson examReadAnswersJson = new ExamReadAnswersJson();
                ExamQuestionDB answersJson = examReadAnswersJson.getExam();
                HashMap<Integer, Answer> answers = new HashMap<>();

                for (ExamAnswer examAnswer : answersJson.getExamAnswers()) {
                    System.out.println(examAnswer.getQuestionNumb());

                    String answer = null;
                    while (answer == null) {

                        answer = sc.next().toUpperCase();
                        switch (answer) {
                            case "A" -> answers.put(examAnswer.getQuestionNumb(), Answer.A);
                            case "B" -> answers.put(examAnswer.getQuestionNumb(), Answer.B);
                            case "C" -> answers.put(examAnswer.getQuestionNumb(), Answer.C);
                            case "D" -> answers.put(examAnswer.getQuestionNumb(), Answer.D);
                            default -> System.out.println("There is no such choice");
                        }
                    }
                }
                System.out.println("Exam done");

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                File file = new File("files\\PassByStudents\\" + Id + "_" + name + "_" + surname + ".json");
                try {
                    objectMapper.writeValue(file, new StudentAnswer(answersJson.getExam(), student, answers));
                } catch (IOException e) {
                    System.out.println("Cannot write to file" + e.getMessage());
                }
            }
        }
    }
}

