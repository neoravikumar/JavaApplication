package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Primal Power
Problem Description

"Primal Power" of an array is defined as the count of prime numbers present in it.

Given an array of integers A of length N, you have to calculate its Primal Power.



Problem Constraints
1 <= N <= 103

-10^6 <= A[i] <= 10^6



Input Format
First and only argument is an integer array A.



Output Format
Return the Primal Power of array A.



Example Input
Input 1:

 A = [-6, 10, 12]
Input 2:

 A = [-11, 7, 8, 9, 10, 11]


Example Output
Output 1:

 0
Output 2:

 2


Example Explanation
Explanation 1:

 -6 is not a prime number, as prime numbers are always natural numbers(by definition). 
  Also, both 10 and 12 are composite numbers.
Explanation 2:

 7 and 11 are prime numbers. Hence, Primal Power = 2.*/
public class PrimalPower {

	public int solve(ArrayList<Integer> A) {
		ArrayList<Integer> primeArray = new ArrayList<Integer>();
		final int N = null != A ? A.size() : null;

		if (N >= 1 && N <= Math.pow(10, 3)) {
			for (int i = 0; i < N; i++) {
				int value = A.get(i);
				if (value > 0 && value <= Math.pow(10, 6)) {
					boolean isPrime = isPrime(value);
					if(isPrime) {
						primeArray.add(value);
					}

				}

			}
		}
		return primeArray.size();
	}

	private boolean isPrime(int value) {
		
		if(value == 1) {
			return false;
		}
		for(int i=2 ;i <= Math.sqrt(value);i++) {
			
			if(value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PrimalPower mpAndNext = new PrimalPower();
		List<Integer> arrays = Arrays.asList(97, 43, 29, 11, 100, 47, 76, 83, 37, 19, 17, 19, 71, 0, 1, -82, 2, -83, 37, 13, 5, 97, 17, 30, 31, 48, 2, 19, 31, 91, 19, 2, 5, 89, 2, 67, 31, 47, 43, 31, 5, 17, 83, 11, 47, 73, 19, 3, 3, 19, 59, 91, 67, 7, 43, 4, 3, 51, 52, 23, 3, 37, 53, 89, 9, 41, 19, 61, 7, 5, 53, 59, 19, 11, 79, 37, 31, 37, 73, 82, 41, 2, 13, 8, 2, 36, 19, 58, 17, 17, 59, 59, 37, 11, 13, 37, 47, 83, 31, 3 );
		
		//List<Integer> arrays = Arrays.asList(1 );
		// List<Integer> arrays = Arrays.asList( 0 );
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.addAll(arrays);
		mpAndNext.solve(myList);
	}
}
