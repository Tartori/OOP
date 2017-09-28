/**
 * Created by julia on 16-Dec-16.
 */
public class Employee extends Person {
    private String department;

    public Employee(String first, String last, String department) {
        this(first, last);
        this.department=department;
    }

    public Employee(String first, String last){
        super  (first, last);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDescription() {
        return "Works for  "+department;
    }
}
