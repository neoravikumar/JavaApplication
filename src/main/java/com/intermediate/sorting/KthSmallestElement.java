package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Kth Smallest Element
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
First argument is vector A.

Second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.*/
public class KthSmallestElement {

	public int kthsmallest(final List<Integer> A, int B) {

		int result = 0;
		int N = null != A ? A.size() : 0;
		if (N >= 1 && N <= 100000) {
			if (B >= 1 && B <= Math.min(N, 500)) {

				if (B > N) {
					return -1;
				}

				Collections.sort(A);
				result = A.get(B-1);
			}
		}

		return result;
	}

	public static void main(String[] args) {

		KthSmallestElement kthSmallestElement = new KthSmallestElement();

		List<Integer> lst = Arrays.asList(2, 1, 4, 3, 2);
		// List<Integer> lst = Arrays.asList(-4, -2, 0, -1, -6 );

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(kthSmallestElement.kthsmallest(abc, 3));
	}

}
