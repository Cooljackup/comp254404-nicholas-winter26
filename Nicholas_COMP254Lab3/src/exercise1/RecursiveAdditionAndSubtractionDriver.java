// COMP254-404 - Lab 3 - Nicholas Bonneville
// Lab 3 - Exercise 1

package exercise1;

// Import necessary packages.
import java.util.Scanner;

public class RecursiveAdditionAndSubtractionDriver {
    public static void main(String[] args) {

        // Instance variables.
        int m;
        int n;
        Scanner scanner =  new Scanner(System.in);
        int calculationResult;

        // Prompts the user to input an integer for both m and n, then stores into the scanner.
        System.out.print("Please enter an integer: ");
        m = scanner.nextInt();
        System.out.print("Please enter a second integer: ");
        n = scanner.nextInt();

        // Once both integers have been given, calculates the product of m and n, then prints it.
        calculationResult = RecursiveAdditionAndSubtraction.calculation(m, n);
        System.out.println("\nThe product of " + m + " and " + n + " is " + calculationResult + ".");
    }
}