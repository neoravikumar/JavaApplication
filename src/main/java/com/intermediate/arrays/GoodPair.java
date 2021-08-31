package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Good Pair
Problem Description

Given an array A and a integer B. A pair(i,j) in the array is a good pair if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.



Problem Constraints
1 <= A.size() <= 104

1 <= A[i] <= 109

1 <= B <= 109



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return 1 if good pair exist otherwise return 0.



Example Input
Input 1:

A = [1,2,3,4]
B = 7
Input 2:

A = [1,2,4]
B = 4
Input 3:

A = [1,2,2]
B = 4


Example Output
Output 1:

1
Output 2:

0
Output 3:

1


Example Explanation
Explanation 1:

 (i,j) = (3,4)
Explanation 2:

No pair has sum equal to 4.
Explanation 3:

 (i,j) = (2,3)*/
public class GoodPair {

	public int solve(ArrayList<Integer> A, int B) {
		int result = 0;
		if (A.size() >= 1 && A.size() <= Math.pow(10, 4)) {
			if (B >= 1 && B <= Math.pow(10, 9)) {
				/*
				 * for (int i = 0, j = 1; i < A.size() && j < A.size(); i++, j++) { int value =
				 * A.get(i); if (value >= 1 && value <= Math.pow(10, 9)) { result = pair(A, B,
				 * i, j); if (result == 1) { return result; } } }
				 */
				for (int i = 0; i<A.size();i++) {
					for(int j=0;j<A.size();j++) {
						result = pair(A, B, i, j);
						if (result == 1) { return result; }
					}
				}
			}
		}
		return result;
	}

	private int pair(ArrayList<Integer> A, int B, int i, int j) {
		int sum = A.get(i) + A.get(j);
		if (i != j && sum == B) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		List<Integer> lst = Arrays.asList(1,2,3,4);
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		GoodPair goodPair = new GoodPair();
		int result = goodPair.solve(abc, 7);
	}

}
