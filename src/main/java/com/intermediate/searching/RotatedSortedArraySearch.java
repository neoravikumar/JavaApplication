package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Rotated Sorted Array Search
Problem Description

Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are disitinct.



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A = [1]
B = 1


Example Output
Output 1:

 0
Output 2:

 0


Example Explanation
Explanation 1:

 
Target 4 is found at index 0 in A.
Explanation 2:

 
Target 1 is found at index 0 in A.*/
public class RotatedSortedArraySearch {

	private int rotatedSortedSearch(List<Integer> A, int left, int right, int key) {

		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;

		if (A.get(mid) == key) {
			return mid;
		}

		if (A.get(mid) >= A.get(left)) {
			if (key >= A.get(left) && key <= A.get(mid)) {
				return rotatedSortedSearch(A, left, mid - 1, key);
			} else {
				return rotatedSortedSearch(A, mid + 1, right, key);
			}
		}
		
		if (key >= A.get(mid) && key<=A.get(right)) {
			return rotatedSortedSearch(A, mid + 1, right, key);
		}
		
		return rotatedSortedSearch(A, left, mid - 1, key);
	}

	public int search(final List<Integer> A, int B) {
		int N= A.size();
		return rotatedSortedSearch(A, 0, N-1, B);
	}

	public static void main(String[] args) {
		RotatedSortedArraySearch rotatedSortedArraySearch = new RotatedSortedArraySearch();
		List<Integer> input = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
		int result = rotatedSortedArraySearch.search(input, 0);
		System.out.println(result);
		

	}

}
