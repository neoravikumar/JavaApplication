package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Max Distance
Problem Description

Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum value of j - i.



Example Input
Input 1:

A = [3, 5, 4, 2]


Example Output
Output 1:

2


Example Explanation
Explanation 1:

For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2.
 */
public class MaxDistance {// DO NOT MODIFY THE LIST. IT IS READ ONLY

	public int maximumGap(final List<Integer> A) {

		int[] maxFromEnd = new int[A.size() + 1];
		Arrays.fill(maxFromEnd, Integer.MIN_VALUE);

		// Create an array maxfromEnd
		for (int i = A.size() - 1; i >= 0; i--) {
			maxFromEnd[i] = Math.max(maxFromEnd[i + 1], A.get(i));
		}

		int result = 0;

		for (int i = 0; i < A.size(); i++) {
			int low = i + 1, high = A.size() - 1, ans = i;

			while (low <= high) {
				int mid = (low + high) / 2;

				if (A.get(i) <= maxFromEnd[mid]) {
					// We store this as current answer and look for further larger number to the right side
					ans = Math.max(ans, mid);
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

			// Keeping a track of the maximum difference in indices
			result = Math.max(result, ans - i);

		}
		return result;
	}
	
	public static void main(String[] args) {
		MaxDistance maxDistance = new MaxDistance();
		int result = maxDistance.maximumGap(new ArrayList<Integer>(Arrays.asList(3, 5, 4, 2)));
		System.out.println("Result is :>>"+result);
	}
}
