/**
 * Created by julian on 16-Dec-16.
 */
public class PersonViewer {
    public static void view(Person person)
    {
        System.out.println(person.getClass().getName()+": ");

        System.out.println("  Name: " + person.getName());
        System.out.println("  Email: " + person.getEmail());
        System.out.println("  Description: " + person.getDescription());
        System.out.println("\n");
    }
}
