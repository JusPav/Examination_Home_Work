package lt.code.academy;

import lt.code.academy.exam.Exam;
import lt.code.academy.student.RateStudent;

import java.util.ArrayList;

public class RatingData {
    private Exam exam;
    private ArrayList<RateStudent> rateStudents;
    RatingData() {
    }
    public RatingData(Exam exam, ArrayList<RateStudent> rateStudents) {
        this.exam = exam;
        this.rateStudents = rateStudents;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public ArrayList<RateStudent> getRateStudents() {
        return rateStudents;
    }
    public void setRateStudents(ArrayList<RateStudent> rateStudents) {
        this.rateStudents = rateStudents;
    }
}
