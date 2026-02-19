// COMP254-404 - Lab 3 - Nicholas Bonneville
// Lab 3 - Exercise 2

package exercise2;

public class RecursivePalindrome {

    // Method to check the word given by the user is a palindrome.
    public static boolean checkPalindrome(String input) {

        // Makes the word provided by the user all lowercase so if the user capitalizes any letter it won't fail the check.
        input = input.toLowerCase();

        // Checks to make sure if there is 1 or 0 letters left, it returns true. Used for odd number words. Also prevents errors for 1 or 0 characters.
        if (input.length() <= 1) {
            return true;
        }

        // Checks to see if the first and last letters match, if it doesn't, returns false.
        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        }

        // Removes the first and last letters and then repeats method to check the middle letters until there is no more letters.
        return checkPalindrome(input.substring(1, input.length() - 1));
    }
}