package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Intersection Of Sorted Arrays
Problem Description

Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example:

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 3 5]

Output: [3 3 5]

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 5]

Output: [3 5]
NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output.
 */
public class IntersectionOfSortedArrays {

	public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int i = 0, j = 0;
		Collections.sort(A);
		Collections.sort(B);
		 
        while (i < A.size() && j < B.size()) {
 
            if (A.get(i) > B.get(j)) {
                j++;
            }
 
            else if (B.get(j) > A.get(i)) {
                i++;
            }
            else {
                result.add(A.get(i));
                i++;
                j++;
            }
        }

		return result;
	}

	public static void main(String[] args) {
		IntersectionOfSortedArrays mergeTwoSortedArrays = new IntersectionOfSortedArrays();

		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(10,3));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(3,3));

		ArrayList<Integer> result = mergeTwoSortedArrays.intersect(a1, a2);
		System.out.println(result);

	}

}
