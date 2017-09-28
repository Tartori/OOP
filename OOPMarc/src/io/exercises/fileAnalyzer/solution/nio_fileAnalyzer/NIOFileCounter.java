package io.exercises.fileAnalyzer.solution.nio_fileAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * A class to count the number characters, words, and lines in an input source.
 *  @author lua1
 */
public class NIOFileCounter {
	private int chars;
	private int words;
	private int lines;

	/**
	 * Construct a FileCounter object.
	 */
	public NIOFileCounter() {
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
	 * @throws IOException 

	 */
	public void read(String fileName) throws IOException  {
			
		List<String> lineList = Files.readAllLines(Paths.get(fileName));

		lines = lineList.size();

		for (String line : lineList) {
			chars += line.length() + 1;
			Scanner lineIn = new Scanner(line);
			while (lineIn.hasNext()) {
				lineIn.next();
				words++;
			}
			lineIn.close();
		}
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
