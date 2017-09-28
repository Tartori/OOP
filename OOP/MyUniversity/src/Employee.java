import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

public class Employee extends Person {

	@XmlElement
	private String department;

	public Employee() {
		super();
	}

	public Employee(String aName, String anEmail, String aDepartment) {
		super(aName, anEmail);
		department = aDepartment;
	}

	public String getDepartment() {
		return this.department;
	}


	public String getDescription() {
		return "Works in " + this.department;
	}

}
