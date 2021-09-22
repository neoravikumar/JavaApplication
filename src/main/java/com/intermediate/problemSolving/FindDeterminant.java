package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Determinant Problem Description
 * 
 * You are given an N X N(where N = 2 or N = 3) 2D integer matrix A. You have to
 * find the value of its determinant (det(A) or |A|).
 * 
 * image
 * 
 * image
 * 
 * 
 * 
 * Problem Constraints N = 2 or N = 3
 * 
 * -100 <= A[i][j] <= 100
 * 
 * 
 * 
 * Input Format First and only argument is a 2D integer matrix A.
 * 
 * 
 * 
 * Output Format Return an integer denoting the value of |A|.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [[1, 2], [3, 4]] Input 2:
 * 
 * A = [[6, 1, 1], [4, -2, 5], [2, 8, 7]]
 * 
 * 
 * Example Output Output 1:
 * 
 * -2 Output 2:
 * 
 * -306
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * |A| = 1 * 4 - 2 * 3 = 4 - 6 = -2 Explanation 2:
 * 
 * |A| = 6 * ((-2) * 7 - 5 * 8) - 1 * (4 * 7 - 5 * 2) + 1 * (4 * 8 - (-2) * 2) =
 * -306
 */
public class FindDeterminant {

	public int solve(final List<ArrayList<Integer>> A) {

		int N = null != A ? A.size() : 0;
		int result = 0;
		if (N == 2) {
			result = ((A.get(0).get(0) * A.get(1).get(1)) - (A.get(0).get(1) * A.get(1).get(0)));
		}

		if (N == 3) {

			int x = A.get(0).get(0) * ((A.get(1).get(1) * A.get(2).get(2)) - (A.get(1).get(2) * A.get(2).get(1)));
			int y = A.get(0).get(1) * ((A.get(1).get(0) * A.get(2).get(2)) - (A.get(2).get(0) * A.get(1).get(2)));
			int z = A.get(0).get(2) * ((A.get(1).get(0) * A.get(2).get(1)) - (A.get(2).get(0) * A.get(1).get(1)));

			result = x - y + z;

		}
		return result;
	}

	public static void main(String[] args) {

		List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

		//ArrayList<Integer> a1 = new ArrayList<Integer>();
		//a1.add(1);
		//a1.add(2);
		//ArrayList<Integer> a2 = new ArrayList<Integer>();
		//a2.add(3);
		//a2.add(4);

		//A.add(a1);
		//A.add(a2);
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(6);
		a1.add(1);
		a1.add(1);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(4);
		a2.add(-2);
		a2.add(5);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(2);
		a3.add(8);
		a3.add(7);
		
		A.add(a1);
		A.add(a2);
		A.add(a3);

		FindDeterminant findDeterminant = new FindDeterminant();
		int result = findDeterminant.solve(A);
		System.out.println("Result is :>" + result);

	}

}
