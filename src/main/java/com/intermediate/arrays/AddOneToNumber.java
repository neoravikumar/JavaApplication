package com.intermediate.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Add One To Number
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:
 
Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.*/
public class AddOneToNumber {

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		final int N = null != A ? A.size() : null;
		if (N >= 1 && N <= 1000000) {

			/*
			 * for(int i=0; i<N;i++) { result += String.valueOf(A.get(i)); }
			 * 
			 * BigInteger bit = new Big BigInteger big1 = new BigInteger(result); BigInteger
			 * big2 = new BigInteger("1"); BigInteger resultInt = big1.add(big2);
			 * 
			 * 
			 * result = resultInt.toString();
			 * 
			 * for(char r : result.toCharArray()) { resultList.add(r - '0'); }
			 * resultList.forEach(a -> System.out.print(a + " "));
			 */
			int i = 0;
			while (i <= A.size() - 1 && A.get(i) == 0) {
				A.remove(i);
			}
			int carry = 1;
			for (i = A.size() - 1; i >= 0; i--) {
				int tmp = A.get(i) + carry;
				if (tmp > 9) {
					A.set(i, tmp % 10);
					carry = 1;
				} else {
					A.set(i, tmp);
					carry = 0;
					break;
				}
			}
			if (carry > 0) {
				A.add(0, carry);
			}
			//A.forEach(a -> System.out.print(a + " "));
		}

		return A;
	}

	public static void main(String[] args) {

		AddOneToNumber mpAndNext = new AddOneToNumber();
		//List<Integer> arrays = Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9);
		List<Integer> arrays = Arrays.asList(0);
		// List<Integer> arrays = Arrays.asList( 0 );
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.addAll(arrays);
		mpAndNext.plusOne(myList);

	}

}
