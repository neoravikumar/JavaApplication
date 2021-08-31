package com.intermediate.arrays;

import java.util.Arrays;

public class TwoDimensionArray {
	
	public int solve(int[][] A, int B) {

		// Row Wise Traverse
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]+" ");
			}
		}
		
		System.out.println();

		// Column Wise Traverse
		for (int i = 0; i <  A[0].length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.print(A[j][i]+" ");
			}
		}
		
		System.out.println(Arrays.deepToString(A));
		
		Arrays.
		

		return B;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		TwoDimensionArray searchInArowWiseAndColumn = new TwoDimensionArray();

		searchInArowWiseAndColumn.solve(arr, 8);

	}

}
