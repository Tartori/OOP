/**
 * Created by julia on 16-Dec-16.
 */
public class Professor extends Person {
    private String subject;

    public Professor(String first, String last, String subject) {
        this(first, last);
        this.subject=subject;
    }

    public Professor(String first, String last){
        super  (first, last);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getDescription() {
        return "Teaches "+subject;
    }
}
