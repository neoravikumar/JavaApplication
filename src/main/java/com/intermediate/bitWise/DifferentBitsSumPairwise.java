package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;

/*

Different Bits Sum Pairwise
Problem Description

We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 231 - 1



Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a single integer denoting the sum.



Example Input
Input 1:

 A = [1, 3, 5]
Input 2:

 A = [2, 3]


Example Output
Ouptut 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:

 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
 
 */
public class DifferentBitsSumPairwise {

	private static final long MOD = (long) (Math.pow(10, 9) + 7);

	public int cntBits(ArrayList<Integer> A) {
		/*
		 * // Brure Force approach int totalSum = 0; int N = N; for (int i = 0; i < N;
		 * i++) { for (int j = 0; j < N; j++) {
		 * System.out.println(i+"::"+j+"::"+checkDifferentBits(A.get(i), A.get(j)));
		 * totalSum += checkDifferentBits(A.get(i), A.get(j)); } }
		 * 
		 * return totalSum;
		 */

		long ans = 0;
		long count = 0;
		long N = A.size();
		for (int i = 0; i < 32; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if ((A.get(j) & (1 << i)) != 0) {
					count++;
				}
			}

			ans += (count * (N - count) * 2);
			ans %= MOD;
		}
		return new Long(ans).intValue();
	}

	private int checkDifferentBits(int a, int b) {
		int xor = a ^ b;
		int count = 0;
		while (xor > 0) {
			xor = xor & (xor - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		DifferentBitsSumPairwise differentBitsSumPairwise = new DifferentBitsSumPairwise();
		int result = differentBitsSumPairwise.cntBits(new ArrayList<Integer>(Arrays.asList(1, 3, 5)));
		System.out.println(result);

	}

}
