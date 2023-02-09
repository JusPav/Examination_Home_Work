package lt.code.academy.exam;

import java.util.ArrayList;

public class ExamQuestionDB {
    private Exam exam;
    private ArrayList<ExamAnswer> examAnswers = new ArrayList<>();
    private ExamQuestionDB() {
    }
    public ExamQuestionDB(Exam exam, ArrayList<ExamAnswer> examAnswers) {
        this.exam = exam;
        this.examAnswers = examAnswers;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public ArrayList<ExamAnswer> getExamAnswers() {
        return examAnswers;
    }
    public void setExamAnswers(ArrayList<ExamAnswer> examAnswers) {
        this.examAnswers = examAnswers;
    }
}
