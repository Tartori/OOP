
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOBankData implements BankDataInterface {

	private FileChannel file;
	private ByteBuffer buffer = ByteBuffer.allocate(RECORD_SIZE);
	
	@Override
	public void open(String fileName) throws IOException {
		if (file != null)
			file.close();
		file = FileChannel.open(Paths.get(fileName), 
				StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
	}

	@Override
	public int find(int accountNumber) throws IOException {
			for (int i = 0; i < size(); i++) {
				file.position(i * RECORD_SIZE);
				buffer.rewind();
				file.read(buffer);
				buffer.rewind();
				if (buffer.getInt() == accountNumber) // Found a match
					return i;
			}
		return -1; // No match in the entire file
	}

	@Override
	public BankAccount read(int position) throws IOException {
		file.position(position * RECORD_SIZE);
		
		buffer.rewind();
		file.read(buffer);
		buffer.rewind();

		return new BankAccount(buffer.getInt(), buffer.getDouble(), buffer.getFloat());
	}

	@Override
	public int size() throws IOException {
		return (int) (file.size() / RECORD_SIZE);
	}

	@Override
	public void write(int position, BankAccount account) throws IOException {

		file.position(position * RECORD_SIZE);

		buffer.rewind();
		buffer.putInt(account.getAccountNumber());
		buffer.putDouble(account.getBalance());
		buffer.putFloat(account.getInterestRate());
		buffer.rewind();
		
		file.write(buffer);
	}

	@Override
	public void close() throws IOException {
		if (file != null)
			file.close();
		file = null;
	}

}
