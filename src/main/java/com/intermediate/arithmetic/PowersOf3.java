package com.intermediate.arithmetic;

import java.util.ArrayList;

/*
 Powers of 3
Problem Description

Given a positive integer A. Return an array of minimum length whose elements represent the powers of 3 and the sum of all the elements is equal to A.



Problem Constraints
1 <= A <= 109



Input Format
Single argument is an integer A.



Output Format
Return an array of minimum length of powers of 3 whose elements sums to A.



Example Input
Input 1:

 13
Input 2:

 3


Example Output
Output 1:

 [1, 3, 9]
Output 2:

 [3]


Example Explanation
Explanation 1:

 30 = 1, 31 = 3, 32 = 9.
 Also, 1 + 3 + 9 = 13. Here A = 13 which can be represented as the sum of 1, 3 and 9.
 */
public class PowersOf3 {

	public ArrayList<Integer> solve(int A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int index = 0;
		while(A >=1) {
			int remainder= A%3;
			if(remainder>0) {
				if(remainder>1) {
					for(int k=0;k<remainder;k++) {
						int value = (int) Math.pow(3, index);
						result.add(value);
					}
				}else {
					int value = (int) Math.pow(3, index);
					result.add(value);
				}
				
			}
			A=A/3;
			index++;
		}
		return result;
	}

	public static void main(String[] args) {

		PowersOf3 powersOf3 = new PowersOf3();
		ArrayList<Integer> result = powersOf3.solve(13);
		System.out.println(result);
	}

}
