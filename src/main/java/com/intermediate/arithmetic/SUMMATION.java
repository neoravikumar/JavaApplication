package com.intermediate.arithmetic;

/*
SUMMATION
Problem Description

Given an integer A.

Calculate the sum = (ACr) * (r) * (r - 1) * (2r-2) for all r from 0 to A.

Return sum % 109 + 7.



Problem Constraints
2 <= A <= 106



Input Format
The first and only argument given is the integer A.



Output Format
Return a single integer denoting sum % 109 + 7.



Example Input
Input 1:

 A = 3
Input 2:

 A = 4


Example Output
Output 1:

 18
Output 2:

 108


Example Explanation
Explaination 1:

 (ACr) * (r) * (r - 1) * (2r-2)
 r = 0, (1) * (0) * (1) * (1/4) = 0
 r = 1, (3) * (1) * (0) * (1/2) = 0
 r = 2, (3) * (2) * (1) * (1) = 6
 r = 3, (1) * (3) * (2) * (2) = 12
 sum = 18
*/
public class SUMMATION {

	long MOD = (long) (Math.pow(10, 9) + 7);

	public int solve(int A) {

		long a = (A * (A - 1)) % MOD;
		// long power = ((long)(Math.pow(3,A-2))%MOD);
		long power = power(3, A - 2);
		long data = (a * power) % MOD;
		return new Long(data).intValue();

	}

	private long power(int x, int n) {
		// base condition
		if (n == 0) {
			return 1L;
		}

		// calculate subproblem recursively
		long pow = power(x, n / 2);

		if ((n & 1) == 1) { // if `y` is odd
			return (x * pow * pow) % MOD;
		}

		// otherwise, `y` is even
		return (pow * pow) % MOD;
	}

	public static void main(String[] args) {
		int summation = new SUMMATION().solve(39);
		// 212884953
		System.out.println(summation);

	}

}
