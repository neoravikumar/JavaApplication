package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

import com.intermediate.twoPointers.AnotherCountRectangles;

/*
 Number of sextuplets
Problem Description
Given an array of integers A, find the number of sextuplets that satisfy the equation ( (a * b + c) / d ) - e = f.

Where a, b, c, d, e, f belong to the given array A.

NOTE: Since the answer can be very large, return the number of ways modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100

-106 <= A[i] <= 106

All elements of array A are distinct.



Input Format
The only argument given is the integer array A.



Output Format
Return the find the number of sextuplets that satisfy the equation.



Example Input
Input 1:

A = [1]
Input 2:

A = [1, -1]


Example Output
Output 1:

 1
Output 2:

 24


Example Explanation
Explanation 1:

a = b = c = d = e = f = 1 satisfy the equation.
Explanation 2:

Multiple instances satisfy the equation. Their count is 24.
 */
public class NumberOfSextuplets {
	
	
	public int solve(int[] A) {
		return findSextuplets(A, A.length);
    }
	
	static int upper_bound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int lower_bound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	static int findSextuplets(int[] arr, int n)
	{
		// Generating possible values of RHS of the equation
		int index = 0;
		int[] RHS = new int[n * n * n + 1];
		for (int i = 0; i < n; i++)
		{
		if (arr[i] != 0) // Checking d should be non-zero.
		{
			for (int j = 0; j < n; j++)
			{
			for (int k = 0; k < n; k++)
			{
				RHS[index++] = arr[i] * (arr[j] + arr[k]);
			}
			}
		}
		}

		// Sort RHS[] so that we can do binary search in it.
		Arrays.sort(RHS);

		// Generating all possible values of LHS of the equation
		// and finding the number of occurrences of the value in RHS.
		int result = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					int val = arr[i] * arr[j] + arr[k];
					result += (upper_bound(RHS, index, val)-lower_bound(RHS, index, val));
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		NumberOfSextuplets anotherCount = new NumberOfSextuplets();
		int[] arr = {13, -25, 9, -27, -5, -23, 19, 1, -21, 25, 15, -29, -3, 21, 3, 23, -15, -17, -1, 0, -19, -11, -9, -7, 5, 17, -13, 11, 27, 7 };
		int result = anotherCount.solve(arr);
		System.out.println(result);

	}

}
