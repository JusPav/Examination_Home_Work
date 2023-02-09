package lt.code.academy.exam;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
public class ExamReadAnswersJson {
    String examFile = "files\\Exam\\Exam.json";
    public ExamQuestionDB getExam() {
        ObjectMapper mapper = new ObjectMapper();
        ExamQuestionDB ExamAnswers;

        try {
            ExamAnswers = mapper.readValue(new File(examFile), ExamQuestionDB.class);
            return ExamAnswers;
        } catch (IOException e) {
            System.out.println("Cannot read from file" + e.getMessage());
        }
        return null;
    }
}



