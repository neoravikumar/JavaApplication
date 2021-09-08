package com.intermediate.recurssion;

/*
 Sum of Digits!
Problem Description

Given a number A, we need to find sum of its digits using recursion.



Problem Constraints
1 <= A <= 10^9



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the sum of digits of the number A.



Example Input
Input 1:

 A = 46
Input 2:

 A = 11


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 Sum of digits of 46 = 4 + 6 = 10
Explanation 2:

 Sum of digits of 11 = 1 + 1 = 2
 */
public class SumOfDigits {

	public int solve(int A) {
		if (A >= 1 && A <= Math.pow(10, 9)) {
			if(A==0) {
				return 0;
			}
			return A%10+solve(A/10);
		}
		return 0;
	}


	public static void main(String[] args) {
		SumOfDigits sumOfDigits = new SumOfDigits();
		int result = sumOfDigits.solve(11);
		System.out.println(result);

	}

}
