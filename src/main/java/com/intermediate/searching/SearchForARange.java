package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Search for a Range
Problem Description
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 First occurence of 8 in A is at index 3
 Second occurence of 8 in A is at index 4
 ans = [3, 4]
Explanation 2:

 There is no occurence of 3 in the array.
 */
public class SearchForARange {

	public ArrayList<Integer> searchRange(final List<Integer> A, int B) {

		int left = 0;
		int right = A.size() - 1;
		int fIndex = -1, rIndex = -1;
		if(A.size()==1 && A.get(0)==B) {
			ArrayList<Integer> result = new ArrayList<>();
			result.add(0);
			result.add(0);
			return result;
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A.get(mid) == B) {
				fIndex = mid;
			}
			if (A.get(mid) >= B) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		left = 0;
		right = A.size() - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A.get(mid) == B) {
				rIndex = mid;
			}
			if (A.get(mid) <= B) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		

		ArrayList<Integer> result2 = new ArrayList<>();
		result2.add(fIndex);
		result2.add(rIndex);
		return result2;
	}

	public static void main(String[] args) {

		SearchForARange searchForARange = new SearchForARange();
		ArrayList<Integer> result = searchForARange
				.searchRange(new ArrayList<Integer>(Arrays.asList( 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)), 10);
		System.out.println(result);

	}

}
