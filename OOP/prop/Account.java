package prop;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account {
	private StringProperty owner = new SimpleStringProperty();
	private DoubleProperty balance = new SimpleDoubleProperty();

	public final String getOwner() {
		return this.owner.get();
	}

	public final void setOwner(String value) {
		this.owner.set(value);
	}

	public StringProperty ownerProperty() {
		return this.owner;
	}

	public final double getBalance() {
		return this.balance.get();
	}

	public final void setBalance(double value) {
		this.balance.set(value);
	}

	public DoubleProperty balanceProperty() {
		return this.balance;
	}
}