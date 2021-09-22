package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Count ways to make sum of odd and even indexed elements equal by removing an
 * array element Problem Description
 * 
 * Given an array, arr[] of size N, the task is to find the count of array
 * indices such that removing an element from these indices makes the sum of
 * even-indexed and odd-indexed array elements equal.
 * 
 * 
 * 
 * Problem Constraints 1<=n<=1e5 -1e5<=A[i]<=1e5
 * 
 * 
 * Input Format First argument contains an array A of integers of size N
 * 
 * 
 * Output Format Return the count of array indices such that removing an element
 * from these indices makes the sum of even-indexed and odd-indexed array
 * elements equal.
 * 
 * 
 * 
 * Example Input Input 1: A=[2, 1, 6, 4] Input 2:
 * 
 * A=[1, 1, 1]
 * 
 * 
 * Example Output Output 1: 1 Output 2:
 * 
 * 3
 * 
 * 
 * Example Explanation Explanation 1: Removing arr[1] from the array modifies
 * arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. Therefore, the
 * required output is 1. Explanation 2:
 * 
 * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that
 * arr[0] = arr[1] Removing arr[1] from the given array modifies arr[] to { 1, 1
 * } such that arr[0] = arr[1] Removing arr[2] from the given array modifies
 * arr[] to { 1, 1 } such that arr[0] = arr[1] Therefore, the required output is
 * 3.
 *
 */
public class CountSumOddEvenIndexEqual {

	public int solve(ArrayList<Integer> A) {

		int N = null != A ? A.size() : 0;
		int ans = 0;
		if (N >= 1 && N <= Math.pow(10, 5)) {

			// Sum of all right even Number;
			int re = IntStream.range(0, N).filter(i -> i % 2 == 0).map(i -> A.get(i)).sum();
			// Sum of all right Odd Number;
			int ro = IntStream.range(0, N).filter(i -> i % 2 == 1).map(i -> A.get(i)).sum();
			
			int lo=0;
			int le=0;

			for (int i = 0; i < N; i++) {
				if (A.get(i) >= (-Math.pow(10, 5)) && A.get(i) <= Math.pow(10, 5)) {

					if (i % 2 != 0) {
						ro -= A.get(i);
					} else {
						re -= A.get(i);
					}
					
					if(lo+re == ro+le) {
						ans++;
					}
					
					if(i%2 !=0) {
						lo += A.get(i);
					}else {
						le += A.get(i);
					}

				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// List<Integer> integers = Arrays.asList(-7, 1, 5, 0, -4, 3, 2);
		List<Integer> integers = Arrays.asList(1,1,1);

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		CountSumOddEvenIndexEqual eq = new CountSumOddEvenIndexEqual();
		int result = eq.solve(inputArray);
		System.out.println("Result:>>" + result);

	}

}
