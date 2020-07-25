/*
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].

Given an array a of n integers and a number, d, perform d left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

Function Description:

Complete the function rotLeft in the editor below. It should return the resulting array of integers.

rotLeft has the following parameter(s):

1. An array of integers a.
2. An integer d, the number of rotations.

Input Format:

The first line contains two space-separated integers n and d, the size of a and the number of left rotations you must perform.
The second line contains n space-separated integers a[i].

Constraints:

1. 1 <= n <= 10^5
2. 1 <= d <= n
3. 1 <= a[i] <= 10^6

Output Format:

Print a single line of n space-separated integers denoting the final state of the array after performing d left rotations.

Sample Input:

5 4
1 2 3 4 5

Sample Output:

5 1 2 3 4

Explanation:

When we perform d = 4 left rotations, the array undergoes the following sequence of changes:

[1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]


 */

package com.sjsu.edu.arrays;

import java.io.*;
import java.util.*;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        for(int i = 0; i < d; i++){ // for loop to keep track of number of rotations
            int tmp = a[0]; // Store the first element of array in temporary variable
            for(int j = 1; j < a.length; j++){ // for loop to traverse through the elements of array from 1st index (for each rotation)
                a[j-1] = a[j]; // Shifts the  array elements one unit to the left
            }
            a[a.length-1] = tmp; // Fill the last index of array with element stored in "tmp" variable
        }
        return a; // Return the updated array after performing 'd' rotations on it
    }

    private static final Scanner scanner = new Scanner(System.in); // Creating the Scanner class object

    //Main method
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" "); // Creating a String array to read space separated inputs on single line from user

        int n = Integer.parseInt(nd[0]); // Reads the number of integers at 0th index from user

        int d = Integer.parseInt(nd[1]); // Reads the number of rotations to be performed from user

        int[] a = new int[n]; // Creating an Integer array of length 'n'

        String[] aItems = scanner.nextLine().split(" "); // Creating a String array to read space separated integers from user
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) { // for loop to traverse the array
            int aItem = Integer.parseInt(aItems[i]); // Convert the String to Integer values and store in "aItem" variable
            a[i] = aItem; // Store the integer "aItem" in an array a[i]
        }

        int[] result = rotLeft(a, d); // Calling the rotLeft method with an array 'a' and number of rotations 'd' passed as an argument 

        for (int i = 0; i < result.length; i++) { // for loop to traverse the "result" array
            bufferedWriter.write(String.valueOf(result[i])); // Prints the value of each element in array on the console

            if (i != result.length - 1) { // If the result" array is not yet completely traversed 
                bufferedWriter.write(" "); // then, insert a space in between the elements
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close(); // Close the bufferedWriter class object 

        scanner.close(); // Close the Scanner class object
    }
}
