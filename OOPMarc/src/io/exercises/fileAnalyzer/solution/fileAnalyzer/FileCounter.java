package io.exercises.fileAnalyzer.solution.fileAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class to count the number characters, words, and lines in an input source.
 *  @author lua1
 */
public class FileCounter {
	private int chars;
	private int words;
	private int lines;

	/**
	 * Construct a FileCounter object.
	 */
	public FileCounter() {
		chars = 0;
		words = 0;
		lines = 0;
	}

	/**
	 * Processes an input source and adds its character, word, and line counts
	 * to this counter.
	 * 
	 * @param fileName
	 *            the name of the file to process
	 * @throws FileNotFoundException 
	 */
	public void read(String fileName) throws FileNotFoundException {
		File reader = new File(fileName);
	    Scanner fileIn = new Scanner(reader);
	  	while (fileIn.hasNextLine()) {
			String line = fileIn.nextLine();
			lines++;
			chars += line.length() + 1;
			Scanner lineIn = new Scanner(line);
			while (lineIn.hasNext()) {
				lineIn.next();
				words++;
			}
			lineIn.close();
		}
		fileIn.close();
	}

	/**
	 * Gets the number of words in this counter.
	 * 
	 * @return the number of words
	 */
	public int getWordCount() {
		return words;
	}

	/**
	 * Gets the number of lines in this counter.
	 * 
	 * @return the number of lines
	 */
	public int getLineCount() {
		return lines;
	}

	/**
	 * Gets the number of characters in this counter.
	 * 
	 * @return the number of characters
	 */
	public int getCharacterCount() {
		return chars;
	}
}
