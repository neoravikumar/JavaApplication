package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*Common Elements
Problem Description

Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.*/
public class CommonElements {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();

		int N = A.size();
		int M = B.size();

		if (N >= 1 && N <= Math.pow(10, 5) && M >= 1 && M <= Math.pow(10, 5)) {

			for (Integer a : A) {
				if (map.containsKey(a)) {
					map.get(a);
				}
				map.put(a, a);
			}

			for (Integer a : B) {
				map2.put(a, a);
			}

		}
		return result;
	}

	// Prints intersection of arr1[0..m-1] and arr2[0..n-1]
	public ArrayList<Integer> printIntersection(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		Map<Integer, Integer> mapOne = new LinkedHashMap<Integer, Integer>();
		Map<Integer, Integer> mapTwo = new LinkedHashMap<Integer, Integer>();

		int N = A.size();
		int M = B.size();
		if (N >= 1 && N <= Math.pow(10, 5) && M >= 1 && M <= Math.pow(10, 5)) {
			for (Integer a : A) {
				if (mapOne.containsKey(a)) {
					int value = mapOne.get(a);
					mapOne.put(a, value + 1);
				} else {
					mapOne.put(a, 1);
				}
			}

			for (Integer b : B) {
				if (mapTwo.containsKey(b)) {
					int value = mapTwo.get(b);
					mapTwo.put(b, value + 1);
				} else {
					mapTwo.put(b, 1);
				}
			}

			for (Integer b : mapOne.keySet()) {
				if (mapTwo.containsKey(b)) {
					int value1 = mapOne.get(b);
					int value2 = mapTwo.get(b);
					int length = value1 > value2 ? value2 : value1;
					for (int i = 0; i < length; i++) {
						result.add(b);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		CommonElements firstRepatingElement = new CommonElements();

		List<Integer> lst = Arrays.asList(2, 1, 4, 10);
		// List<Integer> lst = Arrays.asList(2, 1, 4, 10);
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		List<Integer> lst2 = Arrays.asList(3, 6, 2, 10, 10);
		// List<Integer> lst2 = Arrays.asList(3, 6, 2, 10, 10);
		ArrayList<Integer> abc2 = new ArrayList<Integer>();
		abc2.addAll(lst2);

		// ArrayList<Integer> result = firstRepatingElement.solve(abc, abc2);

		// result.forEach(a -> System.out.print(a + " "));

		ArrayList<Integer> result = firstRepatingElement.printIntersection(abc, abc2);
		result.forEach(a -> System.out.print(a + " "));

	}

}
