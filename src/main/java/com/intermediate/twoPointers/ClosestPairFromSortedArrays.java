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
		int diff = Integer.MAX_VALUE;
		int resl = 0, resr = 0;
		int l = 0, r = B.size() - 1;
		while (l < A.size() && r >= 0) {
			int temp = A.get(l) + B.get(r) - C;
			if (temp < 0)
				temp = temp * -1;
			if (temp < diff) {
				resl = l;
				resr = r;
				diff = temp;
			} else if (diff == temp && resl == l) {
				resr = r;
			}
			if (A.get(l) + B.get(r) >= C)
				r--;
			else
				l++;
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(A.get(resl));
		ans.add(B.get(resr));
		return ans;
	}

	ArrayList<Integer> printClosest(ArrayList<Integer> ar1, ArrayList<Integer> ar2, int m, int n, int x) {
		// Initialize the diff between pair sum and x.
		int diff = Integer.MAX_VALUE;

		// res_l and res_r are result indexes from ar1[] and ar2[]
		// respectively
		int res_l = 0, res_r = 0;

		// Start from left side of ar1[] and right side of ar2[]
		int l = 0, r = n - 1;
		while (l < m && r >= 0) {
			// If this pair is closer to x than the previously
			// found closest, then update res_l, res_r and diff
			if (Math.abs(ar1.get(l) + ar2.get(r) - x) < diff) {
				res_l = l;
				res_r = r;
				diff = Math.abs(ar1.get(l) + ar2.get(r) - x);
			}

			// If sum of this pair is more than x, move to smaller
			// side
			if (ar1.get(l) + ar2.get(r) > x)
				r--;
			else // move to the greater side
				l++;
		}

		// Print the result
		System.out.print("The closest pair is [" + ar1.get(res_l) + ", " + ar2.get(res_r) + "]");
		return null;
	}

	public static void main(String[] args) {
		ClosestPairFromSortedArrays closestPairFromSortedArrays = new ClosestPairFromSortedArrays();
		// ArrayList<Integer> result = closestPairFromSortedArrays.solve(new
		// ArrayList<Integer>(Arrays.asList(1)), new ArrayList<Integer>(Arrays.asList(2,
		// 4)), 4);
		ArrayList<Integer> result = closestPairFromSortedArrays.solve(new ArrayList<Integer>(Arrays.asList(1)),
				new ArrayList<Integer>(Arrays.asList(2, 4)), 4);

		/*
		 * int ar1[] = {1, 4, 5, 7}; int ar2[] = {10, 20, 30, 40}; int m = ar1.length;
		 * int n = ar2.length; int x = 38;
		 */
		ArrayList<Integer> ar1 = new ArrayList<Integer>(Arrays.asList(1));
		ArrayList<Integer> ar2 = new ArrayList<Integer>(Arrays.asList(2, 4));
		closestPairFromSortedArrays.printClosest(ar1, ar2, ar1.size(), ar2.size(), 4);

		System.out.println(result);

	}

}
