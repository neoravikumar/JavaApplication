package com.intermediate.searching;

/*
 Ath Magical Number
Problem Description

Given three positive integers A, B and C.

Any positive integer is magical if it is divisible by either B or C.

Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {
	
	
	int gcd(int x,int y){
	    int dividend=x>y?x:y;
	    int divisor=x>y?y:x;
	    while(divisor!=0){
	        int rem=dividend%divisor;
	        dividend=divisor;
	        divisor=rem;
	    }
	    return dividend;
	}

	public int solve(int n, int a, int b) {

		/*
		 * int MOD = 1000000007; int mula = 1, mulb = 1; while (true) { long numa = B *
		 * mula % MOD; long numb = C * mulb % MOD; long min = Math.min(numa, numb) %
		 * MOD;
		 * 
		 * A--; if (numa == numb) { mula++; mulb++; } else if (numa < numb) { mula++; }
		 * else { mulb++; } if (A == 0) { return (int) min % MOD; } }
		 */

		/*
		 * long A = a, B = b; long mod = 1000000007; long l = Math.min(a, b), r = (long)
		 * n * Math.min(a, b); while (B > 0) { long t = A; A = B; B = t % B; }
		 * 
		 * long lcm = (a * b) / A; while (l < r) { long mid = l + (r - l) / 2;
		 * 
		 * // if number of magical number till mid is smaller than n , // move right of
		 * mid if ((mid / a) + (mid / b) - (mid / lcm) < n) l = mid + 1; else r = mid; }
		 * return (int) (l % mod);
		 */
		
		
		long A = a, B = b;
        long mod = (long)(Math.pow(10,9)+7);
        
        
        long left = Math.min(a,b), right = (long)n*Math.min(a,b);
        
        // Finding GCD
        while (B > 0) {
            long tmp = A;
            A = B;
            B = tmp % B;
        }
		
        long lcm = (a*b)/A;     
        
        while (left < right) {
            long m = left+(right-left)/2;
			
            if ((m / a) + (m / b) - (m / lcm) < n) left = m + 1;   
			
            else right = m;
        }
        return (int)(left % mod);

	}

	public static void main(String[] args) {
		AthMagicalNumber amagical = new AthMagicalNumber();
		int result = amagical.solve(19,11,13);
		// correct answer is 117
		System.out.println(result);
	}

}
