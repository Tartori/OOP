package Exam3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Cat extends Pet {

	private boolean shortHair;


	public boolean isShortHair() {
		return shortHair;
	}

	public void setShortHair(boolean shortHair) {
		this.shortHair = shortHair;
	}
}
