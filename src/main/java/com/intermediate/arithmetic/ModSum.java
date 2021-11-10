package com.intermediate.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Mod Sum
Problem Description

Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints
1 <= length of the array A <= 105

1 <= A[i] <= 103



Input Format
The only argument given is the integer array A.



Output Format
Return a single integer denoting sum % (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 61


Example Explanation
Explanation 1:

 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
 */
public class ModSum {

	int MOD = (int) Math.pow(10,9)+7;
	
	public int solve(ArrayList<Integer> A) {
		int N = A.size();
		Integer[] count = new Integer[1001];
		Arrays.fill(count, 0);
		for (Integer a : A)
			count[a]++;
		int ans = 0;

		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				int value = i % j;
				int temp = count[i] * count[j] * value;
				;
				ans = ((ans % MOD) + (temp % MOD)) % MOD;
			}
		}
		return ans;
    }

	public static void main(String[] args) {
		ModSum modSum = new ModSum();
		int result = modSum.solve(new ArrayList<Integer>(Arrays.asList(17, 100, 11)));
		System.out.println("The Answer is:>>"+result);

	}

}
