package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Reverse pairs
Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).
 */
public class ReversePairs {

	public int ret;
	public int solve(int[] A) {
		ret = 0;
		int[] aux = Arrays.copyOf(A, A.length);
		mergeSort(A, aux, 0, A.length - 1);
		return ret;
	}

	void merge(int[] arr, int[] aux, int low, int mid, int high) {
		int k = low, i = low, j = mid + 1;

		// while there are elements in the left and right runs
		while (i <= mid && j <= high) {
			int temp = 0;
			
			if (arr[i] <= arr[j]) {
				aux[k++] = arr[i++];
			} else {
				temp = arr[j++];
				aux[k++] = temp;
			}
		}

		// copy remaining elements
		while (i <= mid) {
			aux[k++] = arr[i++];
		}


		// copy back to the original array to reflect sorted order
		for (i = low; i <= high; i++) {
			arr[i] = aux[i];
		}

	}

	void mergeSort(int[] arr, int[] aux, int low, int high) {
		// base case
		if (high <= low) { // if run size <= 1
			return ;
		}

		// find midpoint
		int mid = (low + ((high - low) >> 1));

		// recursively split runs into two halves until run size <= 1,
		// then merges them and return up the call chain

		// split/merge left half
		mergeSort(arr, aux, low, mid);

		// split/merge right half
		mergeSort(arr, aux, mid + 1, high);
		
		//count elements
        int count = 0;
        for (int l = low, r = mid+1; l <= mid;) {
            if (r > high || (long)arr[l] <= 2*(long)arr[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }

		// merge the two half runs
		merge(arr, aux, low, mid, high);
	}

	public static void main(String[] args) {

		ReversePairs inAnArray = new ReversePairs();
		int[] arr = {1, 3, 2, 3, 1};
		int result = inAnArray.solve(arr);
		System.out.println("Result is:>>" + result);

	}

}
