/**
 * Created by julia on 16-Dec-16.
 */
public class PersonViewerTest {
    public static void main(String... args){
        Student s = new Student("Holy", "Dudero","A");
        Professor p = new Professor("Serious","super", "Alchemy");
        Employee e = new Employee("Alexis", "Chapen", "IT");
        s.seteMail("Holy@student.ch");
        p.seteMail("Serious@prof.ch");
        e.seteMail("Alexis@employees.ch");
        PersonViewerSimple.view(s);
        PersonViewerSimple.view(p);
        PersonViewerSimple.view(e);
        PersonViewer.view(s);
        PersonViewer.view(p);
        PersonViewer.view(e);
    }
}
