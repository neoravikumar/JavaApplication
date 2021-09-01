package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*Two out of Three
Problem Description

Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.



Problem Constraints
1 <= |A|, |B|, |C| <= 100000

1 <= A[i], B[i], C[i] <= 100000

A, B, C may or may not have pairwise distinct elements.



Input Format
First argument is the array A.

First argument is the array B.

First argument is the array C.



Output Format
Return a sorted array of numbers.



Example Input
Input 1:

A = [1, 1, 2]
B = [2, 3]
C = [3]
Input 2:

A = [1, 2]
B = [1, 3]
C = [2, 3]


Example Output
Output 1:

[2, 3]
Output 2:

[1, 2, 3]


Example Explanation
Explanation 1:

1 is only present in A. 2 is present in A and B. 3 is present in B and C.
Explanation 2:

All numbers are present in atleast 2 out of 3 lists.*/
public class TwoOutOfThree {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

		int lA = null != A ? A.size() : null;
		int lB = null != B ? A.size() : null;
		int lC = null != C ? A.size() : null;
		
		Map<Integer, Integer> sortedMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> sortedMap2 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> sortedMap3 = new HashMap<Integer, Integer>();
		
		SortedMap<Integer, Integer> finalMap = new TreeMap<Integer, Integer>();

		if ((lA >= 1 && lA <= 100000) && (lB >= 1 && lB <= 100000) && (lC >= 1 && lC <= 100000)) {
			
			ListToMap(A, sortedMap);
			
			ListToMap(B, sortedMap2);
			
			ListToMap(C, sortedMap3);
			
			
			for(Integer key : sortedMap.keySet()) {
					if (sortedMap2.containsKey(key)) {
						int value = sortedMap2.get(key);
						finalMap.put(key, value + 1);
					} 
			}
			for(Integer key : sortedMap.keySet()) {
				if (sortedMap3.containsKey(key)) {
					int value = sortedMap3.get(key);
					finalMap.put(key, value + 1);
				} 
		}
			for(Integer key : sortedMap2.keySet()) {
				if (sortedMap3.containsKey(key)) {
					int value = sortedMap3.get(key);
					finalMap.put(key, value + 1);
				} 
		}

		}

		ArrayList<Integer> result = new ArrayList<Integer>(finalMap.keySet());
		return result;
	}

	private void ListToMap(ArrayList<Integer> B, Map<Integer, Integer> sortedMap2) {
		for(int h : B) {
			if (h >= 0 && h <= 100000) {
				if (sortedMap2.containsKey(h)) {
					int value = sortedMap2.get(h);
					sortedMap2.put(h, value + 1);
				} else {
					sortedMap2.put(h, 1);
				}

			}
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(2, 3));
		ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(3));

		/*
		 * one.forEach(a -> System.out.print(a + " ")); two.forEach(a ->
		 * System.out.print(a + " ")); three.forEach(a -> System.out.print(a + " "));
		 */

		TwoOutOfThree twoOutOfThree = new TwoOutOfThree();
		ArrayList<Integer> resultArray = twoOutOfThree.solve(one, two, three);
		resultArray.forEach(a -> System.out.print(a + " "));

	}

}
