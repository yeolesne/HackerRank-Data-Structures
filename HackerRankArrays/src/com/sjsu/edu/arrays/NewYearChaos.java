/*
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by 1 from 1 at the front of the line to n at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if n = 8 and Person 5 bribes Person 4, the queue will look like this: 1,2,3,5,4,6,7,8.

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

Function Description:

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.

minimumBribes has the following parameter(s):

q: an array of integers

Input Format:

The first line contains an integer t, the number of test cases.

Each of the next t pairs of lines are as follows:
- The first line contains an integer t, the number of people in the queue
- The second line has n space-separated integers describing the final state of the queue.

Constraints:

1. 1 <= t <= 10
2. 1 <= n <= 10^5 

Subtasks:

For 60% score 1 <= n <= 10^3 
For 100% score 1<= n <= 10^5 

Output Format:

Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than 2 people.

Sample Input:

2
5
2 1 5 3 4
5
2 5 1 3 4

Sample Output:

3
Too chaotic

Explanation:

Test Case 1:

The initial state:

1 -> 2 -> 3 -> 4 -> 5

After person 5 moves one position ahead by bribing person 4:

1 -> 2 -> 3 -> 5 -> 4

Now person 5 moves another position ahead by bribing person 3:

1 -> 2 -> 5 -> 3 -> 4

And person 2 moves one position ahead by bribing person 1:

2 -> 1 -> 5 -> 3 -> 4

So the final state is 2,1,5,3,4 after three bribing operations.

Test Case 2:

No person can bribe more than two people, so its not possible to achieve the input state.

Refer the video below for explanation:
https://www.youtube.com/watch?v=YWYF6bOhPW8


This will be only two cases:

a) Do not bribe, be at the ith position wherever you are
b) Bribe and move ahead
	1) Being at initial ith position, valid current position after bribe can be (i-1)th position
	2) Being at initial ith position, valid current position after bribes can be (i-2)th position
	3) Too chaotic (trying to bribe more than 2 people which is ahead of you) 

Special Note: Some test cases will fail for O(n^2) algorithm (eg. nested for loops)
 */

package com.sjsu.edu.arrays;

import java.util.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int minBribe = 0; // Initialize the bribe count
        for(int i = q.length-1; i >= 0; i--){ // for loop to traverse through the array in reverse order
            if(q[i] != i + 1){ // a) filter cases, when you do not bribe, be at the ith position wherever you are
                if(((i-1) >= 0) && q[i-1] == (i+1)){ // b) 1) Being at initial ith position, valid current 
                									// position after given bribe can be (i-1)th position
                    minBribe = minBribe + 1; // Increment the swap or bribe count by 1
                    swap(q, i, i-1); // Swap the elements to get initial position (sorted array)
                // b) 2) Being at initial ith position, valid current position after bribes can be (i-2)th position
                }else if(((i-2) >= 0) && q[i-2] == (i+1)){
                    minBribe = minBribe + 2; // Increment the bribe or swap count by 2
                    swap(q, i-2, i-1); // Swap the elements at i-2 and i-1 positions
                    swap(q, i-1, i); // Swap the elements at i-1 and ith positions
                }else{
                    System.out.println("Too chaotic"); // b) 3) Too chaotic (trying to bribe more than 2 people which is ahead of you) 
                    return; // return statement in java transfers the control to the calling method (main method) 
                }
            }
        }
        System.out.println(minBribe);     // Prints the minimum number of bribes      
} 
    
    // Swap fnction to swap the adjacent elements of array
    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    private static final Scanner scanner = new Scanner(System.in); // Creating Scanner class object

    //Main method
    public static void main(String[] args) {
        int t = scanner.nextInt(); // Reads the number of test cases from user
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) { // For each test case,
            int n = scanner.nextInt(); // Reads the number of elements
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n]; // Creating an array of length 'n'

            String[] qItems = scanner.nextLine().split(" "); // Creating a String array
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) { // for loop to traverse the String array "qItems"
                int qItem = Integer.parseInt(qItems[i]); // Convert the String value to Integer and store it in "qItem" variable
                q[i] = qItem; // Store the integers in an array 'q'
            }

            minimumBribes(q); // Calling the function "minimumBribes" with the current array 'q' passed as an argument
        }

        scanner.close(); // Close the Scanner class object
    }
}

