package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Closest pair from sorted arrays
Problem Description

Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.



Problem Constraints
1 <= length of both the arrays <= 100000

1 <= A[i], B[i] <= 109

1 <= C <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
The third argument given is integer C.



Output Format
Return an array of size 2 denoting the pair which has sum closest to C.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9
Input 2:

 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13


Example Output
Output 1:

 [1, 8]
Output 2:

 [10, 2]


Example Explanation
Explanation 1:

 There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
Explanation 2:

 [10, 2] is the only pair such abs(10+2-13) is minimum.
 */
public class ClosestPairFromSortedArrays {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {

		if (A.size() == 0 || B.size() == 0) {
			return null;
		}

		int x = 0;
		int y = B.size() - 1;

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0, j = B.size() - 1; i < A.size() && j >= 0;) {
			if (Math.abs(A.get(i) + B.get(j) - C) < Math.abs(A.get(x) + B.get(y) - C)) {
				x = i;
				y = j;
			}

			if (A.get(i) + B.get(j) < C) {
				i++;
			} else if (A.get(i) + B.get(j) > C) {
				j--;
			} else {
				i++;
				j--;
			}
		}

		result.add(A.get(x));
		result.add(B.get(y));
		return result;
	}

	public static void main(String[] args) {
		ClosestPairFromSortedArrays closestPairFromSortedArrays = new ClosestPairFromSortedArrays();
		ArrayList<Integer> result = closestPairFromSortedArrays.solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8)), 9);
		System.out.println(result);
		

	}

}
