package com.intermediate.arrays;

import java.util.ArrayList;

/*
 Prime Sum
Problem Description

Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints
4 <= A <= 2*107



Input Format
First and only argument of input is an even number A.



Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input
 4


Example Output
 [2, 2]


Example Explanation
 There is only 1 solution for A = 4.
 */
public class PrimeSum {

	
	private boolean isPrime(int value) {

		if (value == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(value); i++) {

			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// All the prime Array till N using Sieve of Eratosthenes
	private boolean[] listOfPrimeTillN(int A) {
		
		
		boolean prime[] = new boolean[A + 1];
		
		for (int i = 0; i <= A; i++) {
			prime[i] = true;
		}
		
		for (int p = 2; p * p <= A; p++) {
			// If prime[p] is not changed, then it is a prime
			if (prime[p] == true) {
				// Update all multiples of p
				for (int i = p * p; i <= A; i += p)
					prime[i] = false;
			}
		}
		return prime;
	}

	public ArrayList<Integer> primesum(int A) {

		ArrayList<Integer> resultArray = new ArrayList<Integer>();

		boolean prime[] = listOfPrimeTillN(A);
		
		for (int i = 2; i <= A; i++) {

			if (prime[i] == Boolean.TRUE && prime[A - i]) {
				resultArray.add(i);
				resultArray.add(A - i);
				break;
			}
		}

		return resultArray;
	}

	public static void main(String[] args) {
		PrimeSum primeSum = new PrimeSum();
		ArrayList<Integer> rsult = primeSum.primesum(16777214);
		//ArrayList<Integer> rsult = primeSum.primesum(4);
		System.out.println(rsult);
	}

}
