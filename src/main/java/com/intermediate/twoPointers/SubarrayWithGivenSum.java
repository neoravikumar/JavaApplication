package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
public class SubarrayWithGivenSum {

	public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

		int N = A.size();
		boolean found = false;
		
		/*
		 * int start = 0; int end = N-1;
		 * 
		 * ArrayList<Integer> result = new ArrayList<Integer>();
		 * 
		 * while(start<end) { if(A.get(start)+A.get(end) == B) { found = true; break; }
		 * if((A.get(start)+A.get(end))>B) { end--; } if((A.get(start)+A.get(end))<B) {
		 * start++; } }
		 * 
		 * if(!found) { result.add(-1);
		 * 
		 * }else { result.add(start); result.add(end); } return result;
		 */


		// Declare two variable start and end
		int start = 0;
		int end = 1;
		int currentSum = A.get(0);
		int len = A.size();
		//Collections.sort(A);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (end <= len) {

			while (currentSum > B && start < end - 1) {
				currentSum = currentSum - A.get(start);
				start++;
			}

			if (currentSum == B) {
				
				for(int k=start;k<=end-1;k++) {
					result.add(A.get(k));
				}
				return result;
			}

			if (end < len) {
				currentSum = currentSum + A.get(end);
			}
			end++;
		}
		result.add(-1);
		return result;

	}

	public static void main(String[] args) {
		SubarrayWithGivenSum subarrayWithGivenSum = new SubarrayWithGivenSum();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6 ));
		ArrayList<Integer> result = subarrayWithGivenSum.solve(inputArray, 62);
		System.out.println(result);

	}

}
