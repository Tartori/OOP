package io.exercises.fileAnalyzer.solution.fileAnalyzer;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class prints a report on the contents of a file.
 *  @author lua1
 */
public class FileAnalyzer {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Filename: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		in.close();
		
		FileCounter counter = new FileCounter();
		counter.read(name);
		
		System.out.println("Characters: " + counter.getCharacterCount());
		System.out.println("Words: " + counter.getWordCount());
		System.out.println("Lines: " + counter.getLineCount());
	}
}
