package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Maximum Difference
Given an array of integers A and an integer B. Find and return the maximum value of | s1 - s2 |

where s1 = sum of any subset of size B, s2 = sum of elements of A - sum of elemets of s1

Note |x| denotes the absolute value of x.


Input Format

The arguments given are the integer array A and integer B.
Output Format

Return the maximum value of | s1 - s2 |.
Constraints

1 <= B < length of the array <= 100000
1 <= A[i] <= 10^5 
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
Output 1:
    9

Input 2:
    A = [5, 17, 100, 11]
    B = 3
Output 2:
    123
 */
public class MaximumDifference {

	public int solve(ArrayList<Integer> A, int B) {

		int N = A.size();
		int diff = Integer.MIN_VALUE;

		ArrayList<Integer> prefixSum = new ArrayList<Integer>();
		Collections.sort(A);

		if (B >= 1 && (B < N && B <= 100000)) {
			int value = A.get(0);
			prefixSum.add(0, value);
			for (int i = 1; i < N; i++) {
				int sum = prefixSum.get(i - 1) + A.get(i);
				prefixSum.add(sum);
			}
			int tSum = prefixSum.get(N - 1);
			for (int i = 0, k = B - 1; i < N && k < N; i++, k++) {
				int s1 = 0;
				if (i+k<=k) {
					s1 = prefixSum.get(k);
				} else {
					s1 = prefixSum.get(k) - prefixSum.get(i - 1);
				}
				int s2 = tSum - s1;
				int s1_S2 = s1 - s2;
				diff = Math.max(diff, Math.abs(s1_S2));
			}
		}

		return diff;
	}

	public static void main(String[] args) {

		//List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		//List<Integer> integers = Arrays.asList(5, 17, 100, 11);
		List<Integer> integers = Arrays.asList(93, 51, 84, 81, 89, 82, 28, 78, 86,35, 64, 38, 49, 99, 83);

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		MaximumDifference eq = new MaximumDifference();
		int result = eq.solve(inputArray, 4);
		System.out.println("Result:>>" + result);

	}

}
