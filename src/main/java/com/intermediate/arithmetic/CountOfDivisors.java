package com.intermediate.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: Order of the resultant array should be same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format
The only argument given is the integer array A.



Output Format
Return the count of divisors of each element of the array in the form of an array.



Example Input
Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output
Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
 */
public class CountOfDivisors {

	private int countFactors(int A) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(A); i++) {
			if (A % i == 0) { 
	            if (A / i == i) 
	            	count++; 
	            else 
	            	count = count + 2; 
	        } 
		}
		return count;
	}
	
	

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<A.size();i++) {
			result.add(countFactors(A.get(i)));
		}
		return result;
	}

	public static void main(String[] args) {
		CountOfDivisors countOfDivisors = new CountOfDivisors();

		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 9, 10));
		ArrayList<Integer> result = countOfDivisors.solve(A);
		System.out.println("Result:>>" + result);
	}

}
