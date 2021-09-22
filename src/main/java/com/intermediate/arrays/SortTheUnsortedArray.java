package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.intermediate.problemSolving.EquilibriumIndexArray;

/**
 * Sort the Unsorted Array Problem Description
 * 
 * You are given an integer array A having N integers.
 * 
 * You have to find the minimum length subarray A[l..r] such that sorting this
 * subarray makes the whole array sorted.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 105
 * 
 * -109 <= A[i] <= 109
 * 
 * 
 * 
 * Input Format First and only argument is an integer array A.
 * 
 * 
 * 
 * Output Format Return an integer denoting the minimum length.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [0, 1, 15, 25, 6, 7, 30, 40, 50] Input 2:
 * 
 * A = [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60]
 * 
 * 
 * Example Output Output 1:
 * 
 * 4 Output 2:
 * 
 * 6
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * The smallest subarray to be sorted to make the whole array sorted = A[3..6]
 * i.e, subarray lying between positions 3 and 6. Explanation 2:
 * 
 * The smallest subarray to be sorted to make the whole array sorted = A[4..9]
 * i.e, subarray lying between positions 4 and 9.
 */
public class SortTheUnsortedArray {

	public int solve(ArrayList<Integer> A) {

		int N = A.size();
		int index = 0, endIndex = 0;
		if (N >= 1 && N <= Math.pow(10, 5)) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(A);
			Collections.sort(temp);
			for (int i = 0; i < N; i++) {

				if (A.get(i) == temp.get(i)) {
					index++;
				} else {
					break;
				}
				
				if(index == N) {
					return 0;
				}

			}
			for (int i = N - 1; i > 0; i--) {

				if (A.get(i) == temp.get(i)) {
					endIndex++;
				} else {
					break;
				}

			}

		}
		return ((N - endIndex) - index);

	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(-146316343, 179840175, 760528516);

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		SortTheUnsortedArray eq = new SortTheUnsortedArray();
		int result = eq.solve(inputArray);
		System.out.println("Result:>>" + result);

	}

}
