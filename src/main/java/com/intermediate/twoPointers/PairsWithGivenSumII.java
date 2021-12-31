package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Pairs with given sum II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

 
A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.
 */
public class PairsWithGivenSumII {

	static int BS(int[] arr, int X, int low) {
		int high = arr.length - 1;
		int ans = arr.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] >= X) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return ans;
	}
	
	
	
	static int countPairsWithSumK(int arr[], int n, int k) {
		int count = 0;
		Arrays.sort(arr); // Sort array elements
		int l = 0;
		int r = 0;
		while (r < n) {
			if (arr[r] + arr[l] == k) {
				count++;
				l++;
				r++;
			} else if (arr[r] + arr[l] > k)
				l++;
			else // arr[r] - arr[l] < sum
				r++;
		}
		return count;
	}

	int solve(int[] A, int B) {
		int count = 0;
		int N = A.length;

		/*
		 * for (int i = 0; i < N; i++) { for (int j = i + 1; j < N; j++) { if (A[i] +
		 * A[j] == B) { count++; } } }
		 */

		
		/*
		 * for (int i = 0; i < N; ++i) { int X = BS(A, A[i] + B, i + 1); if (X != N) {
		 * int Y = BS(A, A[i] + B + 1, i + 1); count += Y - X; } }
		 */
		 
		count = countPairsWithSumK(A, N, B);
		
		return count;
	}

	public static void main(String[] args) {
		int arr[] = {2, 3, 5, 6, 10 };
		int k = 6;
		System.out.println("Count of pairs with given SUM is " + new PairsWithGivenSumII().solve(arr, k));

	}

}
