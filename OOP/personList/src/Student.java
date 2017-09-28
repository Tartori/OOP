/**
 * Created by julia on 16-Dec-16.
 */
public class Student extends Person {
    private String grade;
    public Student(String first, String last, String grade) {
        this(first, last);
        this.grade=grade;
    }
    public Student(String first, String last){
        super  (first, last);
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String getDescription() {
        return grade+" Grade Student";
    }
}
