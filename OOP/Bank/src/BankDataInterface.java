import java.io.IOException;

public interface BankDataInterface {
	
	public static final int INT_SIZE = Integer.BYTES;
	public static final int DOUBLE_SIZE = Double.BYTES;
	public static final int FLOAT_SIZE = Float.BYTES;
	public static final int CHAR_SIZE = Character.BYTES;
	public static final int STRING_LENGHT=255;
	public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE+FLOAT_SIZE+CHAR_SIZE*STRING_LENGHT;
	public static final String CHARSET="UTF-8";

	void open(String fileName) throws IOException;

	int find(int accountNumber) throws IOException;

	BankAccount read(int position) throws IOException;

	int size() throws IOException;

	void write(int position, BankAccount account) throws IOException;

	void close() throws IOException;

}
