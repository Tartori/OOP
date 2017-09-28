package prop;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MainFluent {

	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setBalance(500);
		Account a2 = new Account();
		a2.setBalance(1000);

		// Exchange rate CHF -> EUR
		DoubleProperty rate = new SimpleDoubleProperty(0.97);
		// Total in EUR
		
		// Variante 1 - High level
		// NumberBinding total = rate.multiply(a1.balanceProperty().add(
		// a2.balanceProperty()));

		// Varainte 2 - Binding classe
		// NumberBinding total =
		// Bindings.multiply(rate,
		// Bindings.add(a1.balanceProperty(), a2.balanceProperty()));
		//

		// Variante 3 - Low level
		DoubleBinding total = new DoubleBinding() {
			{
				super.bind(a1.balanceProperty(), a2.balanceProperty(), rate);
			}

			@Override
			protected double computeValue() {
				return (rate.get() * (a1.getBalance() + a2.getBalance()));
			}
		};

		// Because of lazy binding, total is not recomputed until explicitly
		// requested
		System.out.println(total); // prints ”DoubleBinding [invalid]”
		System.out.println(total.getValue()); // prints ”1455.0”

		a1.setBalance(1500);
		rate.set(0.96);
		System.out.println(total.getValue()); // prints ”2400.0”
	}
}
