package io.exercises.fileAnalyzer.rey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class FileAnalyzer{
    private int characterCount = 0;
    private int wordCount = 0;
    private int lineCount = 0;

    FileAnalyzer(String filePath) throws FileNotFoundException {
        this.analyzeFile(filePath);
    }

    private void analyzeFile(String filePath) throws FileNotFoundException {
        try{
            FileReader fileReader = new FileReader(filePath);
            Scanner fileScanner = new Scanner(fileReader);
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                lineCount++;
                wordCount += this.countWords(line);
                characterCount += countCharacters(line);
            }

            fileScanner.close();

        } catch(FileNotFoundException e){
            throw e;
        }
    }

    private int countWords(String line){
        String[] words = line.split(" ");
        return words.length;
    }

    private int countCharacters(String line){
        line = line.replace(" ", "");
        line = line.replace(".", "");
        line = line.replace(",", "");
        line = line.replace(";", "");
        line = line.replace(":", "");
        return line.length() + 1;
    }

    int getCharacterCount(){
        return this.characterCount;
    }

    int getWordCount(){
        return this.wordCount;
    }

    int getLineCount(){
        return this.lineCount;
    }
}
