package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.*/
public class SubArrayWithZeroSum {

	public int solve(ArrayList<Integer> A) {

		Set<Long> resultSet = new HashSet<Long>();
		ArrayList<Long> prefixSum = new ArrayList<Long>();

		int N = null != A ? A.size() : 0;
		int resultInt = 0;

//		for (int i = 0; i < N; i++) {
//			for (int j = i; i < N; i++) {
//				List<Integer> subArray = A.subList(i + 1, j + 1);
//				for (Integer a : subArray) {
//					sum += a;
//					if (sum == 0) {
//						return 1;
//					}
//				}
//			}
//
//		}

	

		if (N >= 1 && N <= 100000) {

			if (A.get(0) >= (-Math.pow(10, 9)) && A.get(0) <= Math.pow(10, 9)) { // Prefix Sum calculation
				prefixSum.add(Long.valueOf(A.get(0)));
				resultSet.add(Long.valueOf(A.get(0)));
			}
			for (

					int i = 1; i < N; i++) {
				if (A.get(i) >= (-Math.pow(10, 9)) && A.get(i) <= Math.pow(10, 9)) {
					Long sum = A.get(i) + prefixSum.get(i - 1);
					prefixSum.add(i, sum);
					if (prefixSum.get(i) == 0 || resultSet.contains(prefixSum.get(i))) {
						resultInt = 1;
						return resultInt;
					} else {
						resultSet.add(prefixSum.get(i));
					}
				}

			}
		}

		return resultInt;
	}

	public static void main(String[] args) {

		SubArrayWithZeroSum smallerAndGreater2 = new SubArrayWithZeroSum();

		List<Integer> lst = Arrays.asList(1, -1);
		// List<Integer> lst = Arrays.asList(-1, 1);

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);
		System.out.println("______________");
		System.out.println(smallerAndGreater2.solve(abc));

	}

}
