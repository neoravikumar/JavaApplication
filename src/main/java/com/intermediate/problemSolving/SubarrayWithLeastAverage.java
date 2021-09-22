package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Subarray with least average Problem Description
 * 
 * Given an array of size N, Find the subarray with least average of size k.
 * 
 * 
 * 
 * Problem Constraints 1<=k<=N<=1e5 -1e5<=A[i]<=1e5
 * 
 * 
 * Input Format First argument contains an array A of integers of size N. Second
 * argument contains integer k.
 * 
 * 
 * Output Format Return the index of the first element of the subarray of size k
 * that has least average. Array indexing starts from 0.
 * 
 * 
 * Example Input Input 1: A=[3, 7, 90, 20, 10, 50, 40] B=1; Input 2:
 * 
 * A=[3, 7, 5, 20, -10, 0, 12] B=2
 * 
 * 
 * Example Output Output 1: 3 Output 2:
 * 
 * 4
 * 
 * 
 * Example Explanation Explanation 1: Subarray between indexes 3 and 5 The
 * subarray {20, 10, 50} has the least average among all subarrays of size 3.
 * Explanation 2:
 * 
 * Subarray between [4, 5] has minimum average
 */
public class SubarrayWithLeastAverage {

	public int solve(ArrayList<Integer> A, int K) {
		int N = null != A ? A.size() : 0;
		int ans = 0;
		int sum = 0;
		int resultIndex =0;
		if ((N >= 1 && K >= 1) && (N <= Math.pow(10, 5) && K <= Math.pow(10, 5))) {

			for (int i = 0; i < K; i++) {
				sum += A.get(i);
			}
			ans = sum;
			for (int i = K; i < N; i++) {
				if (A.get(i) >= (-Math.pow(10, 5)) && A.get(i) <= Math.pow(10, 5)) {
					sum += A.get(i) - A.get(i-K);
				}
				
	            if (sum < ans) {
	            	resultIndex = (i - K + 1);
	            	ans = sum;
	            }
			}
		}
		return resultIndex;
	}


	public static void main(String[] args) {
		//List<Integer> integers = Arrays.asList(18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19); // 1
		List<Integer> integers = Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18); // 6
		
		//List<Integer> integers = Arrays.asList(3, 7, 90, 20, 10, 50, 40);
		
		//List<Integer> integers = Arrays.asList(20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11); // 9

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		SubarrayWithLeastAverage eq = new SubarrayWithLeastAverage();
		int result = eq.solve(inputArray, 6);
		System.out.println("Result:>>" + result);

	}

}
