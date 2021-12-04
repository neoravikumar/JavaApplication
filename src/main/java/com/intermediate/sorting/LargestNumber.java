package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Largest Number
Problem Description

Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
First argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320. 
 */
public class LargestNumber {
	
	public String largestNumber(final List<Integer> A) {
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<A.size();i++) {
			for(int k=i;k<A.size();k++) {
				System.out.print(A.subList(i, k+1)+"\t");
			}
			System.out.println();
		}
		
		return null;
    }
	
	public static void main(String[] args) {
		
		LargestNumber ln = new LargestNumber();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));

		String result = ln.largestNumber(A);
		System.out.println(result);
	}

}
