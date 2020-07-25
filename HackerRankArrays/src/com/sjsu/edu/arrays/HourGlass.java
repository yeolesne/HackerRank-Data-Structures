/*
 * Given a 6x6 2D Array, arr:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's graphical representation:

a b c
  d
e f g

There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
 
We calculate the following 16 hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18

Our highest hourglass value is 28 from the hourglass:

0 4 3
  1
8 6 6

Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Function Description:

Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.

hourglassSum has the following parameter(s):

arr: an array of integers

Input Format:

Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].

Constraints:

1. -9 <= arr[i][j] <= 9
2. 0 <= i, j <= 5

Output Format:

Print the largest (maximum) hourglass sum found in arr.

Sample Input:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output:

19

Explanation:

arr contains the following hourglasses:

1 1 1   1 1 0   1 0 0   0 0 0
  1       0       0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1       1       0       0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0       2       4       4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0       0       2       0
0 0 1   0 1 2   1 2 4   2 4 0

The hourglass with the maximum sum (19) is:

2 4 4
  2
1 2 4
 */

package com.sjsu.edu.arrays;

import java.io.*;
import java.util.*;

public class HourGlass {

    // Complete the hourglassSum function below.
    static void hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE; // Initialize the maximum sum value
        try (Scanner scanner = new Scanner(System.in);){ // Creating the Scanner class object
            for(int i = 0; i < 6; i++){ // for loop to traverse the rows of a matrix
                for(int j = 0; j < 6; j++){ // for loop to traverse the columns of a matrix
                    arr[i][j] = scanner.nextInt(); // Add the elements and fill the matrix
                    if(i > 1 && j > 1){ // First time condition is true, when one hourglass (two rows and first 3 elements of third row are filled)
                        int sum = arr[i][j] + // Calculate the sum of hourglass
                                  arr[i][j-1] +
                                  arr[i][j-2] +
                                  arr[i-1][j-1] +
                                  arr[i-2][j] +
                                  arr[i-2][j-1] +
                                  arr[i-2][j-2];

                        if(sum > maxSum){ //If the calculated sum is greater than initialized maxSum, then assign the value of sum to maxSum variable 
                            maxSum = sum;
                        }
                    }

                }
            }
        }
        System.out.println(maxSum); // Prints the maxiumum sum of hourglass on the console
}

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6]; // Create a 2D array with 6 rows and 6 columns
        HourGlass.hourglassSum(arr); // calling the "hourglassSum" method with newly created array passed as an argument
    }
}

