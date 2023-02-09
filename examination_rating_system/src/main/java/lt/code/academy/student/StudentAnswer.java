package lt.code.academy.student;

import lt.code.academy.exam.Answer;
import lt.code.academy.exam.Exam;

import java.util.HashMap;

public class StudentAnswer {
    private Exam exam;
    private Student student;
    private HashMap<Integer, Answer> studentAnswers;
    private StudentAnswer() {
    }
    public StudentAnswer(Exam exam, Student student, HashMap<Integer, Answer> studentAnswers) {
        this.exam = exam;
        this.student = student;
        this.studentAnswers = studentAnswers;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public HashMap<Integer, Answer> getStudentAnswers() {
        return studentAnswers;
    }
    public void setStudentAnswers(HashMap<Integer, Answer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }
}
