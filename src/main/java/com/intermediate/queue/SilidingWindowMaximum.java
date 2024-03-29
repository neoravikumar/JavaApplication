package com.intermediate.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 Sliding Window Maximum
Problem Description

Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.



Problem Constraints
1 <= |A|, B <= 106



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].



Example Input
Input 1:

 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
Input 2:

 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6


Example Output
Output 1:

 [3, 3, 5, 5, 6, 7]
Output 2:

 [7, 7, 7, 7]


Example Explanation
Explanation 1:

 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7
Explanation 2:

 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7
 */
public class SilidingWindowMaximum {

	public int[] slidingMaximum(final int[] A, int B) {

		int i = 0;
		int j = 0;
		int min = 0;
		int ans[] = new int[A.length - B + 1];
		// create deque
		Deque<Integer> queue = new LinkedList<>();

		while (j < A.length) {
			while (!queue.isEmpty() && queue.peekLast() < A[j]) {
				queue.pollLast();
			}
			queue.add(A[j]);
			if ((j - i + 1) == B) {
				ans[i] = queue.peekFirst();
				if (queue.peekFirst() == A[i]) {
					queue.pollFirst();
				}
				i++;
			}
			j++;
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] input = { 1, 3, -1, -3, 5, 3, 6, 7 };
		SilidingWindowMaximum slidMaxm = new SilidingWindowMaximum();
		int[] result = slidMaxm.slidingMaximum(input, 3);
		System.out.println(Arrays.toString(result));
	}

}
