package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Subarray with given sum
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
 */
public class SubarrayWithGivenSum3 {

	public int[] solve(int[] arr, int k) {

		// Declare two variable start and end
		int start = 0;
		int end = 1;

		// In sum variable, Assign the value present at 0th index
		int sum = arr[0];
		int len = arr.length;

		while (end <= len) {

			while (sum > k && start < end - 1) {
				sum = sum - arr[start];
				start++;
			}

			if (sum == k) {
				int length = Math.abs((end) - start);
				int[] result = new int[length];
				for (int l = start, i = 0; l <= end - 1; l++, i++) {
					result[i] = arr[l];
				}

				return result;
			}

			if (end < len)
				sum = sum + arr[end];

			end++;

		}

		return new int[] { -1 };

	}

	public static void main(String[] args) {
		SubarrayWithGivenSum3 subarrayWithGivenSum = new SubarrayWithGivenSum3();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13,
				37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35,
				9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14,
				19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37));
		
		int[] aa = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6 };
		
		int[] result = subarrayWithGivenSum.solve(aa, 62);
		System.out.println(result);

	}

}
