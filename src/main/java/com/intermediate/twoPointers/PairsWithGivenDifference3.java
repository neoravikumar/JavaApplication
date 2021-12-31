package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Pairs with Given Difference
Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints
1 <= N <= 104

0 <= A[i], B <= 105



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.



Example Input
Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0


Example Output
Output 1:

 2
Output 2:

 5
Output 3:

 2


Example Explanation
Explanation 1:

 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 
Explanation 2:

 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
Explanation 3:

 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class PairsWithGivenDifference3 {

	public static int countPairs(List<Integer> numbers, int k) {
		// 1. Save only distinct numbers into HashMap.
		// 2. Now, filter for each key where (key + k) i.e b exists.
		// 3. finally count of this will give us distinct pairs from numbers.
		// O(n)
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : numbers) {
			if (!map.containsKey(i)) {
				map.put(i, i);
			}
		}

		if (numbers.size() == 2) {
			if (Math.abs(numbers.get(1) - numbers.get(0)) == k || Math.abs(numbers.get(0) - numbers.get(1)) == k) {
				return 1;
			} else
				return 0;
		}

		int count = (int) map.keySet().stream().filter(key -> map.containsKey(key + k)).count();

		return count;
	}

	public int solve(ArrayList<Integer> A, int B) {
		int count = countPairs(A, B);
		return count;
	}

	// Driver code
	public static void main(String args[]) {
		System.out.println("Count of pairs with given diff is " + new PairsWithGivenDifference3().solve(new ArrayList<Integer>(Arrays.asList( 1, 1, 1, 2, 2)), 0));
	}

}
