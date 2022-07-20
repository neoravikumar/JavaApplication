package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Combination Sum
Problem Description

Given a set of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 <= a2 <= � <= ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints
1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format
First argument is the vector A.

Second argument is the integer B.



Output Format
Return a vector of all combinations that sum up to B.



Example Input
Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7


Example Output
Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]


Example Explanation
Explanation 1:

All possible combinations are listed.
Explanation 2:

All possible combinations are listed.
 */
public class CombinationSum2 {

	public ArrayList<ArrayList<Integer>> combSum(ArrayList<Integer> input, int targetSum) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int index = 0;
		int totalSum = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Integer[] myArr = {};

		//solve(input, index, totalSum, targetSum, result, temp);
		findSubsetsSum(result, input, new ArrayList<>(), index, totalSum, targetSum);

		return result;

	}

	private void solve(ArrayList<Integer> input, Integer index, Integer totalSum, Integer targetSum,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {

		if (index == input.size()) {
			if (totalSum == targetSum) {
				System.out.println(temp);
				// result.add(temp);
			}
			return;
		}

		
		solve(input, index + 1, totalSum + input.get(index), targetSum,result, new ArrayList<Integer>(temp));
		temp.add(input.get(index));
		solve(input, index + 1, totalSum, targetSum, result, temp);

	}
	
	
	public static void findSubsetsSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> input, ArrayList<Integer> output,
			int index, int totalSum, int targetSum ) {
		// Base Condition
		if (index == input.size()) {
			if (totalSum == targetSum) {
				result.add(output);
			}
			
			return;
		}

		// Not Including Value which is at Index
		findSubsetsSum(result, input, new ArrayList<>(output), index + 1,totalSum + input.get(index),targetSum);

		// Including Value which is at Index
		output.add(input.get(index));
		findSubsetsSum(result, input, new ArrayList<>(output), index + 1,totalSum,targetSum);
	}
	

	public static void main(String[] args) {
		CombinationSum2 combinationSum = new CombinationSum2();
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 7));
		ArrayList<ArrayList<Integer>> result = combinationSum.combSum(input, 7);
		System.out.println(result);

	}

}
