package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Pairs with Given Difference
Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints
1 <= N <= 104

0 <= A[i], B <= 105



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.



Example Input
Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0


Example Output
Output 1:

 2
Output 2:

 5
Output 3:

 2


Example Explanation
Explanation 1:

 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 
Explanation 2:

 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
Explanation 3:

 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class PairsWithGivenDifference2 {

	static int countPairsWithDiffK(int arr[], int n, int k) {
		int count = 0;
		Arrays.sort(arr); // Sort array elements

		int l = 0;
		int r = 0;
		while (r < n) {
			if (arr[r] - arr[l] == k) {
				count++;
				l++;
				r++;
			} else if (arr[r] - arr[l] > k)
				l++;
			else // arr[r] - arr[l] < sum
				r++;
		}
		return count;
	}

//Driver program to test above function
	public static void main(String[] args) {
		//int arr[] = { 1, 5, 3, 4, 2 };
		int arr[] = { 8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
		int n = arr.length;
		int k = 3;
		System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
	}

	/*
	 * public static void main(String[] args) { PairsWithGivenDifference2
	 * subarrayWithGivenSum = new PairsWithGivenDifference2(); ArrayList<Integer>
	 * inputArray = new ArrayList<Integer>(Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5,
	 * 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10,
	 * 3, 8, 10, 6, 5, 4, 2, 3)); int result =
	 * subarrayWithGivenSum.solve(inputArray, 3); System.out.println(result);
	 * 
	 * }
	 */

}
