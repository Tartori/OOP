import java.util.Objects;

public class Person {

    private String firstname;
    private String lastname;
    private String eMail;

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Person(String first, String last) {
        firstname = first;
        lastname = last;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public String getDescription() {
        return "Person with a name:" + getName();
    }

    public String getEmail() {
        return eMail;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;

        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname);
    }

}