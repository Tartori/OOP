import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public final class UniMain {

	private UniMain() {
	}

	private static final String UNIVERSITY_XML = "c:\\temp\\university.xml";

	public static void main(String[] args) throws JAXBException, FileNotFoundException {

		// create some persons 
		Student student = new Student("Max", "max@bfh.ch", "B");
		Student student2 = new Student("Tom", "tom@bfh.ch", "c");
		Professor prof = new Professor("Mr. X", "prof.x@bfh.ch", "IT Security");
		Employee empl = new Employee("Erni Schmidt", "erni.schmidt@bfh.ch",
				"HR");

		// create uni, assigning staff and students
		University bfh = new University("bfh");

		bfh.addStaff(student);
		bfh.addStaff(prof);
		bfh.addStaff(empl);

		bfh.addStudent(student);
		bfh.addStudent(student2);

		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(University.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		m.marshal(bfh, System.out);

		// Write to File
		m.marshal(bfh, new File(UNIVERSITY_XML));

		// Output result from XML File
		Unmarshaller um = context.createUnmarshaller();
		University bfh2 = (University) um.unmarshal(new FileReader(
				UNIVERSITY_XML));

		List<Person> list = bfh2.getStaff();
		if (list != null) {
			for (Person per : list)
				System.out.println("Employee: " + per.getName() + " desc: " + per.getDescription());
		}
		List<Student> list2 = bfh2.getStudents();
		if (list != null) {
			for (Student per : list2)
				System.out.println("Student: " + per.getName() + " desc: " + per.getDescription());
		}
	}
}
