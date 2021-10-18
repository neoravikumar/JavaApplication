package com.intermediate.arrays;

import java.math.BigInteger;

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

	/*
	 * public int uniquePaths(int m, int n) {
	 * 
	 * 
	 * int[] columns = new int[n]; final int MOD = 1000003; columns[0] = 1; int
	 * result = 0; for (int i = 0; i < m; i++) { for (int j = 1; j < n; j++) {
	 * columns[j] = ((columns[j] % MOD ) + (columns[j - 1] % MOD)) % MOD; } } result
	 * = columns[n - 1] % MOD;
	 * 
	 * 
	 * int result = 0; final int MOD = (int) (Math.pow(10, 9)+7); if (m > 0 && n >
	 * 0) { int count[][] = new int[m][n]; for (int i = 0; i < m; i++) count[i][0] =
	 * 1; for (int j = 0; j < n; j++) count[0][j] = 1; for (int i = 1; i < m; i++) {
	 * for (int j = 1; j < n; j++) count[i][j] = (count[i - 1][j] % MOD + count[i][j
	 * - 1] % MOD) % MOD; }
	 * 
	 * result = count[m - 1][n - 1]; result = result % MOD; }
	 * 
	 * return result; }
	 */

	// Returns factorial of n
	final int MOD = 1000003;

	private long fact(int n) {
		BigInteger f = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			f = f.multiply(BigInteger.valueOf(i));
		}
		System.out.println(f);
		System.out.println("f.longValue()::>>"+f.longValue());
		if(f.longValue()>Long.MAX_VALUE) {
			return 1;
		}
		return f.longValue() % MOD;
	}

	public int uniquePaths(int m, int n) {

		/*
		 * int left = n + m - 2; int right = n - 1; if (right <= 0) right = 1; long
		 * result = 0;
		 * 
		 * long upbound = fact(left); long lowerbound = left - right; result = upbound /
		 * lowerbound;
		 */

		// m+n-2 C m-1 = (m+n-2)! / (n-1)! (m-1)! 
		
		int ans = 1;
	    for (int i = Math.max(n,m); i < (m + n - 1); i++) {
	        ans *= i;
	        ans /= (i - Math.max(n,m) + 1);
	    }
	    return ans;

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

		int abc = gridUniquePaths.uniquePaths(100, 1);
		System.out.println(abc);

	}

}
