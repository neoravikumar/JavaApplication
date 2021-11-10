package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*Maximum Absolute Difference
Problem Description

You are given an array of N integers, A1, A2, .... AN.

Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.



Problem Constraints
1 <= N <= 100000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum value of f(i, j).



Example Input
Input 1:

A = [1, 3, -1]
Input 2:

 
A = [2]


Example Output
Output 1:

5
Output 2:

0


Example Explanation
Explanation 1:

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
Explanation 2:

Only possibility is i = 1 and j = 1. That gives answer = 0.*/
public class MaximumAbsoluteDifference {

	public int maxArr(ArrayList<Integer> A) {

		int xMax = Integer.MIN_VALUE;
		int yMax = Integer.MIN_VALUE;
		int xMin = Integer.MAX_VALUE;
		int yMin = Integer.MAX_VALUE;

		int xi = 0;
		int yi = 0;

		for (int i = 0; i < A.size(); i++) {
			xi = A.get(i) + i;
			yi = A.get(i) - i;
			if (xi > xMax) {
				xMax = xi;
			}
			if (yi > yMax) {
				yMax = yi;
			}

			if (xi < xMin) {
				xMin = xi;
			}
			if (yi < yMin) {
				yMin = yi;
			}
			
		}
		System.out.println("xMax:xMIn:"+xMax+":"+xMin);
		System.out.println("yMax:yMIn:"+yMax+":"+yMin);
		return Math.max(Math.abs(xMax - xMin), Math.abs(yMax - yMin));
	}

	public static void main(String[] args) {
		MaximumAbsoluteDifference maximumAbsoluteDifference = new MaximumAbsoluteDifference();
		int result = maximumAbsoluteDifference.maxArr(new ArrayList(Arrays.asList(-98, -5, 37, -97, 38, 22, 70, 42, 61, 84)));
		System.out.println(result);

	}

}
