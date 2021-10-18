package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Merge Two Sorted Arrays
Problem Description

Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i],B[i] <= 1010



Input Format
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.



Output Format
Return a 1-D vector which you got after merging A and B.



Example Input
Input 1:

A = [4, 7, 9 ]
B = [2 ,11, 19 ]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArrays {

	public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int N = A.size();
		int M = B.size();
		
		for(int i=0;i<N;i++) {
			result.add(A.get(i));
		}
		for(int i=0;i<M;i++) {
			result.add(B.get(i));
		}

		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
		
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(-4, -3, 0));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(2));
		
		ArrayList<Integer> result = mergeTwoSortedArrays.solve(a1,a2);
		System.out.println(result);

	}

}
