import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NIOListOfNumbers {

	private Vector<Integer> victor;
	private static final int SIZE = 10;

	public NIOListOfNumbers() {
		victor = new Vector<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			victor.addElement(new Integer(i));
	}

	public void writeList() {

		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < victor.size(); i++)
			lines.add("Value at: " + i + " = " + victor.elementAt(i));

		try {
			Files.write(Paths.get("OutFile.txt"), lines);
		} 	catch (InvalidPathException e) {
			System.err.println("Caught InvalidPathException: "
					+ e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: "
					+ e.getMessage());
		}
	
	}

	public void readList(String file){
		List<String> lines = new ArrayList<String>();
		try {
			lines = Files.readAllLines(Paths.get(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for(String line :lines){
			try{
				System.out.println("Adding Value" + line);
				victor.addElement(Integer.parseInt(line));
			}
			catch (NumberFormatException ex){
				System.err.println("File is wrong");
			}
		}

	}
}
