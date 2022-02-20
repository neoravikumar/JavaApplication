package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Find a peak element
Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
 */
public class FindAPeakElement {

	private int findPeakElement(ArrayList<Integer> A, int start, int end, int n) {

		if (start > end) {
			return 1;
		}

		int mid = (start + end) / 2;

		if ((mid == 0 || (A.get(mid - 1) < A.get(mid))) && ((mid == n - 1) || (A.get(mid + 1) < A.get(mid)))) {
			return mid;
		} else if (mid > 0 && (A.get(mid - 1) > A.get(mid))) {
			return findPeakElement(A, start, mid - 1, n);
		} else {
			return findPeakElement(A, mid + 1, end, n);
		}

	}

	public int solve(ArrayList<Integer> A) {
		int N = A.size();
		int index = findPeakElement(A, 0, N - 1, N);
		System.out.println(index);
		return A.get(index);

	}

	public static void main(String[] args) {
		FindAPeakElement findAPeakElement = new FindAPeakElement();
		int result = findAPeakElement.solve(new ArrayList<Integer>(Arrays.asList( 1, 1000000000, 1000000000)));
		System.out.println(result);
	}

}
