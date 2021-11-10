package com.intermediate.arithmetic;

/*
 Prime Modulo Inverse
Problem Description

Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.

A-1 mod B is also known as modular multiplicative inverse of A under modulo B.



Problem Constraints
1 <= A <= 109
1<= B <= 109
B is a prime number



Input Format
First argument is an integer A.
Second argument is an integer B.



Output Format
Return an integer denoting the modulor inverse



Example Input
Input 1:

 A = 3
 B = 5
Input 2:

 A = 6
 B = 23


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 Let's say A-1 mod B = X, then (A * X) % B = 1.
 3 * 2 = 6, 6 % 5 = 1.
Explanation 2:

 Similarly, (6 * 4) % 23 = 1.
 */
public class PrimeModuloInverse {

	public int solve(int A, int B) {
		return power(A, B - 2, B);
	}

	private int power(int x, int y, int m) {
		if (y == 0)
			return 1;
		int p = power(x, y / 2, m) % m;
		p = (int) ((p * (long) p) % m);
		if (y % 2 == 0)
			return p;
		else
			return (int) ((x * (long) p) % m);
	}

	public static void main(String[] args) {
		PrimeModuloInverse primeModuloInverse = new PrimeModuloInverse();
		int result = primeModuloInverse.solve(3, 11);
		System.out.println(result);
	}

}
