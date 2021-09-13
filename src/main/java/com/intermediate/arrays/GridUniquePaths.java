package com.intermediate.arrays;

/*Grid Unique Paths
Problem Description

A robot is located at the top-left corner of an A x B grid (marked 'Start' in the diagram below).



The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



Problem Constraints
A and B will be such that the resulting answer fits in a 32 bit signed integer.



Input Format
First argument of input will be single integer A.
Second argument of input will be single integer B.



Output Format
Return a single integer denoting the number of unique paths.



Example Input
 A = 2, B = 2


Example Output
 2


Example Explanation
 2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1) */
public class GridUniquePaths {

	public int uniquePaths(int m, int n) {

		/*
		 * int[] columns = new int[n]; final int MOD = 1000003; columns[0] = 1; int
		 * result = 0; for (int i = 0; i < m; i++) { for (int j = 1; j < n; j++) {
		 * columns[j] = ((columns[j] % MOD ) + (columns[j - 1] % MOD)) % MOD; } } result
		 * = columns[n - 1] % MOD;
		 */

		int result = 0;
		final int MOD = (int) (Math.pow(10, 9)+7);
		if (m > 0 && n > 0) {
			int count[][] = new int[m][n];
			for (int i = 0; i < m; i++)
				count[i][0] = 1;
			for (int j = 0; j < n; j++)
				count[0][j] = 1;
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++)
					count[i][j] = (count[i - 1][j] % MOD + count[i][j - 1] % MOD) % MOD;
			}

			result = count[m - 1][n - 1];
			result = result % MOD;
		}

		return result;
	}

	/*
	 * public int uniquePaths(int m, int n) {
	 * 
	 * int[] columns = new int[n]; final int MOD = 1000003; columns[0] = 1; int
	 * result = 0; for (int i = 0; i < m; i++) { for (int j = 1; j < n; j++) {
	 * columns[j] = ((columns[j] % MOD) + (columns[j - 1] % MOD)) % MOD; } } result
	 * = columns[n - 1] % MOD; return result; }
	 */

	public static void main(String[] args) {
		GridUniquePaths gridUniquePaths = new GridUniquePaths();

		int abc = gridUniquePaths.uniquePaths(15, 12);
		System.out.println(abc);

	}

}
