package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * Distinct Numbers in Window Problem Description
 * 
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B.
 * Return the of count of distinct numbers in all windows of size B.
 * 
 * Formally, return an array of size N-B+1 where i'th element in this array
 * contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * 
 * NOTE: if B > N, return an empty array.
 * 
 * 
 * 
 * Input Format First argument is an integer array A Second argument is an
 * integer B.
 * 
 * 
 * 
 * Output Format Return an integer array.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2, 1, 3, 4, 3] B = 3 Input 2:
 * 
 * A = [1, 1, 2, 2] B = 1
 * 
 * 
 * Example Output Output 1:
 * 
 * [2, 3, 3, 2] Output 2:
 * 
 * [1, 1, 1, 1]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * A=[1, 2, 1, 3, 4, 3] and B = 3 All windows of size B are [1, 2, 1] [2, 1, 3]
 * [1, 3, 4] [3, 4, 3] So, we return an array [2, 3, 3, 2]. Explanation 2:
 * 
 * Window size is 1, so the output array is [1, 1, 1, 1].
 *
 */
public class DistinctNumbersinWindow {

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

		int N = null != A ? A.size() : 0;

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (B > N) {
			return result;
		}

		List<Integer> subArray = new ArrayList<Integer>();
		subArray = A.subList(0, B);
		HashMap<Integer, Integer> listMap = new HashMap<Integer, Integer>();
		for (int a : subArray) {
			listMap.put(a, listMap.getOrDefault(a, 0) + 1);
		}

		result.add(listMap.size());
		for (int ith = B; ith < N; ith++) {

			int value = A.get(ith - B);
			if (listMap.get(value) == 1) {
				listMap.remove(A.get(ith - B));
			} else {
				listMap.put(A.get(ith - B), listMap.get(A.get(ith - B)) - 1);
			}

			listMap.put(A.get(ith), listMap.getOrDefault(A.get(ith), 0) + 1);

			result.add(listMap.size());

		}

		return result;
	}

	private void checkNdOperate(HashMap<Integer, Integer> listMap, int valueToAdd) {
		if (!listMap.containsKey(valueToAdd)) {
			listMap.put(valueToAdd, 1);
		} else {
			int value = listMap.get(valueToAdd);
			listMap.put(valueToAdd, value + 1);
		}
	}

	private int checkAndCount(List<Integer> input) {

		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		if (null != input && input.size() >= 1) {
			for (Integer a : input) {
				if (!set.contains(a)) {
					set.add(a);
					count++;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) {
		// List<Integer> integers = Arrays.asList(18, 11, 16, 19, 11, 9, 8, 15, 3, 10,
		// 9, 20, 1, 19); // 1
		// List<Integer> integers = Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6,
		// 1, 1, 4, 18); // 6

		List<Integer> integers = Arrays.asList(1, 1, 2, 2); // 3 // [2, 3, 3,
		// 2]

		// List<Integer> integers = Arrays.asList(1, 1, 2, 2); // 1 //

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		DistinctNumbersinWindow eq = new DistinctNumbersinWindow();
		ArrayList<Integer> result = eq.dNums(inputArray, 1);

		System.out.println("Result:>>" + result);
	}

}
