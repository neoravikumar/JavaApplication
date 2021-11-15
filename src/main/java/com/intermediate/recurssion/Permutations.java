package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Permutations
Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= N <= 9



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible permutation of the array.



Example Input
A = [1, 2, 3]


Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]


Example Explanation
All the possible permutation of array [1, 2, 3].
 */
public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> origList = new ArrayList<Integer>();
		origList.addAll(A);
		permute(origList, 0, result);
		return result;
	}

	public void permute(ArrayList<Integer> list, int start, ArrayList<ArrayList<Integer>> result) {

		if (start == list.size() - 1) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < list.size(); i++) {

			Collections.swap(list, start, i);
			permute(list, start + 1, result);
			Collections.swap(list, start, i);

		}
	}

	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		ArrayList<ArrayList<Integer>> result = permutations.permute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		System.out.println(result);

	}

}
