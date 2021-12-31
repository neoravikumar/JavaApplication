package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Alternate positive and negative elements
Problem Description

Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.

If there are more non-negative numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.

Note: Try solving with O(1) extra space.



Problem Constraints
1 <= length of the array <= 7000
-109 <= A[i] <= 109



Input Format
The first argument given is the integer array A.



Output Format
Return the modified array.



Example Input
Input 1:

 A = [-1, -2, -3, 4, 5]
Input 2:

 A = [5, -17, -100, -11]


Example Output
Output 1:

 [-1, 4, -2, 5, -3]
Output 2:

 [-17, 5, -100, -11]


Example Explanation
Explanation 1:

A = [-1, -2, -3, 4, 5]
Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]
 */
public class AlternatePositiveAndNegativeElements {

	public void insert(ArrayList<Integer> A, int position, int foundIndex) {

	}

	public ArrayList<Integer> solve(ArrayList<Integer> A) {

		// Approach Using SC ( N )
		
		ArrayList<Integer> positiveArray = new ArrayList<Integer>();
		ArrayList<Integer> negativeArray = new ArrayList<Integer>();

		for (int k = 0; k < A.size(); k++) {
			int value = A.get(k);
			if (value < 0) {
				negativeArray.add(value);
			} else {
				positiveArray.add(value);
			}
		}

		A.clear();

		int positiveIndex = 0;
		for (int k = 0; k < negativeArray.size(); k++) {
			A.add(negativeArray.get(k));
			if (positiveArray.size() > k) {
				A.add(positiveArray.get(k));
				positiveIndex++;
			}
		}

		if (positiveIndex < positiveArray.size()) {
			for (; positiveIndex < positiveArray.size(); positiveIndex++) {
				A.add(positiveArray.get(positiveIndex));
			}
		}
		return A;
		 

		// Approach for O(1)
		/*
		 * int N = A.size(); for (int i = 0; i < N; i++) { if(A.get(i)<0) {
		 * 
		 * } } return A;
		 */

		

	}

	public static void main(String[] args) {
		AlternatePositiveAndNegativeElements apInt = new AlternatePositiveAndNegativeElements();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, -17, 15, 67));
		apInt.solve(A);

	}

}
