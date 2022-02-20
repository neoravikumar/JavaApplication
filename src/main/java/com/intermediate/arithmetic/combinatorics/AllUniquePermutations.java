package com.intermediate.arithmetic.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 All Unique Permutations
Problem Description

Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9

0 <= A[i] <= 10



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible unique permutation of the array.



Example Input
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]


Example Explanation
Explanation 1:

 All the possible unique permutation of array [1, 1, 2].
Explanation 2:

 All the possible unique permutation of array [1, 2].
 */
public class AllUniquePermutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		Map<Integer, Integer> map = new HashMap();
		for (int num : A)
			map.put(num, map.getOrDefault(num, 0) + 1);
		backtracking(A, result, map, new ArrayList<Integer>());
		return result;
	}
	private void backtracking(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result, Map<Integer, Integer> map,
			ArrayList<Integer> arrayList) {
		if (arrayList.size() == a.size()) {
			result.add(new ArrayList<Integer>(arrayList));
			return;
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) > 0) {
				arrayList.add(key);
				map.put(key, map.get(key) - 1);
				backtracking(a, result, map, arrayList);
				map.put(key, map.get(key) + 1);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		AllUniquePermutations allUniquePermutations = new AllUniquePermutations();
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 2));
		
		ArrayList<ArrayList<Integer>> result = allUniquePermutations.permute(A);
		System.out.println(result);

	}

}
