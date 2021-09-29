package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		
		int result = 0;
		int answer = Integer.MAX_VALUE;
		int min = 0;
		int N = A.size();
		int max = 0;
		
		Collections.sort(A);
		
		
		
		min = A.get(0);
		max = A.get(N-1);

		// frequency map with key as array Element value as it's no# of occurence.
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.size(); i++) {
			if (!freq.containsKey(A.get(i))) {
				freq.put(A.get(i), 1);
			} else {
				int value = freq.get(A.get(i)) + 1;
				freq.put(A.get(i), value);
			}
		}
		
		while (B>0 && answer != 0) {
			
			if(freq.get(min) > freq.get(max)) {
				//freq.get(max-1) += freq.get(max);
				
			}
			
		}
		

		

		return result;

	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(2, 6, 3, 9, 8);

		ContiguousArray contiguousArray = new ContiguousArray();
		int result = contiguousArray.solve(new ArrayList<Integer>(input), 3);
		System.out.println("Result is :-:" + result);

	}

}
