package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 3 Sum
Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.


Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.
 */
public class ThreeSum {

	public int threeSumClosest(ArrayList<Integer> A, int B) {

		Collections.sort(A);
		int mindiff = Integer.MAX_VALUE;
		int close_sum = 0;
		for (int i = 0; i < A.size(); i++) {
			int j = i + 1;
			int k = A.size() - 1;
			while (j < k) {
				long sum = A.get(i)+ A.get(j) + A.get(k);
				int diff = (int) Math.abs(B - sum);
				if (diff < mindiff) {
					mindiff = diff;
					close_sum = (int) sum;
				}
				if (sum < B) {
					j++;
				} else if (sum > B) {
					k--;
				} else {
					return close_sum;
				}
			}
		}
		return close_sum;
	}

	public static void main(String[] args) {
		ThreeSum threeSumZero = new ThreeSum();
		int result = new ThreeSum().threeSumClosest(new ArrayList<Integer>(Arrays.asList(1, 2, 3)),6);
		System.out.println(result);

	}

}
