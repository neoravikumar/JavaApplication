package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Odd Even Subsequences
Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.

A subsequence is said to odd-even in the following cases:

The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]

The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]

Return the maximum possible length of odd-even subsequence.

Note: An array B is a subsequence of an array A if B can be obtained from A by deletion of several (possibly, zero or all) elements.


Input Format

The only argument given is the integer array A.
Output Format

Return the maximum possible length of odd-even subsequence.
Constraints

1 <= N <= 100000
1 <= A[i] <= 10^9 
For Example

Input 1:
    A = [1, 2, 2, 5, 6]
Output 1:
    4
    Explanation 1:
        Maximum length odd even subsequence is [1, 2, 5, 6]

Input 2:
    A = [2, 2, 2, 2, 2, 2]
Output 2:
    1
    Explanation 2:
        Maximum length odd even subsequence is [2]*/

public class OddEvenSubsequences {

	public int solve(ArrayList<Integer> A) {
		int counter = 1;
		if (null != A && (A.size() >= 1 && A.size() <= 100000)) {
			
			for (int k = 0,l=1; k < A.size() && l < A.size(); k++,l++) {
				int value = (Integer) A.get(k);
				if (value >= 1 && value <= Math.pow(10, 9)) {
					if (value % 2 == 0 && A.get(l) % 2 != 0) {
						++counter;
					}
					if (value % 2 != 0 && A.get(l) % 2 == 0) {
						++counter;
					}
				}
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		OddEvenSubsequences oddEvenSubsequences = new OddEvenSubsequences();

		// List<Integer> lst = Arrays.asList(913, 440, 865, 72, 612, 445, 101, 994, 356,
		// 91, 461, 930, 583, 448, 543, 170, 333, 107, 425, 73, 172, 416, 899, 826, 659,
		// 561, 314, 25, 110 );
		List<Integer> lst = Arrays.asList(1, 2, 2, 4, 5);

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		int result = oddEvenSubsequences.solve(abc);
		System.out.println(result);

	}

}
