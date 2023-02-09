package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.code.academy.exam.ExamQuestionDB;
import lt.code.academy.student.RateStudent;
import lt.code.academy.student.StudentAnswer;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RateExam implements Serializable {
    String examFile = "files\\Exam\\Exam.json";
    String resultFile = "files\\Result\\Results.json";
    public void ratingExam() throws IOException {

        List<String> resultsByAttendedStudents = new ArrayList<>();
        List<File> fillByAttenders = List.of(Objects.requireNonNull(new File("files\\PassByStudents\\").listFiles()));
        for (File fill : fillByAttenders) {
            if (fill.isFile()) {
                resultsByAttendedStudents.add(fill.getName());
            }
        }
        ExamQuestionDB correctAnswers;
        StudentAnswer studentAnwers;
        ArrayList<RateStudent> rateStudents = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        correctAnswers = mapper.readValue(new File(examFile), ExamQuestionDB.class);

        for (String studentAnswers : resultsByAttendedStudents) {
            studentAnwers = mapper.readValue(new File("files\\PassByStudents\\" + studentAnswers), StudentAnswer.class);
            {
                int correctAnswer = 0;
                for (int i = 0; i < correctAnswers.getExamAnswers().size(); i++) {
                    if (correctAnswers.getExamAnswers().get(i).getCorrectAnswers() == studentAnwers.getStudentAnswers().get(i + 1)) {
                        correctAnswer++;
                    }
                }
                int rate = (correctAnswer * 10) / correctAnswers.getExamAnswers().size();
                rateStudents.add(new RateStudent(studentAnwers.getStudent().getId(), studentAnwers.getStudent().getName(), studentAnwers.getStudent().getSurname(), rate));
            }
        }
        RatingData ratingData = new RatingData(correctAnswers.getExam(), rateStudents);

        ObjectMapper mapperWriter = new ObjectMapper();
        mapperWriter.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(resultFile);
        try {
            mapperWriter.writeValue(file, ratingData);
            System.out.println("Results File is created");
        } catch (IOException e) {
            System.out.println("Cannot write to file" + e.getMessage());
        }
    }
}
