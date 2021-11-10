package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Single Number II
Problem Description

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?




Problem Constraints
2 <= A <= 5*106

0 <= A <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer.



Example Input
Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 */
public class SingleNumberII {

	boolean getBit(int n, int pos) {
		return ((n & (1 << pos)) != 0);
	}

	int setBit(int n, int pos) {
		return n | 1 << pos;
	}

	public int singleNumber(final List<Integer> A) {

		int result = 0;
		int N = A.size();
		for (int i = 0; i < 64; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (getBit(A.get(j), i)) {
					sum++;
				}
			}
			if (sum % 3 != 0) {
				result = setBit(result, i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumberII singleNumberII = new SingleNumberII();
		int result = singleNumberII.singleNumber(
				new ArrayList<Integer>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1)));
		System.out.println(result);

	}

}
