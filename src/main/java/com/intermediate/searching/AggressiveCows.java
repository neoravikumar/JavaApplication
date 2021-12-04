package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Aggressive cows
Problem Description

Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 
John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
So the minimum distance will be 2.
Explanation 2:

 
The minimum distance will be 1.
 */
public class AggressiveCows {

	private boolean check(ArrayList<Integer> A, int key, int size, int minDistance) {
		int recent_placed = A.get(0);
		int cow_placed = 1;

		for (int i = 1; i < size; i++) {

			if (A.get(i) - recent_placed >= minDistance) {
				recent_placed = A.get(i);
				cow_placed++;
			}
		}
		if (cow_placed >= key) {
			return true;
		} else {
			return false;
		}
	}

	public int solve(ArrayList<Integer> A, int B) {
		int N = A.size();
		Collections.sort(A);
		int start = 0, end = A.get(N - 1) - A.get(0), ans = 0;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (check(A, B, N, mid)) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		AggressiveCows aggressiveCows = new AggressiveCows();
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11));
		int result = aggressiveCows.solve(arrayList, 2);
		System.out.println(result);
	}

}
