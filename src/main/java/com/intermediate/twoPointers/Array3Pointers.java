package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Array 3 Pointers
Problem Description

You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints
0 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107



Input Format
First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.



Output Format
Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Example Input
Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 With 10 from A, 15 from B and 10 from C.
Explanation 2:

 With 3 from A, 2 from B and 3 from C.
 */
public class Array3Pointers {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

		int i = 0;
		int j = 0;
		int k = 0;

		int ans = Integer.MAX_VALUE;

		while (i < A.size() && j < B.size() && k < C.size()) {
			int minVal = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
			int maxVal = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

			if (ans > maxVal - minVal) {
				ans = maxVal - minVal;
			}

			if (minVal == A.get(i))
				i++;
			else if (minVal == B.get(j))
				j++;
			else
				k++;
		}

		return ans;
	}

	public static void main(String[] args) {
		Array3Pointers array3Pointers = new Array3Pointers();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 10));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 15, 20));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(10, 12));
		int result = array3Pointers.minimize(A, B, C);
		System.out.println(result);
	}

}
