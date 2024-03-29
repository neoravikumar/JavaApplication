package com.intermediate.arithmetic.combinatorics;

/*
 Compute nCr % p
Problem Description

Given three integers A, B and C, where A represents n, B represents r and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.



Problem Constraints
1 <= A <= 106
1 <= B <= A
A <= C <= 109+7


Input Format
The first argument given is the integer A ( = n).
The second argument given is the integer B ( = r).
The third argument given is the integer C ( = p).



Output Format
Return the value of nCr % p.



Example Input
Input 1:

 A = 5
 B = 2
 C = 13
Input 2:

 A = 6
 B = 2
 C = 13


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 nCr( n=5 and r=2) = 10.
 p=13. Therefore, nCr%p = 10.
 */
public class ComputenCrModP {
	
	public static void main(String[] args) {

		ComputenCrModP computenCrModP = new ComputenCrModP();
		int result = computenCrModP.solve(1, 1, 1);
		System.out.println(result);

	}

	public int solve(int A, int B, int C) {

		long numerator = 1; // n * (n-1) * ... * (n-k+1)
		for (int i = 0; i < B; i++) {
			numerator = (numerator * (A - i)) % C;
		}

		long denominator = 1; // B!
		for (int i = 1; i <= B; i++) {
			denominator = (denominator * i) % C;
		}

		return (int) ((numerator * modInverse(denominator, C)) % C);
	}

	long modInverse(long a, long p) {
		return solveForPower(a, p - 2, p);
	}

	public int solveForPower(long A, long power, long mod) {
		long ans = 1;
		long a = A;
		while (power > 0) {
			if (power % 2 == 0) {
				a = (a % mod * a % mod) % mod;
				power = power / 2;
			} else {
				ans = (ans % mod * a % mod) % mod;
				a = (a % mod * a % mod) % mod;
				power = (power - 1) / 2;
			}
		}
		return (int) (ans % mod);
	}
}
