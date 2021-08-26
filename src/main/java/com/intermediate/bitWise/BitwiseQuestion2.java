package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.List;

/*Number of 1 Bits
Problem Description

Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input1:
    11


Example Output
Output1:
3


Example Explanation
Explaination1:
11 is represented as 1101 in binary */

public class BitwiseQuestion2 {

	public int numSetBits(int A) {
		int result = 0;
		if (A >= 1 && A <= Math.pow(10, 9)) {

			List<Integer> binaryList = new ArrayList<Integer>();
			while (A > 0) {
				binaryList.add(A % 2);
				A = A / 2;
			}
			for (Integer k : binaryList) {
				if (k == 1) {
					result++;
				}
			}
		}

		return result;
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	/*
	 * public int singleNumber(final List<Integer> A) { int x = 0; if (null != A &&
	 * (A.size() >= 2 && A.size() <= 2000000)) {
	 * 
	 * for (int j = 0; j < A.size(); j++) { int newValue = (Integer) A.get(j); x = x
	 * ^ newValue; } } else if(A.size()==1) { return A.get(0); } return x; }
	 */

	public static void main(String[] args) {
		BitwiseQuestion2 bitwiseQuestion1 = new BitwiseQuestion2();

		System.out.println(bitwiseQuestion1.numSetBits(450676354));

	}

}
