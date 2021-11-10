package com.intermediate.arithmetic;

/*Very Large Power
Problem Description

Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power ,

"%" means "mod", and

"!" means factorial.



Problem Constraints
1 <= A, B <= 5e5



Input Format
First argument is the integer A

Second argument is the integer B



Output Format
Return one integer, the answer to the problem



Example Input
Input 1:

A = 1
B = 1
Input 2:

A = 2
B = 2


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

 1! = 1. Hence 1^1 = 1.
Explanation 2:

 2! = 2. Hence 2^2 = 4.*/
public class VeryLargePower {

	long MOD = (long) (Math.pow(10, 9) + 7);

	public int solve(int A, int B) {
		long factorial = findFactorial(B);
		long result = pow(A, new Long(factorial).intValue(), (int) MOD);
		return (int) (result % MOD);
	}

	private long findFactorial(int k) {
		long f = 1;
		for (int i = 1; i <= k; i++)
			f = (f * i) % MOD-1;
		return f;
	}
	
	public int pow(int x, int n, int d) {

	    long ans;
	    if(x==0) return 0;
	    if(n==0) return 1;
	    if(x<0)  return pow(d+x,n,d);
	    
	    long temp = pow(x,n/2,d);
	    if(n%2==0)
	        ans = ((temp%d)*(temp%d))%d;
	    else
	        ans = ((((x%d)*(temp%d))%d)*(temp%d))%d;
	    
	    return (int)ans%d;

	    }

	public static void main(String[] args) {
		VeryLargePower veryLargePower = new VeryLargePower();
		long result = veryLargePower.solve(2, 27);
		System.out.println("Result is:" + result);
	}

}
