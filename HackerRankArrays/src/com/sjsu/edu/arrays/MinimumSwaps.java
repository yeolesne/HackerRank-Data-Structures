/*
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array arr = [7,1,3,2,4,5,6] we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]

It took 5 swaps to sort the array.

Function Description:

Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps to sort the array.

minimumSwaps has the following parameter(s):

-> arr: an unordered array of integers

Input Format:

The first line contains an integer, n, the size of arr.
The second line contains n space-separated integers arr[i].

Constraints:

1. 1 <= n <= 10^5
2. 1 <= arr[i] <= n

Output Format:

Return the minimum number of swaps to sort the given array.

Sample Input 0:

4
4 3 1 2

Sample Output 0:

3

Explanation 0:

Given array arr: [4,3,1,2]
After swapping (0,2) we get arr: [1,3,4,2] 
After swapping (1,2) we get arr: [1,4,3,2] 
After swapping (1,3) we get arr: [1,2,3,4] 
So, we need a minimum of 3 swaps to sort the array in ascending order.

Sample Input 1:

5
2 3 4 1 5

Sample Output 1:

3

Explanation 1:

Given array arr: [2,3,4,1,5]
After swapping (2,3) we get arr: [2,3,1,4,5] 
After swapping (0,1) we get arr: [3,2,1,4,5]
After swapping (0,2) we get arr: [1,2,3,4,5] 
So, we need a minimum of 3 swaps to sort the array in ascending order.

Sample Input 2:

7
1 3 5 2 4 6 7

Sample Output 2:

3

Explanation 2:

Given array arr: [1,3,5,2,4,6,7]
After swapping (1,3) we get arr: [1,2,5,3,4,6,7] 
After swapping (2,3) we get arr: [1,2,3,5,4,6,7] 
After swapping (3,4) we get arr: [1,2,3,4,5,6,7] 
So, we need a minimum of 3 swaps to sort the array in ascending order.
 */

package com.sjsu.edu.arrays;

import java.io.*;
import java.util.*;

public class MinimumSwaps {
	
	// Complete the minimumSwaps function below.
   
    static int minimumSwaps(int[] arr) {
    /*   Solution not passing all the test cases, due to 2nd for loop, getting timed out error
     *  
        int swapCount = 0;
        for(int i = 0; i <= n-2; i++){
            int minIndex = i;
            for(int j = i+1; j <= n-1; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swapCount = swapCount + 1;
            }      
        }        
        return swapCount; */   
    	
    	int n = arr.length; // length of given array
    	int swap=0; // Initialize swap count to 0
    	
    	// for loop to traverse through the given array elements
        for(int i = 0; i < n; i++){
        	/*
        	 * Since, the sorted array will have consecutive integers, we are checking if a consecutive number (starting from 1,2...,n) is present at ith index 
        	 */
            if(i+1 != arr[i]){ // If desired consecutive number is not present at ith index
                int t=i; // Assign index value of 'i' to variable 't' because we will need 'i'th index value later for swapping
                while(arr[t] != i+1){ // While the desired consecutive number is not found,  
                    t++;  // Increment the variable 't' (index)
                }
                /*
                 * Once the desired consecutive number is found at 't'th index,
                 * swap that number with the number at 'i'th index
                 */
                
                int temp=arr[t];
                arr[t]=arr[i];
                arr[i]=temp;
                swap++; // Increment the swap count
            } // End of IF
            
        } // End of for loop
        
        return swap; // After traversing whole array, return the swap count
    }

    // Create Scanner class object
    private static final Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read the size of array from user
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // Create an int array of size 'n'
        int[] arr = new int[n];

        // Read the space separated array elements in a String array
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // Convert each item in a String array to integer and store it in Integer array 'arr'
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        // Call the function that returns min swap count
        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res)); // Print the minimum Swap count 
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); // Close the Scanner class object
    }

}
