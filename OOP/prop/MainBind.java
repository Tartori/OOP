package prop;

public class MainBind {

	public static void main(String[] args) {
		// Two accounts own to the same person
		Account a1 = new Account();
		a1.setOwner("Alice");
		Account a2 = new Account();
		System.out.println(a2.getOwner()); // prints null
		a2.ownerProperty().bind(a1.ownerProperty());
		System.out.println(a2.getOwner()); // prints Alice
		a1.setOwner("Alice Wonderland");
		System.out.println(a2.getOwner()); // prints Alice Wonderland

	}

}
