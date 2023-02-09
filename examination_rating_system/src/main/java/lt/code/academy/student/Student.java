package lt.code.academy.student;

public class Student {
    private int Id;
    private String name;
    private String surname;
    Student() {
    }
    public Student(int id, String name, String surname) {
        this.Id = id;
        this.name = name;
        this.surname = surname;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
