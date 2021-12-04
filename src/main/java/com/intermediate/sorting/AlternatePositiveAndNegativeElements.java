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
	
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int fElement = A.get(0);
		result.add(fElement);
		for(int k=1;k<A.size();k++) {
			if(result.get(k-1)<0 && A.get(k)>0) {
				result.add(k);
			}
			
			if(result.get(k-1)>0 && A.get(k)<0) {
				result.add(k);
			}
		}
		
		System.out.println(result);
		return A;
    }

	public static void main(String[] args) {
		AlternatePositiveAndNegativeElements apInt = new AlternatePositiveAndNegativeElements();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 4, -2, 5, -3));
		apInt.solve(A);

	}

}
