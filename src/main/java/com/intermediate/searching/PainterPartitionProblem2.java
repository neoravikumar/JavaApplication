package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Painter's Partition Problem
Problem Description

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.

Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. Which means a configuration where painter 1 paints board 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106



Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.



Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.



Example Input
Input 1:

 A = 2
 B = 5
 C = [1, 10]
Input 2:

 A = 10
 B = 1
 C = [1, 8, 11, 3]


Example Output
Output 1:

 50
Output 2:

 11


Example Explanation
Explanation 1:

 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50%10000003
Explanation 2:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3 
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11%10000003
 */
public class PainterPartitionProblem2 {

	/*
	 * public int paint(int A, int B, ArrayList<Integer> C) {
	 * 
	 * int low = 0; int high = 0; int N = C.size(); long ans = 0L;
	 * 
	 * for (int k = 0; k < N; k++) { low = Math.max(low, C.get(k)); high +=
	 * B*C.get(k); }
	 * 
	 * while (low <= high) { int mid = low + (high - low) / 2; if (check(C, A, B,
	 * mid)) { ans = mid ; high = mid - 1; } else { low = mid + 1; } }
	 * 
	 * return new Long(ans * B).intValue() % 10000003; }
	 * 
	 * private boolean check(ArrayList<Integer> c, int a, int b, int maxTime) { int
	 * painters = 1; int time = 0; for (int k = 0; k < c.size(); k++) { time = time
	 * + c.get(k); // recently added cross max time if (time > time) { // Assign it
	 * to other painter time = b * c.get(k); painters++; } }
	 * 
	 * if (painters > b) { return false; } return true; }
	 */

	boolean isPossible(int[] C, int painters, int unit)

	{
		int i = 0;
		int sum = 0;
		int count1 = painters;
		painters--;
		int count = 1;
		while (i < C.length) {
			sum = sum + C[i];
			if (sum > unit) {
				sum = 0;
				painters--;
				count++;
			} else {
				i++;
			}
		}
		// System.out.println("Count1="+count1);
		// System.out.println("Count="+count);
		if (count <= count1) {
			return true;
		}
		return false;
	}

	public int paint(int A, int B, int[] C) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < C.length; i++)
		{
			sum = sum + C[i];
		}
		if (A >= C.length)
			return B * max;
		for (int i = 0; i < C.length; i++)
		{
			if (min > C[i])
				min = C[i];
			if (max < C[i])
				max = C[i];
		}
		min = max;
		max = sum;
		int ans = 0;
		int mid = 0;
		while (min < max)
		{
			mid = (min + max) / 2;
				if (isPossible(C, A, mid) == true)
				{
					ans = mid;
					max = mid;
				}
				else
					min = mid + 1;
		}
		return ans * B;
	}

	public static void main(String[] args) {
		PainterPartitionProblem2 painterPartitionProblem = new PainterPartitionProblem2();

		// ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(884, 228,
		// 442, 889));
		// int result = painterPartitionProblem.paint(4,10, aList);

		// 18670
		ArrayList<Integer> aList = new ArrayList<Integer>(
				Arrays.asList(185, 186, 938, 558, 655, 461, 441, 234, 902, 681));
		int arr[] = {185, 186, 938, 558, 655, 461, 441, 234, 902, 681};
		int result = painterPartitionProblem.paint(3, 10, arr);

		System.out.println("Result :>>" + result);

	}

}
