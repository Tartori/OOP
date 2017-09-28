package Exam3;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public final class PetOwnerMain {

	private PetOwnerMain() {
	}


	public static void main(String[] args) throws JAXBException, IOException {

		ArrayList<Pet> petList = new ArrayList<Pet>();

		Dog d1 = new Dog();
		d1.setName("Strubbel");
		d1.setRace("Chihuahua");
		d1.setTaxNbr("1234-973-XY");
		d1.setFightingDog(false);
		petList.add(d1);

		Dog d2 = new Dog();
		d2.setName("Bulli");
		d2.setRace("Bulldog");
		d2.setTaxNbr("7777-786-AB");
		d2.setFightingDog(true);
		petList.add(d2);

		Cat c1 = new Cat();
		c1.setName("Minka");
		c1.setRace("Birma");
		c1.setShortHair(false);
		petList.add(c1);
		
		
		PetOwner fred = new PetOwner();
		fred.setName("Fred");
		fred.setGender("male");
		fred.setAddress("Bern, Waldbachstrasse 90");
		fred.setPetList(petList);
		
		
		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(PetOwner.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		m.marshal(fred, System.out);
	
	}
}
