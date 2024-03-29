package com.intermediate.problemSolving;

import java.util.Arrays;
import java.util.List;

/**
 * Pick from both sides! Problem Description
 * 
 * Given an integer array A of size N.
 * 
 * You can pick B elements from either left or right end of the array A to get
 * maximum sum.
 * 
 * Find and return this maximum possible sum.
 * 
 * NOTE: Suppose B = 4 and array A contains 10 elements then
 * 
 * You can pick first four elements or can pick last four elements or can pick 1
 * from front and 3 from back etc . you need to return the maximum possible sum
 * of elements you can pick.
 * 
 * 
 * Problem Constraints 1 <= N <= 105
 * 
 * 1 <= B <= N
 * 
 * -103 <= A[i] <= 103
 * 
 * 
 * 
 * Input Format First argument is an integer array A.
 * 
 * Second argument is an integer B.
 * 
 * 
 * 
 * Output Format Return an integer denoting the maximum possible sum of elements
 * you picked.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [5, -2, 3 , 1, 2] B = 3 Input 2:
 * 
 * A = [1, 2] B = 1
 * 
 * 
 * Example Output Output 1:
 * 
 * 8 Output 2:
 * 
 * 2
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 =
 * 8 Explanation 2:
 * 
 * Pick element 2 from end as this is the maximum we can get
 */
public class PickFromBothSides {

	public static int solve(List<Integer> A, int B) {

		int n = A.size();

		int result = 0;

		for (int i = 0; i < B; i++) {
			result += A.get(i);
		}

		int sum = result;

		for (int i = 0; i < B; i++) {
			sum -= A.get(B - 1 - i);
			sum += A.get(n - 1 - i);

			result = Math.max(result, sum);
		}

		return result;

	}

	public static void main(String[] args) {
		Integer[] arr = { 5, -2, 3, 1, 2 };
		System.out.println(solve(Arrays.asList(arr), 3));

	}

}
