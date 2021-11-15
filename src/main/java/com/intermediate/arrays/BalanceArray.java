package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Balance Array
Problem Description

Given an integer array A of size N. You need to count the number of special elements in the given array.

A element is special if removal of that element make the array balanced.

Array will be balanced if sum of even index element equal to sum of odd index element.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the count of special elements.



Example Input
Input 1:

 A = [2, 1, 6, 4]
Input 2:

 A = [5, 5, 2, 5, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 After deleting 1 from array : {2,6,4}
    (2+4) = (6)
 Hence 1 is the only special element, so count is 1
Explanation 2:

 If we delete A[0] or A[1] , array will be balanced
    (5+5) = (2+8)
 So A[0] and A[1] are special elements, so count is 2.
 */
public class BalanceArray {

	public int solve(ArrayList<Integer> A) {
		int n = A.size();

		if (n == 1) {
			return 1;
		}

		if (n == 2)
			return 0;
		int sumEven = 0;

		int sumOdd = 0;

		for (int i = 0; i < n; i++) {

			if (i % 2 == 0) {

				sumEven += A.get(i);
			}

			else {

				sumOdd += A.get(i);
			}
		}
		int currOdd = 0;
		int currEven = A.get(0);
		int res = 0;
		int newEvenSum = 0;
		int newOddSum = 0;

		for (int i = 1; i < n - 1; i++) {

			if (i % 2 != 0) {

				currOdd += A.get(i);

				newEvenSum = currEven + sumOdd - currOdd;

				newOddSum = currOdd + sumEven - currEven - A.get(i);
			}

			else {

				currEven += A.get(i);

				newOddSum = currOdd + sumEven - currEven;

				newEvenSum = currEven + sumOdd - currOdd - A.get(i);
			}

			if (newEvenSum == newOddSum) {

				res++;
			}
		}
		if (sumOdd == sumEven - A.get(0)) {

			res++;
		}
		if (n % 2 == 1) {
			if (sumOdd == sumEven - A.get(n - 1)) {

				res++;
			}
		} else {
			if (sumEven == sumOdd - A.get(n - 1)) {
				res++;
			}
		}

		return res;

	}

	public static void main(String[] args) {
		BalanceArray balanceArray = new BalanceArray();
		int result = balanceArray.solve(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
		System.out.println(result);

	}

}
