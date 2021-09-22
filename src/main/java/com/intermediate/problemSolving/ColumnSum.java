package com.intermediate.problemSolving;

import java.util.ArrayList;

/**
 * Column Sum Problem Description
 * 
 * You are given a 2D integer matrix A, return a 1D integer vector containing
 * column-wise sums of original matrix.
 * 
 * 
 * 
 * Problem Constraints 1 <= A.size() <= 103
 * 
 * 1 <= A[i].size() <= 103
 * 
 * 1 <= A[i][j] <= 103
 * 
 * 
 * 
 * Input Format First argument is a vector of vector of integers.(2D matrix).
 * 
 * 
 * 
 * Output Format Return a vector conatining column-wise sums of original matrix.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * [1,2,3,4] [5,6,7,8] [9,2,3,4]
 * 
 * 
 * Example Output Output 1:
 * 
 * {15,10,13,16}
 * 
 * 
 * Example Explanation Explanation 1
 * 
 * Column 1 = 1+5+9 = 15 Column 2 = 2+6+2 = 10 Column 3 = 3+7+3 = 13 Column 4 =
 * 4+8+4 = 16
 */
public class ColumnSum {

	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

		ArrayList<Integer> input = new ArrayList<Integer>();
		
		int N = null != A ? A.size() : 0;
		
		int sum = 0 ;
		
	    for (int i = 0; i < A.get(0).size(); i++)
	    {
	    	sum  =0 ;
	        for (int j = 0; j < N; j++)
	        {
	        sum += A.get(j).get(i);
	        }
	        input.add(sum);
	    }
		
		return input;

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(5);
		a2.add(6);
		a2.add(7);
		a2.add(8);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(9);
		a3.add(2);
		a3.add(3);
		a3.add(4);

		A.add(a1);
		A.add(a2);
		A.add(a3);

		ColumnSum columnSum = new ColumnSum();
		ArrayList<Integer> result = columnSum.solve(A);
		System.out.println("Result is :>" + result);
	}

}
