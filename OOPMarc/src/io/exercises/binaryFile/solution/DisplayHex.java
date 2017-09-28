package displayHex;

import java.io.FileInputStream;

/**
 * Displays the content of a binary file (e.g. *.class) in hexadecimal.
 * @author lua1
 *
 */
public class DisplayHex {

	/**
	 * @param arg[0] file name 
	 */
	public static void main(String[] args) throws Exception {

		String inputFileName = new String();

		if (args.length >= 1) {
			inputFileName = args[0];

		FileInputStream fis = new FileInputStream(inputFileName);
		System.out.println("File: " + inputFileName);

		int i = 0;
		int count = 0;

		while ((i = fis.read()) != -1) {
			if (i != -1) {
				System.out.printf("%02X ", i);
				count++;
			}

			if (count == 16) {
				System.out.println("");
				count = 0;
			}
		}
		fis.close();
		} else {
			System.out.println("usage: java "+ DisplayHex.class.getName() + " filename");
		}
		
	}
}
