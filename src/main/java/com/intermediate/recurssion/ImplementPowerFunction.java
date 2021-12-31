package com.intermediate.recurssion;

/*
 Implement Power Function
Problem Description

Implement pow(x, n) % d.
In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
 */
public class ImplementPowerFunction {

	public int pow(int A, int B, int C) {

		long pow = 1L;
		 
        while (B > 0)
        {
            if ((B & 1) == 1) {
                pow *= A;
            }
 
            B = B >> 1;
 
            A = A * A;
        }
 
        // return result
        return new Long(pow).intValue() % C;

	}

	public static void main(String[] args) {
		ImplementPowerFunction implementPowerFunction = new ImplementPowerFunction();
		int result = implementPowerFunction.pow(2, 3, 3);
		System.out.println(result);

	}

}
