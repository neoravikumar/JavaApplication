package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Closest MinMax
Problem Description

Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array

and atleast one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3]
Input 2:

A = [2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Only choice is to take both elements.
Explanation 2:

 Take the whole array.
 */
public class ClosestMinMax {

	public int solve(ArrayList<Integer> A) {

		int min_element = Integer.MAX_VALUE;
		int max_element = Integer.MIN_VALUE;

		int pos_min = -1, pos_max = -1;

		int result = Integer.MAX_VALUE;

		int N = A.size();
		for (int i = 0; i < N; i++) {
			if (A.get(i) > max_element) {
				max_element = A.get(i);
			}
			if (A.get(i) < min_element) {
				min_element = A.get(i);
			}
		}

		for (int i = 0; i < N; i++) {
			if (A.get(i) == min_element)
				pos_min = i;

			// last occurrence of maxValue
			if (A.get(i) == max_element)
				pos_max = i;

			if (pos_max != -1 && pos_min != -1)
				result = Math.min(result, Math.abs(pos_min - pos_max) + 1);

		}

		return result;
	}

	public static void main(String[] args) {

		ClosestMinMax closestMinMax = new ClosestMinMax();
		int result = closestMinMax.solve(new ArrayList<Integer>(Arrays.asList(377, 448, 173, 307, 108)));
		System.out.println("The Answer is:>>" + result);

	}

}
