package displayHex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Displays the content of a binary file (e.g. *.class) in hexadecimal.
 * Uses the NIO API available since Java 7
 * @author lua1
 *
 */

public class NIODisplayHex {
	
	/**
	 * @param arg[0] file name 
	 */
	public static void main(String[] args) throws IOException {

		String inputFileName = new String();

		if (args.length >= 1) {
			inputFileName = args[0];

			System.out.println("File: " + inputFileName);
			Path file = Paths.get(inputFileName);

			byte[] bytes = Files.readAllBytes(file);

			int count = 0;
			for (byte theByte : bytes) {
				System.out.printf("%02X ", theByte);
				count ++;
				
				if (count == 16) {
					System.out.println("");
					count = 0;
				}
			}

		} else {
			System.out.println("usage: java " + NIODisplayHex.class.getName()
					+ " filename");
		}

	}

}
