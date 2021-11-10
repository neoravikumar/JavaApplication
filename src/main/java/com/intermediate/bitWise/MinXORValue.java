package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Min XOR value
Problem Description

Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting minimum xor value.



Example Input
Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 0 xor 2 = 2
 */
public class MinXORValue {

	public int findMinXor(ArrayList<Integer> A) {

		int N = A.size();
		Collections.sort(A);
		int result = Integer.MAX_VALUE;
		
		for(int i=0;i<N-1;i++) {
			result = Math.min(result, A.get(i)^A.get(i+1));
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new MinXORValue().findMinXor(new ArrayList<Integer>(Arrays.asList(0, 4, 7, 9))));
	}

}
