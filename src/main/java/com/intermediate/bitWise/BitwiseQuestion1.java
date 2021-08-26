package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Single Number
Problem Description

Given an array of integers A, every element appears twice except for one. Find that single one.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



Problem Constraints
2 <= |A| <= 2000000

0 <= A[i] <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting the single element.



Example Input
Input 1:

 A = [1, 2, 2, 3, 1]
Input 2:

 A = [1, 2, 2]


Example Output
Output 1:

 3
Output 2:

 1*/

public class BitwiseQuestion1 {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int singleNumber(final List<Integer> A) {
		int x = 0;
		if (null != A && (A.size() >= 2 && A.size() <= 2000000)) {
			
			for (int j = 0; j < A.size(); j++) {
				int newValue = (Integer) A.get(j);
				x = x ^ newValue;
			}
		}
		else if(A.size()==1) {
			return A.get(0);
		}
		return x;
	}

	public static void main(String[] args) {
		BitwiseQuestion1 BitwiseQuestion1 = new BitwiseQuestion1();

		// List<Integer> lst = Arrays.asList(913, 440, 865, 72, 612, 445, 101, 994, 356,
		//91, 461, 930, 583, 448, 543, 170, 333, 107, 425, 73, 172, 416, 899, 826, 659, 561, 314, 25, 110 );
		//List<Integer> lst = Arrays.asList(1, 2, 3, 2, 1);
		
		//List<Integer> lst = Arrays.asList(1, 2, 3, 2, 3, 4, 89, 4, 5, 1,5);
		
		List<Integer> lst = Arrays.asList(1);

		List<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(BitwiseQuestion1.singleNumber(abc));
	}

}
