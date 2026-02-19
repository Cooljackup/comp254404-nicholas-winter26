// COMP254-404 - Lab 3 - Nicholas Bonneville
// Lab 3 - Exercise 1

package exercise1;

public class RecursiveAdditionAndSubtraction {

    // Method to calculate the product of m and n, which are provided by the user.
    public static int calculation(int m, int n) {

        // Checks to make sure either integer is not 0, so it doesn't crash.
        if (m == 0 || n == 0) {
            return 0;
        }

        // Returns the product of m and n.
        return calculation(m - 1, n) + n;
    }
}