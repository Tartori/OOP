package prop;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MainProp {

	public static void main(String[] args) {

		final Account a = new Account();
		a.setOwner("Alice");
		a.setBalance(1250);
		
		// Listener of ObservableValue
		a.balanceProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> o,
					Number oldVal, Number newVal) {
				System.out.println("Account balance changed :"+oldVal + " -> " + newVal);
			}
		});
		
		// Listener of Observable
		a.balanceProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable o) {
				System.out.println("Account balance may have changed: "+a.getBalance());
			}
		});
		
		a.setBalance(a.getBalance() + 250);
		a.setBalance(a.getBalance() + 250);

	}

}
