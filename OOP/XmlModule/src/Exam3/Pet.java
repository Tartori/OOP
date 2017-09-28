package Exam3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({Cat.class,Dog.class})
@XmlType(propOrder = { "race", "name"})
abstract public class Pet {
	private String name;
	private String race;


	@XmlElement(name="animal_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
}
