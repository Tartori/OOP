package io.exercises.fileAnalyzer.rey;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args){

        FileAnalyzer fileAnalyzer;
        boolean success = false;
        do{
            String filePath = "src\\io\\exercises\\fileAnalyzer\\rey\\input1.txt";
            /*
            Scanner scanner = new Scanner(System.in);
            System.out.println("Filename or Path:");
            filePath = scanner.nextLine();
            scanner.close();
            */
            try{
                fileAnalyzer = new FileAnalyzer(filePath);
            } catch(FileNotFoundException e) {
                System.out.println("EXCEPTION: File not found! Try again.");
                continue;
            }
            printResults(fileAnalyzer);
            success = true;
        } while(!success);
    }

    private static String askUserForFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Filename or Path:");
        String filePath = scanner.nextLine();
        scanner.close();
        return filePath;
    }

    private static void printResults(FileAnalyzer fileAnalyzer){
        System.out.println("Character Count: " + fileAnalyzer.getCharacterCount());
        System.out.println("Word Count: " + fileAnalyzer.getWordCount());
        System.out.println("Line Count: " + fileAnalyzer.getLineCount());
    }
}

