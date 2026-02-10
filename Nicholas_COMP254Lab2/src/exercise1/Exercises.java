// COMP254-404 - Lab 2 - Nicholas Bonneville
// Lab 2 - Exercise 1

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package exercise1;

/**
 * Code for end-of-chapter exercises on asymptotics.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Exercises {

  /** Returns the sum of the integers in given array. */
  public static int example1(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      total += arr[j];
    return total;
  }

  /** Returns the sum of the integers with even index in given array. */
  public static int example2(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j += 2)    // note the increment of 2
      total += arr[j];
    return total;
  }

  /** Returns the sum of the prefix sums of given array. */
  public static int example3(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      for (int k=0; k <= j; k++)    // loop from 0 to j
        total += arr[j];
    return total;
  }

  /** Returns the sum of the prefix sums of given array. */
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0;
    for (int j=0; j < n; j++) {     // loop from 0 to n-1
      prefix += arr[j];
      total += prefix;
    }
    return total;
  }

  /** Returns the number of times second array stores sum of prefix sums from first. */
  public static int example5(int[] first, int[] second) { // assume equal-length arrays
    int n = first.length, count = 0;
    for (int i=0; i < n; i++) {     // loop from 0 to n-1
      int total = 0;
      for (int j=0; j < n; j++)     // loop from 0 to n-1
        for (int k=0; k <= j; k++)  // loop from 0 to j
          total += first[k];
      if (second[i] == total) count++;
    }
    return count;
  }

  // Main method created for testing purposes.
  public static void main(String[] args) {

    //Instance variables.
    int[] array = { 1, 2, 3, 4 };
    int[] arrayCheck = { 10, 20, 30, 40 };

    // a. - example1.
    // O(n). - Method contains a loop that iterates through the entire array.
    // Output will be 10 ( 1 + 2 + 3 + 4).
    System.out.println("example1 output: " + example1(array));

    // b. - example2.
    // O(n). - Method contains a loop that iterates every other element in the array.
    // Output will be 4 (1 + 3).
    System.out.println("example2 output: " + example2(array));

    // c. - example3.
    // O(n^2). - Method contains a loop that is nested where the loop will run with j+1 for each j.
    // Output will be 30 (1*1 + 2*2 + 3*3 + 4*4 = 30).
    System.out.println("example3 output: " + example3(array));

    // d. - example4.
    // O(n). - Method contains a single loop and calculates a sum that doesn't require running it again unlike example 3.
    // Output will be 20 (0 + 1 = *1, 1 + 2 = *3, 3 + 3 = *6, 6 + 4 = *10, THEN 0 + *1 = 1, 1 + *3 = 4, 4 + *6 = 10, 10 + *10 = 20).
    System.out.println("example4 output: " + example4(array));

    // e. - example5.
    // O(n^3) - Similar to example3, but repeats the sum calculation for each value in arrayCheck and checks how many values match.
    // Output will be 1 (1 + 3 + 6 + 10 = 20, THEN 20 != 10, 20 = 20, 20 != 30, 20 != 40, = 1 match).
    System.out.println("example5 output: " + example5(array, arrayCheck));
  }

}
