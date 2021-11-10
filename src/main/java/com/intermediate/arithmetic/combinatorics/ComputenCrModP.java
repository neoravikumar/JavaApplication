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

	public int solve(int n, int r, int p) {

		return nCrModpLucas(n, r, p);
	}
	
	private int nCrModpDP(int n, int r, int p)
	{
	    // The array C is going to store last row of
	    // pascal triangle at the end. And last entry
	    // of last row is nCr
	    int[] C=new int[r+1];
	 
	    C[0] = 1; // Top row of Pascal Triangle
	 
	    // One by constructs remaining rows of Pascal
	    // Triangle from top to bottom
	    for (int i = 1; i <= n; i++)
	    {
	        // Fill entries of current row using previous
	        // row values
	        for (int j = Math.min(i, r); j > 0; j--)
	 
	            // nCj = (n-1)Cj + (n-1)C(j-1);
	            C[j] = (C[j] + C[j-1])%p;
	    }
	    return C[r];
	}
	 
	// Lucas Theorem based function that returns nCr % p
	// This function works like decimal to binary conversion
	// recursive function. First we compute last digits of
	// n and r in base p, then recur for remaining digits
	private int nCrModpLucas(int n, int r, int p)
	{
	// Base case
	if (r==0)
	    return 1;
	 
	// Compute last digits of n and r in base p
	int ni = n%p;
	int ri = r%p;
	 
	// Compute result for last digits computed above, and
	// for remaining digits. Multiply the two results and
	// compute the result of multiplication in modulo p.
	return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r
	        nCrModpDP(ni, ri, p)) % p; // Remaining digits
	}

	

	public static void main(String[] args) {

		ComputenCrModP computenCrModP = new ComputenCrModP();
		int result = computenCrModP.solve(1,1,1);
		System.out.println(result);

	}

}
