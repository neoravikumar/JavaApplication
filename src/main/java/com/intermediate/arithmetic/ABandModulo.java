package com.intermediate.arithmetic;

/*
 A, B and Modulo
Problem Description

Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.



Problem Constraints
1 <= A, B <= 109
A != B



Input Format
The first argument given is the integer, A.
The second argument given is the integer, B.



Output Format
Return an integer denoting greatest possible positive M.



Example Input
Input 1:

A = 1
B = 2
Input 2:

A = 5
B = 10


Example Output
Output 1:

1
Output 2:

5


Example Explanation
Explanation 1:

1 is the largest value of M such that A % M == B % M.
Explanation 2:

For M = 5, A % M = 0 and B % M = 0.

No value greater than M = 5, satisfies the condition.
 */
public class ABandModulo {

	public int solve(int A, int B) {

		/*
		 * Brute Force Approach 
		 * int result = 1; int max = 0; if (A > B) { max = A; }
		 * else { max = B; }
		 * 
		 * for(int i=max;i>1;i--) {
		 * 
		 * if(A % i == B % i) { return i; } } return result;
		 */
		// Optimal Approach
		int result = Math.abs(A-B);
		return result;

	}

	public static void main(String[] args) {
		ABandModulo aBandModulo = new ABandModulo();
		int result = aBandModulo.solve(106978, 4487506);
		// int result = aBandModulo.solve(5,23);
		System.out.println(result);

	}

}
