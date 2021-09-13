package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 
 Minimize Difference
Problem Description

Given an array of integers A of size, N. Minimize the absolute difference between the maximum and minimum element of the array.

You can perform two types of operations at most B times in total to change the values in the array.
Multiple operations can be performed on the same element.

Increment : A[i] -> A[i] + 1.

Decrement : A[i] -> A[i] - 1.

Return the minimum difference possible.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106

1 <= B <= 109



Input Format
First argument is an integer array A.
Second argument is an integer B which represents the maximum number of operations that can be performed.



Output Format
Return an integer denoting the minimum difference.



Example Input
Input 1:

 A = [2, 6, 3, 9, 8]
 B = 3
Input 2:

 A = [4, 6, 3, 1, 4]
 B = 5


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 We can apply the atmost 3 operations in the following sequence.
 Initial array => [2, 6, 3, 9, 8].
   Decrement 9 => [2, 6, 3, 8, 8].
   Increment 2 => [3, 6, 3, 8, 8].
   Increment 3 => [3, 6, 4, 8, 8].
 Max = 8. Min = 3.
 Therefore, abs|Max - Min| = |8 - 3| = 5.
Explanation 2:

 We can apply the atmost 5 operations in the following sequence.
 Initial array => [4, 6, 3, 1, 4].
   Increment 1 => [4, 6, 3, 2, 4].
   Decrement 6 => [4, 5, 3, 2, 4].
   Increment 2 => [4, 5, 3, 3, 4].
   Decrement 5 => [4, 4, 3, 3, 4].
   Increment 3 => [4, 4, 4, 3, 4].
 Max = 4. Min = 3.
 Therefore, abs|Max - Min| = |4 - 3| = 1.
 
 */
public class MinimizeDifference {

	public int solve(ArrayList<Integer> A, int B) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minIndex = 0;
		int maxIndex = 0;
		Collections.sort(A);
		int result = makeDifferenceOperations(A, min, minIndex, max, maxIndex, B);

		return result;
	}

	private int makeDifferenceOperations(ArrayList<Integer> A, int min, int minIndex, int max, int MaxIndex, int B) {

		for (int j = 0; j < B; j++) {

			for (int i = 0; i < A.size(); i++) {
				if (A.get(i) < min) {
					min = A.get(i);
					minIndex = i;
				}
				if (A.get(i) > max) {
					max = A.get(i);
					MaxIndex = i;
				}
			}

			if (j % 2 == 0) {
				A.set(MaxIndex, A.get(MaxIndex) - 1);
				max = A.get(MaxIndex);
			} else {
				A.set(minIndex, A.get(minIndex) + 1);
				min=A.get(minIndex);
			}
		}
		return max - min;
	}

	public static void main(String[] args) {

		MinimizeDifference minimizeDifference = new MinimizeDifference();

		ElementsRemoval elementsRemoval = new ElementsRemoval();
		List<Integer> lst = Arrays.asList(1,1,7);
		//List<Integer> lst = Arrays.asList(4, 6, 3, 1, 4);

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(minimizeDifference.solve(abc, 7));

	}

}
