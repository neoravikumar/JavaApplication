package com.intermediate.recurssion;

/*Implement Power Function
Problem Description

Implement pow(x, n) % d.
In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.*/
public class ImplementPowerFuntion {
	
	// 2^4 - base is 2 and exponent is 4 result would be 16
		long fastPower(int base, int exponent, int modulo) {
			
			if(exponent==0) {
				return 1;
			}
			long resultHalfByExponent = fastPower(base, exponent/2, modulo);
			
			if(resultHalfByExponent % 2 == 1) {
				// Odd number so in this 
				return (base % modulo * resultHalfByExponent % modulo * resultHalfByExponent % modulo) % modulo;
			}else {
				// Even number 
				return (resultHalfByExponent % modulo* resultHalfByExponent % modulo)% modulo;
			}
		}
		
		
		/*
		 * public int pow(int A, int B, int C) {
		 * 
		 * if(C==1) return 0;
		 * 
		 * long ans = fastPower(A, B, C);
		 * 
		 * if(ans<0){ ans=(C-Math.abs(ans%C)); return new Long(ans).intValue(); } return
		 * new Long(ans).intValue() % C;
		 * 
		 * }
		 */
		
	public int pow(int A, int B, int C) {
		
		 if(C==1) return 0;
		    long ans=1,y=A%C;
		    while(B>0){
		        if((B&1) == 1)
		         ans=((ans)*y)%C;
		        y=(y*y)%C;
		        if(y<0) y+=C;
		        B=B>>1;
		    }
		    if(ans<0){
		        ans=(C-Math.abs(ans)%C);
		        return new Long(ans).intValue();
		    }
		    return new Long(ans).intValue()%C;
	}

	public static void main(String[] args) {
		System.out.println(new ImplementPowerFuntion().pow(71045970, 41535484, 64735492));

	}

}
