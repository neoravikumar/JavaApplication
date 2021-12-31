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
public class SubarrayWithGivenSum2 {

	public int solve(ArrayList<Integer> A, int B) {

//		int N = A.size();
//		int counter=0;
//		int sum = 0;
//		// Brute force
//		for(int i=0;i<N;i++) {
//			for(int j=i+1;j<N;j++) {
//				sum = A.get(i) + A.get(j);
//				if(sum == B) {
//					counter++;
//				}
//			}
//		}
//		
//		return counter;

		int N = A.size();
		int start = 0;
		int end = N - 1;
		long answer = 0l;
		int MOD = (int) (Math.pow(10, 9) + 7);

		while (start < end) {
			int sum = A.get(start) + A.get(end);

			if (sum > B) {
				end--;
			} else if (sum < B) {
				start++;
			} // If sum is equal
			else {
				// Find the frequency of A.get(start)
				long x = A.get(start), xx = start;
				while ((start < end) && (A.get(start) == x))
					start++;

				// Find the frequency of A.get(end)
				int y = A.get(end), yy = end;
				while ((end >= start) && (A.get(end) == y))
					end--;

				// If A.get(start) and A.get(end) are same
				// then remove the extra number counted
				if (x == y) {
					long temp = (start - xx + yy - end - 1)% MOD;
					answer += ((temp * (temp + 1)) / 2) % MOD;
				} else
					answer += ((start - xx)  * (yy - end))% MOD;
			}
		}
		return new Long(answer).intValue();
	}

	public static int printPairsUsingTwoPointers(int[] numbers, int k) {
		if (numbers.length < 2) {
			return 0;
		}
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length - 1;
		int answer = 0;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				answer++;
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		SubarrayWithGivenSum2 subarrayWithGivenSum = new SubarrayWithGivenSum2();

		// int[] aa = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32,
		// 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5,
		// 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29,
		// 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24,
		// 8, 3, 12, 34, 14, 6 };
		int[] aa = { 1, 1, 1 };
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
		int result = subarrayWithGivenSum.solve(inputArray, 2);
		System.out.println(result);

		// int data = printPairsUsingTwoPointers(aa , 2);

		// System.out.println("The answer is :>>"+data);

	}

}
