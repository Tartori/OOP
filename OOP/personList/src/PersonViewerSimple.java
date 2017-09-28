/**
 * Created by julia on 16-Dec-16.
 */
public class PersonViewerSimple {
    public static void view(Person person)
    {
        System.out.println("Person: ");

        System.out.println("  Name: " + person.getName());
        System.out.println("  Email: " + person.getEmail());
        System.out.println("  Description: " + person.getDescription());
        System.out.println("\n");
    }
}
