// COMP254-404 - Lab 3 - Nicholas Bonneville
// Lab 3 - Exercise 3

package exercise3;

// Import necessary packages.
import java.util.Scanner;

public class RecursiveFinderDriver {
    public static void main(String[] args) {

        // Instance variables.
        String filePath;
        String fileName;
        Scanner scanner = new Scanner(System.in);
        int fileCount;

        // Prompts the user to enter the directory path they want to search, then prompts the user for the file name to search for it.
        System.out.print("Please enter the directory path you want to search in: ");
        filePath = scanner.nextLine();
        System.out.print("Please enter the name of the file you want to search for: ");
        fileName = scanner.nextLine();

        // Calls the recursive method and searches every file for what the user inputted, then prints the result.
        fileCount = RecursiveFinder.fileFinder(filePath, fileName);
        if (fileCount != 0) {
            System.out.println("\nThere was " + fileCount + " file(s) with the name '" + fileName + "' found.");
        } else {
            System.out.println("\nERROR. There was no files with the name '" + fileName + "' found.");
        }
    }
}