package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*Absolute maximum
Problem Description

Given 4 array of integers A, B, C and D of same size, find and return the maximum value of | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j| where i != j and |x| denotes the absolute value of x.



Problem Constraints
2 <= length of the array A, B, C, D <= 100000
-106 <= A[i] <= 106



Input Format
The arguments given are the integer arrays A, B, C, D.



Output Format
Return the maximum value of | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j|



Example Input
Input 1:

 A = [1, 2, 3, 4]
 B = [-1, 4, 5, 6]
 C = [-10, 5, 3, -8]
 D = [-1, -9, -6, -10]
Input 2:

 A = [1, 2]
 B = [3, 6]
 C = [10, 11]
 D = [1, 6]


Example Output
Output 1:

 30
Output 2:

 11


Example Explanation
Explanation 1:

 Maximum value occurs for i = 0 and j = 1.
Explanation 2:

There is only one possibility for i, j as there are only two elements in the array.*/
public class AbsoluteMaximum {

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D) {

		int N = A.size();
		int max = 0;
		/*
		 * // Brute Force. for(int i=0;i<N;i++ ) { //max = (Math.abs(A.get(i)-A.get(0))
		 * + Math.abs(B.get(i)-B.get(0)) + Math.abs(C.get(i)-C.get(0)) +
		 * Math.abs(D.get(i)-D.get(0)) + Math.abs(i - 0)); for(int j=i;j<N;j++) { max =
		 * Math.max(max, (Math.abs(A.get(i)-A.get(j)) + Math.abs(B.get(i)-B.get(j)) +
		 * Math.abs(C.get(i)-C.get(j)) + Math.abs(D.get(i)-D.get(j)) + Math.abs(i - j)))
		 * ; } }
		 */

		for (int i = 0; i < 16; i++) {
			int MAX = Integer.MIN_VALUE;
			int MIN = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				int curr = A.get(j);
				for (int k = 0; k < 4; k++) {
					int temp = 0;
					if (k == 0) {
						temp = B.get(j);
					} else if (k == 1) {
						temp = C.get(j);
					} else if (k == 2) {
						temp = D.get(j);
					} else {
						temp = j;
					}
					int bits = i & (1 << k);
					if (bits > 0) {
						curr += temp;
					} else {
						curr -= temp;
					}
				}
				MAX = Math.max(MAX, curr);
				MIN = Math.min(MIN, curr);
				max = Math.max(max, MAX - MIN);

			}
		}
		return max;
	}

	public static void main(String[] args) {

		
		  ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		  ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-1, 4, 5, 6));
		  ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(-10, 5, 3, -8));
		  ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(-1, -9, -6,
		  -10));
		 
		/*
		 * ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2));
		 * ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 6));
		 * ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(10, 11));
		 * ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(1, 6));
		 */
		int result = new AbsoluteMaximum().solve(A, B, C, D);
		System.out.println("Result is:>>" + result);

	}

}
