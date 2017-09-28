package prop;

public class MainBind2 {

	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setOwner("Alice");
		Account a2 = new Account();
		a2.ownerProperty().bindBidirectional(a1.ownerProperty());
		System.out.println(a2.getOwner()); // prints �Alice�
		a2.setOwner("Alice Wonderland");
		System.out.println(a1.getOwner()); // prints �Alice Wonderland�
	}

}
