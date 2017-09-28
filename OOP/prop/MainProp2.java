package prop;

public class MainProp2 {

	public static void main(String[] args) {

		final Account a = new Account();
		a.setOwner("Alice");
		a.setBalance(1250);
		
		// Listener of ObservableValue
		a.balanceProperty().addListener((o, oldValue, newValue) -> {
			System.out.println("Account balance changed :"+oldValue + " -> " + newValue);
			});
		
		// Listener of Observable
		a.balanceProperty().addListener((o) -> {
			System.out.println("Account balance may have changed: "+a.getBalance());
			});
		
		a.setBalance(a.getBalance() + 250);
		a.setBalance(a.getBalance() + 250);

	}

}
