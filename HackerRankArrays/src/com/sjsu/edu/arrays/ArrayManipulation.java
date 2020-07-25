/*
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros n = 10. Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
    
Add the values of k between the indices a and b inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
	
The largest value is 10 after all operations are performed.

Function Description:

Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.

arrayManipulation has the following parameters:

1. n - the number of elements in your array
2. queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.

Input Format:

The first line contains two space-separated integers n and m, the size of the array and the number of operations.
Each of the next m lines contains three space-separated integers a, b and k, the left index, right index and summand.

Constraints:

1. 3 <= n <= 10^7
2. 1 <= m <= 2*10^5
3. 1 <= a <= b <= n
4. 0 <= k <= 10^9

Output Format:

Return the integer maximum value in the finished array.

Sample Input:

5 3
1 2 100
2 5 100
3 4 100

Sample Output:

200

Explanation:

After the first update list will be 100 100 0 0 0.
After the second update list will be 100 200 100 100 100.
After the third update list will be 100 200 200 200 100.

The required answer will be 200.

Approach:

1. Create an array with size (n+1) since the array is 1-indexed (Default index is 0)
	- Creating array of size (n+1) avoids ArrayOutOfBoundsException
2. All elements of initial array should be 0, by default all array elements are filled with 0, so no need to manually fill the array just create array
3. Initialize the "max" and "sum" variables to 0
4. for loop to traverse through the rows of 2D array "queries" and get the space separated integers (a, b, and k) for each row in an int array "query"
5. Retrieve the values of a, b, and k for each row from "query" array (mentioned above) and store those values in int variables 
6. Instead of adding the value of 'k' to all the elements from indices a to b, we will add the value of 'k' to [a-1]th index of array and subtract the value of 'k' from [b]th index of array to reduce the execution time for large inputs
7. Find the max element from final array
	- Iterate through the array from 0th index to nth index using for loop
	- Add each array element to the previous sum and compute cumulative sum
	- For each iteration, compare the "max" value and "sum" value
	- Assign the maximum value to "max" variable
	- Repeat the steps 2, 3, 4 until we reach end of array
8. Exit the for loop, and return the maximum value from final array

Refer the below links for explanation:

1. https://codereview.stackexchange.com/questions/230633/add-a-value-to-each-of-the-array-element-between-two-given-indices-successively
2. https://www.hackerrank.com/challenges/crush/forum

 * 
 */

package com.sjsu.edu.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ArrayManipulation {
	
	// Complete the arrayManipulation function below.
	
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n+1]; // Create an array of size (n+1)
        //Arrays.fill(array, 0);  // By default all array elements are filled with 0, no need of this statement

        long max =0; // Initialize "max" variable to 0
        long sum =0; // Initialize "sum" variable to 0
        
        /*
         * Iterating over the rows of 2D array "queries" can also be done with enhanced for loop below
         * instead of:
         * 	- int noOfRows = queries.length; // number of operations (rows)
         * 	- and, for(int i = 0; i < noOfRows; i++)
         * 		   {
         * 				int a = queries[i][0]
         * 				int b = queries[i][1]
         * 				int k = queries[i][2]
         * 		   }
         * Traverse the rows of "queries" and take the values for each row in an array "query"
         */
        for(int[] query : queries){ 
        	
        	// Retrieve the values of a, b, and k from array "query" for each row of 2D array "queries"
            int a = query[0];
            int b = query[1];
            int k = query[2];

            
           /*
            * Instead of following the commented approach i.e, adding the value of 'k' to all elements from indices a to b
            * 	- Above approach will 
            * Add value of 'k' to [a-1]th index element and subtract value of 'k' from [b]th index element of array
            */
            
          //for(int j = a; j <= b; j++){
            //array[j] += k;
            //}
            
           array[a-1] += k; 
           array[b] -= k;

        }

        /*
         *  for loop to find the maximum element in a final or resulting array
         *  Refer to the explanation above (Approach section in problem description)
         */
        for(int t = 0; t < n+1; t++){
            sum += array[t];
            max = Math.max(max, sum);
        }

        return max; // Return the maximum element from final array
    }

    // Create Scanner class object
    private static final Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // String array to store n and m integers
        String[] nm = scanner.nextLine().split(" ");

        // Convert the elements from string array to integers and store in 'n' and 'm' variables
        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        // Create a 2D array with 'm' number of rows and 3 columns
        int[][] queries = new int[m][3];

        // for loop to traverse through rows of 2D array
        for (int i = 0; i < m; i++) {
        	
        	// Read the values of a, b, and k in a String array as space separated integers
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            // For each row, traverse through the columns
            for (int j = 0; j < 3; j++) {
            	// Convert the values of a, b, k in String array to integers
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem; // Assign the integer to 2D array at specified indexes 'i' and 'j'
            }
        }

        long result = arrayManipulation(n, queries); // Calling the function with size of array and 2D array as arguments

        bufferedWriter.write(String.valueOf(result)); // Prints the value of maximum element
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); // Close the Scanner class object
        
    } // End of main method
    
} // End of class
