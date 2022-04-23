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
public class ComputenCrModP2 {

	public int solve(int A, int B, int C) {

		long numerator = 1; // n * (n-1) * ... * (n-k+1)
        for (int i=0; i<B; i++) {
            numerator = (numerator * (A-i) ) % C;
        }

        long denominator = 1; // B!
        for (int i=1; i<=B; i++) {
            denominator = (denominator * i) % C;
        }

        return (int) (( numerator* modInverse(denominator,C) ) % C);
	}
	
	
	long modInverse(long a, long p) {
        return pow(a, p-2, p);
    }
	


	long pow(long a, long b, long MOD)
	{
	    long x=1,y=a; 
	    while(b > 0)
	    {
	        if(b%2 == 1)
	        {
	            x=(x*y);
	            if(x>MOD) x%=MOD;
	        }
	        y = (y*y);
	        if(y>MOD) y%=MOD; 
	        b /= 2;
	    }
	    return x;
	}
	
	
	public static void main(String[] args) {

		ComputenCrModP2 computenCrModP = new ComputenCrModP2();
		int result = computenCrModP.solve(6,2,13);
		System.out.println(result);

	}

}
