package Exam3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Dog extends Pet {

	private boolean fightingDog;
	private String taxNbr;


	@XmlElement(name="dangerous")
	public boolean isFightingDog() {
		return fightingDog;
	}

	public void setFightingDog(boolean fightingDog) {
		this.fightingDog = fightingDog;
	}

	public String getTaxNbr() {
		return taxNbr;
	}

	public void setTaxNbr(String taxNbr) {
		this.taxNbr = taxNbr;
	}
}
