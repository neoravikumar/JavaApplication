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

		if (r == 0)
			return 1;
		int ni = n % p;
		int ri = r % p;

		return (solve(n / p, r / p, p) * // Last digits of n and r
				nCrModpLucas(ni, ri, p)) % p;
	}
	
	
	long C(int n, int r, int MOD)
	{
	    long res = 1;
	    vector<bool> isPrime(n+1,1);
	    for (int i=2; i<=n; i++)
	        if (isPrime[i])
	        {
	            for (int j=2*i; j<=n; j+=i)
	                isPrime[j]=0;
	            int k = countFact(n,i) - countFact(r,i) - countFact(n-r,i);  
	            res = (res * pow(i, k, MOD)) % MOD;
	        }
	    return res;
	}
	

	int countFact(int n, int p) {
		int k = 0;
		while (n > 0) {
			k += n / p;
			n /= p;
		}
		return k;
	}

	long pow(int a, int b, int MOD)
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

		ComputenCrModP computenCrModP = new ComputenCrModP();
		int result = computenCrModP.solve(1, 1, 1);
		System.out.println(result);

	}

}
