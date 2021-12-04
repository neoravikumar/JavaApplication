package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
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
		int j = 0, k = 0;
		
		
		while(j<A.size() && k<B.size()) {
			if ((j<A.size() && k<B.size()) && A.get(j) <= B.get(k)) {
				result.add(A.get(j));
				j++;
			}
			
			if ((j<A.size() && k<B.size()) && B.get(k) <= A.get(j)) {
				result.add(B.get(k));
				k++;
			}
		}
		
		while(j<A.size()) {
			result.add(A.get(j));
			j++;
		}
		while(k<B.size()) {
			result.add(B.get(k));
			k++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
		ArrayList<Integer> result = mergeTwoSortedArrays.solve(new ArrayList<Integer>(Arrays.asList(4, 7, 9 )),
				new ArrayList<Integer>(Arrays.asList(2,11,19 )));
		System.out.println("result is:>>" + result);
	}

}
