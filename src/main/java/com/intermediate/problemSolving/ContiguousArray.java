package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 Contiguous Array
Given an array of integers A consisting of only 0 and 1.

Find the maximum length of a contiguous subarray with equal number of 0 and 1.



Input Format

The only argument given is the integer array A.
Output Format

Return the maximum length of a contiguous subarray with equal number of 0 and 1.
Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 1
For Example

Input 1:
    A = [1, 0, 1, 0, 1]
Output 1:
    4
    Explanation 1:
        Subarray from index 0 to index 3 : [1, 0, 1, 0]
        Subarray from index 1 to index 4 : [0, 1, 0, 1]
        Both the subarrays have equal number of ones and equal number of zeroes.

Input 2:
    A = [1, 1, 1, 0]
Output 2:
    2 
 */
public class ContiguousArray {

	public int solve(ArrayList<Integer> A, int B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		// Initialize result
		int max_len = 0;
		int ending_index = -1;
		int start_index = 0;

		for (int i = 0; i < A.size(); i++) {
			A.set(i, A.get(i)== 0? -1 : 1);
		}


		for (int i = 0; i < A.size(); i++) {
			sum += A.get(i);
			if (sum == 0) {
				max_len = i + 1;
				ending_index = i;
			}
			if (map.containsKey(sum)) {
				if (max_len < i - map.get(sum)) {
					max_len = i - map.get(sum);
					ending_index = i;
				}
			} else 
				map.put(sum, i);
		}

		for (int i = 0; i < A.size(); i++) {
			A.set(i, A.get(i)== -1? 0 : 1);
		}

		return max_len;

	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 0, 1, 0, 1);

		ContiguousArray contiguousArray = new ContiguousArray();
		int result = contiguousArray.solve(new ArrayList<Integer>(input), 3);
		System.out.println("Result is :-:" + result);

	}

}
