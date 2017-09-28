package io.exercises.rafBankAccount.blank;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class is a conduit to a random access file containing savings account
 * data.
 */
public class BankData implements BankDataInterface {
	private RandomAccessFile file;

	/**
	 * Constructs a BankData object that is not associated with a file.
	 */
	public BankData() {
		file = null;
	}

	/**
	 * Opens the data file. 
	 * @param filename
	 *            the name of the file containing savings account information
	 */
	@Override
	public void open(String filename) throws IOException {
		if (file != null)
			file.close();
		file = new RandomAccessFile(filename, "rw");
	}

	/**
	 * Gets the number of accounts in the file.
	 * @return the number of accounts
	 */
	@Override
	public int size() throws IOException {
		return (int) (file.length() / RECORD_SIZE);
	}

	/**
	 * Closes the data file.
	 */
	@Override
	public void close() throws IOException {
		if (file != null)
			file.close();
		file = null;
	}

	/**
	 * Reads a savings account record.
	 * @param n
	 *            the index of the account in the data file
	 * @return a savings account object initialized with the file data
	 */
	@Override
	public BankAccount read(int n) throws IOException {
		file.seek(n * RECORD_SIZE);
		int accountNumber = file.readInt();
		double balance = file.readDouble();
		return new BankAccount(accountNumber, balance);
	}

	/**
	 * Finds the position of a bank account with a given number
	 * @param accountNumber
	 *            the number to find
	 * @return the position of the account with the given number, or -1 if there
	 *         is no such account
	 */
	@Override
	public int find(int accountNumber) throws IOException {
		for (int i = 0; i < size(); i++) {
			file.seek(i * RECORD_SIZE);
			int a = file.readInt();
			if (a == accountNumber) // Found a match
				return i;
		}
		return -1; // No match in the entire file
	}

	/**
	 * Writes a savings account record to the data file
	 * @param n
	 *            the index of the account in the data file
	 * @param account
	 *            the account to write
	 */
	@Override
	public void write(int n, BankAccount account) throws IOException {
		file.seek(n * RECORD_SIZE);
		file.writeInt(account.getAccountNumber());
		file.writeDouble(account.getBalance());
	}
}
