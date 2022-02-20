package com.intermediate.recurssion;


/*
 Unique Paths III
Problem Description

Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example Input
Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:

Answer is evident here.
 */

public class UniquePathsIII {

	int[] row = { 0, 0, 1, -1 };
	int col[] = { 1, -1, 0, 0 };

	public int isSafe(int[][] grid, int rows, int cols, int i, int j) {

		if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == -1)
			return 0;

		if (grid[i][j] == 2) {
			for (int l = 0; l < rows; l++) {
				for (int m = 0; m < cols; m++) {
					if (grid[l][m] == 0) {
						return 0;
					}
				}
			}
			return 1;
		}
		grid[i][j] = -1;
		int result = 0;
		for (int k = 0; k < 4; k++)
			result = result + isSafe(grid, rows, cols, (i + row[k]), (j + col[k]));

		grid[i][j] = 0;
		return result;

	}

	public int solve(int[][] A) {

		int rows = A.length;
		int cols = A[0].length;

		int result = 0;
		for (int k = 0; k < rows; k++) {
			for (int m = 0; m < cols; m++) {
				if (A[k][m] == 1) {
					result = isSafe(A, rows, cols, k, m);
					break;
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		UniquePathsIII uniqIii = new UniquePathsIII();
		
		int A[][] = {{1, 0, 0, 0},{0, 0, 0, 0},{0, 0, 2, -1}} ;//   [1, 0, 0, 0] , [0, 0, 0, 0] ,[0, 0, 2, -1]   ];
		
		int result = uniqIii.solve(A);
		System.out.println(result);

	}

}
