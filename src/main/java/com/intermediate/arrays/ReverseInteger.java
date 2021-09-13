package com.intermediate.arrays;

/*
 Reverse integer
Problem Description

You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer

Look at the example for clarification.



Problem Constraints
N belongs to the Integer limits.



Input Format
Input an Integer.



Output Format
Return a single integer denoting the reverse of the given integer.



Example Input
Input 1:

 x = 123

Input 2:

 x = -123


Example Output
Output 1:

 321

Ouput 2:

 -321


Example Explanation
 If the given integer is negative like -123 the output is also negative -321.
 */
public class ReverseInteger {

	public int reverse(int A) {
		
		int result = 0, remainder = 0, prev_rev_num = 0;
		boolean negativeFlag = false;

		if (A < 0) {
			negativeFlag = true;
			A = -A;
		}

		if (A > Integer.MIN_VALUE && A < Integer.MAX_VALUE) {
			while (A != 0) {
				remainder = A % 10;
				int abc = result * 10;
				result = abc + remainder;
				
				 if ((result - remainder)/10 != prev_rev_num)
		            {
		                return 0;
		            }
		      
		            prev_rev_num = result;
				
				A = A / 10;
			}
		}
		Long a = new Long(result);
		if(negativeFlag) {
			a = -a;
		}
		return a.intValue();
	}

	public static void main(String[] args) {

		ReverseInteger reverseInteger = new ReverseInteger();
		int result = reverseInteger.reverse(-1234567891);
		System.out.println(result);

	}

}
