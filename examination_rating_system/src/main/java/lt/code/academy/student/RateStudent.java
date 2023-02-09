package lt.code.academy.student;

public class RateStudent extends Student {
    private int rating;
    public RateStudent(int id, String name, String surname, int rating) {
        super(id, name, surname);
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
