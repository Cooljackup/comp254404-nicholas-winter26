// COMP254-404 - Lab 3 - Nicholas Bonneville
// Lab 3 - Exercise 2

package exercise2;

// Import necessary packages.
import java.util.Scanner;

public class RecursivePalindromeDriver {
    public static void main(String[] args) {

        // Instance variables.
        String input;
        Scanner scanner = new Scanner(System.in);
        boolean palindromeCheck;

        // Prompts the user to enter a word, then stores it into the scanner.
        System.out.print("Please enter a word: ");
        input = scanner.nextLine();

        // Calls the recursive method to check to see if it's a palindrome, then prints the result.
        palindromeCheck = RecursivePalindrome.checkPalindrome(input);
        if (palindromeCheck) {
            System.out.println("\nThe word '" + input + "' is a palindrome.");
        } else {
            System.out.println("\nThe word '" + input + "' is not a palindrome.");
        }
    }
}