package lt.code.academy.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class ExamQuestionJson implements Serializable {
    String examFile = "files\\Exam\\Exam.json";
    public void writeExamToFile(ExamQuestionDB examQuestionDB) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(examFile);
        try {
            mapper.writeValue(file, examQuestionDB);
            System.out.println("Exam File created");
        } catch (IOException e) {
            System.out.println("Cannot write to file" + e.getMessage());
        }
    }
}
