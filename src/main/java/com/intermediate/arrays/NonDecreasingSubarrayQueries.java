package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Non decreasing subarray queries
Problem Description

Given an array A of size N. You will be given M queries to process. Each query will be of the form B[i][0] B[i][1].

If the subarray from B[i][0] to B[i][1] is non decreasing, the output should be 1 else output should be 0.

Return an array of integers answering each query.


Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109

1 <= M <= 105

1 <= B[i][0], B[i][1] <= N


Input Format
First argument contains the array A.

Second argument contains B, denoting the queries.


Output Format
Return an array of integers consisting of 0 and 1


Example Input
Input :
A = [1, 7, 3, 4, 9]
B = [ 
      [1, 2], 
      [2, 4]
    ]


Example Output
Input :
[1, 0]


Example Explanation
Explanation :
Query 1: The subarray in the range [1, 2] is {1, 7} which is non-decreasing. Therefore, ans = 1
Query 2: The subarray in the range [2, 4] is {7, 3, 4, 9} which is not non-decreasing. Therefore, ans = 0
 */
public class NonDecreasingSubarrayQueries {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < B.size(); i++) {
			ArrayList<Integer> subList = B.get(i);
			int start = subList.get(0) - 1;
			int end = subList.get(1) - 1;
			int resultBit = 1;
			int temp = A.get(start);

			for (int j = start; j <= end; j++) {
				if (!(A.get(j) >= temp)) {
					resultBit = 0;
					break;
				}
				temp = A.get(j);
			}

			result.add(resultBit);

		}

		return result;
	}

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7, 7, 1, 6, 9));

		// 0 1 1 1 0

		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 3));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(4, 5));
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(1, 2));
		ArrayList<Integer> a4 = new ArrayList<Integer>(Arrays.asList(3, 4));
		ArrayList<Integer> a5 = new ArrayList<Integer>(Arrays.asList(1, 5));

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		blist.add(a3);
		blist.add(a4);
		blist.add(a5);

		NonDecreasingSubarrayQueries eq = new NonDecreasingSubarrayQueries();
		List<Integer> result = eq.solve(A, blist);
		System.out.println("Result:>>" + result);

	}

}
