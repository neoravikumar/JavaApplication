package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Sorted Insert Position
Problem Description

Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 106



Input Format
First argument is an integer array A of size N.
Second argument is an integer B.



Output Format
Return an integer denoting the index of target value.



Example Input
Input 1:

A = [1, 3, 5, 6]
 B = 5
Input 2:

A = [1]
 B = 1


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

The target value is present at index 2.
Explanation 2:

The target value is present at index 0.
 */
public class SortedInsertPosition {

	public int searchInsert(ArrayList<Integer> A, int B) {

		int N = A.size();
		int start = 0;
		int end = N - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A.get(mid) == B) {
				return mid;
			}
			if (A.get(mid) < B) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end + 1;
	}

	public static void main(String[] args) {
		SortedInsertPosition sortedInsertPosition = new SortedInsertPosition();
		int result = sortedInsertPosition
				.searchInsert(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 6, 7, 8, 9)), 5);
		System.out.println("Result is:>>" + result);
	}

}
