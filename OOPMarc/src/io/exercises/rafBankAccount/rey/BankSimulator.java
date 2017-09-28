

import java.io.IOException;
import java.util.Scanner;

/**
 * This program demonstrates random access. You can access existing accounts and
 * deposit money, or create new accounts. The accounts are saved in a random
 * access file.
 */
public class BankSimulator {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		//BankDataInterface data = new BankData();
		BankDataInterface data = new NIOBankData();
		try {
			data.open("bank4.dat");

			boolean done = false;
			while (!done) {

				System.out.print("Account number: ");
				int accountNumber = in.nextInt();
				System.out.print("Amount to deposit: ");
				double amount = in.nextDouble();
				
				int position = data.find(accountNumber);
				BankAccount account;
				if (position >= 0) {
					account = data.read(position);
					System.out.println("Old balance: " + account.getBalance());
					account.deposit(amount);
					System.out.println("New balance: " + account.getBalance());
				} else {
					// Add account
					System.out.print("Interest rate: ");
					float interestRate = in.nextFloat();
					account = new BankAccount(accountNumber, amount, interestRate);
					position = data.size();
					System.out.println("Adding new account.");
				}
				data.write(position, account);

				System.out.print("Done? (Y/N) ");
				String input = in.next();
				if (input.equalsIgnoreCase("Y"))
					done = true;
			}
		} finally {
			data.close();
			in.close();
		}
	}
}
