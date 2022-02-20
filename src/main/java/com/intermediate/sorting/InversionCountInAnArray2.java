package com.intermediate.sorting;

import java.util.Arrays;

/*
 Inversion count in an array
Problem Description
Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
 */
public class InversionCountInAnArray2 {

	public int solve(int[] A) {

		int[] aux = Arrays.copyOf(A, A.length);
		return mergeSort(A, aux, 0, A.length - 1);
	}

	int merge(int[] arr, int[] aux, int low, int mid, int high) {
		int k = low, i = low, j = mid + 1;
		int inversionCount = 0;

		int MOD = (int) (Math.pow(10, 9) + 7);

		// while there are elements in the left and right runs
		while (i <= mid && j <= high) {
			int temp = 0;

			if (arr[i] <= arr[j]) {
				aux[k++] = arr[i++];
			} else {
				temp = arr[j++];
				aux[k++] = temp;
				inversionCount += (mid - i + 1);// NOTE
			}
		}

		// copy remaining elements
		while (i <= mid) {
			aux[k++] = arr[i++];
		}

		/*
		 * no need to copy the second half (since the remaining items are already in
		 * their correct position in the temporary array)
		 */

		// copy back to the original array to reflect sorted order
		for (i = low; i <= high; i++) {
			arr[i] = aux[i];
		}

		return inversionCount;
	}

	int mergeSort(int[] arr, int[] aux, int low, int high) {
		// base case
		if (high <= low) { // if run size <= 1
			return 0;
		}

		// find midpoint
		int mid = (low + ((high - low) >> 1));
		int inversionCount = 0;
		int Mod = (int) (Math.pow(10, 9) + 7);

		// recursively split runs into two halves until run size <= 1,
		// then merges them and return up the call chain

		// split/merge left half
		inversionCount += mergeSort(arr, aux, low, mid);
		inversionCount = inversionCount % Mod;

		// split/merge right half
		inversionCount += mergeSort(arr, aux, mid + 1, high);
		inversionCount = inversionCount % Mod;

		// merge the two half runs
		inversionCount += merge(arr, aux, low, mid, high);
		inversionCount = inversionCount % Mod;

		return inversionCount;

	}

	public static void main(String[] args) {

		InversionCountInAnArray2 inAnArray = new InversionCountInAnArray2();
		int[] arr = { 45, 10, 15, 25, 50 };
		int result = inAnArray.solve(arr);
		System.out.println("Result is:>>" + result);

	}

}
