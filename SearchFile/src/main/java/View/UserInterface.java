/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Search;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author conch
 */
public class UserInterface {
    private Search search;

    public UserInterface() {
        this.search = new Search();
    }
       public void displayMenu() {
        System.out.println("File Search Menu:");
        System.out.println("1. Count occurrences of a word in a file");
        System.out.println("2. Search for files containing a word");
        System.out.println("3. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Select an option (1/2/3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> search.countWordOccurrencesInFile(scanner);
                    case 2 -> search.searchFilesContainingWord(scanner);
                    case 3 -> {
                        System.out.println("Exiting the program.");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            // Consume the newline character
            scanner.nextLine();
        }
}
}
