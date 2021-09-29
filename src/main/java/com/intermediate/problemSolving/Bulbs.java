package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
 Bulbs
Problem Description

N light bulbs are connected by a wire.

Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.



Problem Constraints
1 <= N <= 5*105
0 <= A[i] <= 1



Input Format
The first and the only argument contains an integer array A, of size N.



Output Format
Return an integer representing the minimum number of switches required.



Example Input
Input 1:

 A = [0, 1, 0, 1]
Input 2:

 A = [1, 1, 1, 1]


Example Output
Output 1:

 4
Output 2:

 0


Example Explanation
Explanation 1:

 press switch 0 : [1 0 1 0]
 press switch 1 : [1 1 0 1]
 press switch 2 : [1 1 1 0]
 press switch 3 : [1 1 1 1]
Explanation 2:

 There is no need to turn any switches as all the bulbs are already on.
 
 */
public class Bulbs {

	public int bulbs(ArrayList<Integer> A) {
		int totalSwithOn = 0;

		int N = A.size();
		if (N >= 1 && N <= 5 * Math.pow(10, 5))
			;

		for (int i = 0; i < N; i++) {
			
			/*// Brute force code
			 * if (A.get(i) == 0) {
			 *  totalSwithOn++; 
			 *  int value = A.get(i) == 1 ? 0 : 1;
			 *  A.set(i, value);
			 * 
			 * for (int k = i + 1; k < N; k++) { 
			 * int newValue = A.get(k) == 1 ? 0 : 1;
			 * A.set(k, newValue); 
			 * }
			 * }
			 */
			// optimized approach 
			if (totalSwithOn % 2 != 0) {
				int value = A.get(i) == 1 ? 0 : 1;
				A.set(i, value);
			}
			
			if(A.get(i)==0) {
				totalSwithOn++;
			}

		}

		return totalSwithOn;
	}

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 1, 1, 1);
		//List<Integer> integers = Arrays.asList(0, 1, 0, 1);

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		Bulbs eq = new Bulbs();
		int result = eq.bulbs(inputArray);
		System.out.println("Result:>>" + result);

	}

}
