package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 Remove Duplicates from Sorted Array
Problem Description

Given a sorted array A consisting of duplicate elements.

Your task is to remove all the duplicates and return a sorted array of distinct elements consisting of all distinct elements present in A.

NOTE: The input format has been changed from previous versions.



Problem Constraints
1 <= |A| <= 106

1 <= A[i] <= 2*109



Input Format
First and only argurment containing the integer array A.



Output Format
Return an array/vector from the function as per the question.



Example Input
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2, 2, 3, 3]


Example Output
Output 1:

[1, 2]
Output 2:

[1, 2, 3]


Example Explanation
Explanation 1:

Updated Array: [1, 2] after removing the 2nd element.
Explanation 2:

Updated Array: [1, 2, 3] after removing the 3rd and 5th element.
 */
public class RemoveDuplicatesfromSortedArray {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		/*
		 * Set<Integer> hset = null; if(A.size()>=1 && A.size()<=Math.pow(10, 6)) { hset
		 * = new HashSet<Integer>(); hset.addAll(A); } return new
		 * ArrayList<Integer>(hset);
		 */

		if (A.size() == 0)
			return A;
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lastNum = A.get(0);
		result.add(lastNum);
		for (int i = 0; i < A.size() - 1; i++) {
			if (lastNum < A.get(i + 1)) {
				lastNum = A.get(i + 1);
				result.add(A.get(i + 1));
			}
		}
		return result;

	}

	public static void main(String[] args) {

		RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();

		// ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3,
		// 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ));
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 3, 2));

		ArrayList<Integer> result = removeDuplicatesfromSortedArray.solve(a1);
		System.out.println(result);

	}

}
