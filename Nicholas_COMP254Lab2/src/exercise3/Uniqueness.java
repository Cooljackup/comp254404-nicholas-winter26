// COMP254-404 - Lab 2 - Nicholas Bonneville
// Lab 2 - Exercise 3

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
package exercise3;

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  // Main method created for testing purposes.
  public static void main(String[] args) {

    // Instance variables.
    final long oneMinute = 60000;
    int minimumSize;
    int maximumSize;
    int validMaximumSize = 0;
    int median;
    int[] arrayData;
    long startTime;
    long elapsedTime;

    // unique1.
    // Sets the lower and upper bounds, then does a binary search to determine what the largest valid input size is within 1 minute.
    minimumSize = 1000;
    maximumSize = 50000;
    while (minimumSize <= maximumSize) {
      median = (minimumSize + maximumSize) / 2;

      // Creates an array of unique values.
      arrayData = new int[median];
      for (int i = 0; i < median; i++) {
        arrayData[i] = i;
      }

      // Then measures the execution time of unique1 method.
      startTime = System.currentTimeMillis();
      unique1(arrayData);
      elapsedTime = System.currentTimeMillis() - startTime;

      // Checks elapsed time, and adjusts the search range based on the execution time. If valid, it tries a bigger value, otherwise it tries a smaller value.
      if (elapsedTime <= oneMinute) {
        validMaximumSize = median;
        minimumSize = median + 1;
      } else {
        maximumSize = median - 1;
      }
    }
    System.out.println("unique1 maximum output: " + validMaximumSize);

    // unique2.
    // Sets the lower and upper bounds to a different value, then does a binary search again to determine what the largest valid input size is within 1 minute.
    minimumSize = 10000;
    maximumSize = 2500000;
    while (minimumSize <= maximumSize) {
      median = (minimumSize + maximumSize) / 2;

      // Creates an array of unique values.
      arrayData = new int[median];
      for (int i = 0; i < median; i++) {
        arrayData[i] = i;
      }

      // Again measures the execution time of unique2 method.
      startTime = System.currentTimeMillis();
      unique2(arrayData);
      elapsedTime = System.currentTimeMillis() - startTime;

      // Checks elapsed time again. Adjusts the search range based on execution time. If valid, it tries a bigger value, otherwise it tries a smaller value.
      if (elapsedTime <= oneMinute) {
        validMaximumSize = median;
        minimumSize = median + 1;
      } else {
        maximumSize = median - 1;
      }
    }
    System.out.println("unique2 maximum output: " + validMaximumSize);
  }

}
