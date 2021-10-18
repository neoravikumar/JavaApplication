package com.intermediate.basic;

import java.util.ArrayList;

/*Kth Row of Pascal's Triangle
Problem Description

Given an index k, return the kth row of the Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
Note: k is 0 based. k = 0, corresponds to the row [1].

Note: Could you optimize your algorithm to use only O(k) extra space?*/
public class KthRowInPascalTraingle {

	public ArrayList<Integer> solve(int A) {

		ArrayList<Integer> row = new ArrayList<Integer>();
		int prev=1;
		row.add(prev);
		for(int i = 1; i <= A; i++)
	    {
	         
	       // nCr = (nCr-1 * (n - r + 1))/r
	       int curr = (prev * (A - i + 1)) / i;
	       row.add(curr);
	       prev = curr;
	    }
		return row;
	}
	

	public static void main(String[] args) {
		KthRowInPascalTraingle pascal = new KthRowInPascalTraingle();
		pascal.solve(3);

	}

}
