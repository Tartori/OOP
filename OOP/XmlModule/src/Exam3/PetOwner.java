package Exam3;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement
public class PetOwner {
	private String name;
	private String gender;
	private String address;

	@XmlElementWrapper(name="pets")
	@XmlElement(name="pet")
	private ArrayList<Pet> petList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPetList(ArrayList<Pet> pets) {
		this.petList = pets;
	}
}
