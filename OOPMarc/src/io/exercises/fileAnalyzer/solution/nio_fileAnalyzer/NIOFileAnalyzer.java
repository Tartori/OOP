package io.exercises.fileAnalyzer.solution.nio_fileAnalyzer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class prints a report on the contents of a file.
 *  @author lua1
 */
public class NIOFileAnalyzer {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Filename: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		in.close();

		NIOFileCounter counter = new NIOFileCounter();
		counter.read(name);

		System.out.println("Characters: " + counter.getCharacterCount());
		System.out.println("Words: " + counter.getWordCount());
		System.out.println("Lines: " + counter.getLineCount());
	}
}
