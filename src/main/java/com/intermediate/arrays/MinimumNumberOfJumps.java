package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Minimum number of jumps
Problem Description

Given an array of non-negative integers A where each element represents your maximum jump length at that position.
The initial position is the first index of the array and goal is to reach the last index of the array with the minimum number of jumps.

Note: If it not possible to reach the last index return -1 instead.



Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum number of jumps to reach the last index or -1 if it is not possible.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

Initial position is the first index.
From index 0 we can only jump to index 1 as first element is 0.
From index 1 we can jump to index 2 or index 3.
From index 2 we can reach the last index i.e. 4 in 1 jump.
so, the minimum number of jumps required is 3.
 */
public class MinimumNumberOfJumps {

	public int solve(ArrayList<Integer> A) {
		int N = A.size();
		/*
		 * if(A.get(0)==0){ return 0; } int[] jumps = new int[N]; Arrays.fill(jumps,
		 * Integer.MAX_VALUE); jumps[0] = 0; for (int i = 1; i < N; i++) { for (int j =
		 * 0; j < i; j++) { if (i <= (j + A.get(j))) { jumps[i] = Math.min(jumps[i],
		 * jumps[j] + 1); } } } return jumps[N-1];
		 */

		if (A.get(0) == 0) {
			return -1;
		}

		int maxReachable = A.get(0);
		int jumps = 1;
		int stepsPossible = A.get(0);
		for (int i = 1; i < N; i++) {
			if (i == N - 1) {
				return jumps;
			}
			maxReachable = Math.max(maxReachable, i+A.get(i));
			stepsPossible--;
			if(stepsPossible==0) {
				jumps++;
				if(i>=maxReachable) {
					return -1;
				}
				stepsPossible = maxReachable - i;
			}

		}
		return jumps;

	}

	public static void main(String[] args) {
		MinimumNumberOfJumps minimumNumberOfJumps = new MinimumNumberOfJumps();
		int result = minimumNumberOfJumps.solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
		System.out.println("The Answer is:>>" + result);
	}

}
