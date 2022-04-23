package com.intermediate.arithmetic;

import java.util.ArrayList;

/*
 * 
 Lucky Numbers
Problem Description

A lucky number is a number which has exactly 2 distinct prime divisors.

You are given a number A and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).



Problem Constraints
1 <= A <= 50000



Input Format
The first and only argument is an integer A.



Output Format
Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.



Example Input
Input 1:

 A = 8
Input 2:

 A = 12


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 Between [1, 8] there is only 1 lucky number i.e 6.
 6 has 2 distinct prime factors i.e 2 and 3.
Explanation 2:

 Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumbers {
	
	// Function to check whether a number is a PerfectSquare or not
		private boolean isPerfectSquare(double x) {
			double sr = Math.sqrt(x);
			return ((sr - Math.floor(sr)) == 0);
		}
		 
		// Function to check if a number is a product of exactly two distinct primes
		private boolean isProduct(int num)
		{
			int cnt = 0;
			if(num == 6) {
				System.out.println(num);
			}
			for (int i = 2; cnt < 2 && i * i <= num; ++i) {
				while (num % i == 0) {
					num /= i;
					cnt += 1;
				}
			}
			if (num > 1)
				++cnt;

			if (cnt == 2)
				return true;
			return false;
		}

	public int solve(int A) {

	    ArrayList<Integer> inputArray = new ArrayList<Integer>();
	 
	    for (int i = 1; i <= A; i++) {
	    	System.out.println(i);
	        if (isProduct(i) && !isPerfectSquare(i)) {
	        	System.out.println("When i is:>>"+i);
	            inputArray.add(i);
	        }
	    }
	    return inputArray.size(); 
	}
	
	

	public static void main(String[] args) {
		LuckyNumbers luckyNumbers = new LuckyNumbers();
		int result = luckyNumbers.solve(12);
		System.out.println("Result:>"+result);

	}

}
