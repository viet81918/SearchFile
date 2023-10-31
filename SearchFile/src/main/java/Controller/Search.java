/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author conch
 */
public class Search {
    
public void countWordOccurrencesInFile(Scanner scanner) throws FileNotFoundException, IOException {
    System.out.print("Enter the path to the text file: ");
    String filePath = scanner.nextLine();

    System.out.print("Enter the word to count: ");
    String wordToCount = scanner.nextLine().toLowerCase(); // Convert input to lowercase

    int count = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            // Split the line into words and count occurrences
            String[] words = line.split("\\s");
            for (String word : words) {
                if (word.toLowerCase().equals(wordToCount)) { // Convert word to lowercase for comparison
                    count++;
                }
            }
        }
        System.out.println("Number of occurrences of '" + wordToCount + "': " + count);
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }
}
    public void searchFilesContainingWord(Scanner scanner) {
        System.out.print("Enter the folder path: ");
        String folderPath = scanner.nextLine();
        System.out.print("Enter the word to search: ");
        String wordToSearch = scanner.nextLine();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (containsWord(file, wordToSearch)) {
                        System.out.println("File found: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Folder does not exist or is empty.");
        }
    }
     public boolean containsWord(File file, String wordToSearch) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the line contains the word
                Pattern pattern = Pattern.compile("\\b" + Pattern.quote(wordToSearch) + "\\b", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    return true; // Word found in the line, return true
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return false; // Word not found in the file
    }
     
}
