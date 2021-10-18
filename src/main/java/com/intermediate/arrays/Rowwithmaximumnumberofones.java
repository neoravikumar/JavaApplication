package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.intermediate.problemSolving.XorQueries2;

/**
 * Row with maximum number of ones Problem Description
 * 
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum
 * number of 1.
 * 
 * NOTE:
 * 
 * If two rows have the maximum number of 1 then return the row which has a
 * lower index. Rows are numbered from top to bottom and columns are numbered
 * from left to right. Assume 0-based indexing. Assume each row to be sorted by
 * values. Expected time complexity is O(rows).
 * 
 * 
 * Problem Constraints 1 <= N <= 1000
 * 
 * 0 <= A[i] <= 1
 * 
 * 
 * 
 * Input Format The only argument given is the integer matrix A.
 * 
 * 
 * 
 * Output Format Return the row with the maximum number of 1.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [ [0, 1, 1] [0, 0, 1] [0, 1, 1] ] Input 2:
 * 
 * A = [ [0, 0, 0, 0] [0, 1, 1, 1] ]
 * 
 * 
 * Example Output Output 1:
 * 
 * 0 Output 2:
 * 
 * 1
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Row 0 has maximum number of 1s. Explanation 2:
 * 
 * Row 1 has maximum number of 1s.
 */
public class Rowwithmaximumnumberofones {

	public int solve(ArrayList<ArrayList<Integer>> A) {

		int N = null != A ? A.size() : 0;
		int lastSum = 0, finalIndex = 0;
		if (N >= 1 && N <= 1000) {
			for (int i = 0; i < A.size(); i++) {
				ArrayList<Integer> Aa = A.get(i);
				int sum = 0;
				for (int a : Aa) {
					sum += a;
				}
				if (sum > lastSum) {
					finalIndex = i;
				}
				lastSum = Math.max(lastSum, sum);
			}
		}
		return finalIndex;
	}

	public static void main(String[] args) {

		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));

		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1));

		// ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		// blist.add(a3);

		Rowwithmaximumnumberofones eq = new Rowwithmaximumnumberofones();
		int result = eq.solve(blist);
		System.out.println("Result:>>" + result);

	}

}
