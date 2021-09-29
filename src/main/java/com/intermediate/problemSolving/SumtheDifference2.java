package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Sum the Difference Problem Description
 * 
 * Given an integer array A of size N. You have to find all possible non-empty
 * subsequence of the array of numbers and then, for each subsequence, find the
 * difference between the largest and smallest numbers in that subsequence Then
 * add up all the differences to get the number.
 * 
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 * 
 * NOTE: Subsequence can be non-contiguous.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 10000
 * 
 * 1<= A[i] <=1000
 * 
 * 
 * 
 * Input Format First argument is an integer array A.
 * 
 * 
 * 
 * Output Format Return an integer denoting the output.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2] Input 2:
 * 
 * A = [1]
 * 
 * 
 * Example Output Output 1:
 * 
 * 1 Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * All possible non-empty subsets are: [1] largest-smallest = 1 - 1 = 0 [2]
 * largest-smallest = 2 - 2 = 0 [1 2] largest-smallest = 2 - 1 = 1 Sum of the
 * differences = 0 + 0 + 1 = 1 So, the resultant number is 1 Explanation 2:
 * 
 * Only 1 subsequence of 1 element is formed.
 */
public class SumtheDifference2 {

	public int solve(ArrayList<Integer> A) {

		/*
		 * Collections.sort(A); int N = A.size(); int min_sum = 0; int max_sum = 0; int
		 * MOD = (int) (Math.pow(10, 9) + 7); if (N >= 1 && N <= 10000) { for (int i =
		 * 0; i < N; i++) { max_sum = 2 * max_sum + A.get(N - 1 - i);
		 * 
		 * max_sum %= MOD;
		 * 
		 * min_sum = 2 * min_sum + A.get(N - 1 - i);
		 * 
		 * min_sum %= MOD; } } return (max_sum - min_sum + MOD) % MOD;
		 */
		
		long max = 0;
		long min = 0;
		int N = A.size();
		Collections.sort(A);
		for (int i = 0; i < N; i++) {

			min = (min * 2) % 1000000007;

			min = (min + A.get(i)) % 1000000007;

		}

		for (int i = N - 1; i >= 0; i--) {

			max = (max * 2) % 1000000007;

			max = (max + A.get(i)) % 1000000007;

		}

		long ans = (max - min + 1000000007) % 1000000007;

		return new Long(ans).intValue();
		

		/*
		 * int sum = 0; int MOD = (int) (Math.pow(10, 9) + 7); for (int i = 0; i <
		 * Math.pow(2, A.size()); i++) { List<Integer> toAdd = generateList(i, A); if
		 * (null != toAdd && toAdd.size() > 0) { sum += sumOfArray(toAdd); } }
		 */

	}

	private List<Integer> generateList(int n, ArrayList<Integer> input) {

		int index = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (n != 0) {
			if ((n & 1) == 1) {
				list.add(input.get(index));
			}
			index++;
			n >>= 1;
		}
		return list;
	}

	private int sumOfArray(List<Integer> list) {
		int tSum = 0;
		int N = list.size();
		Collections.sort(list);
		if (N == 1) {
			tSum = list.get(0) - list.get(0);
			return tSum;
		} else {
			tSum = list.get(N - 1) - list.get(0);
		}
		return tSum;
	}

	public static void main(String[] args) {

		List<Integer> input = Arrays.asList(4,5,3);

		SumtheDifference2 stheDiff = new SumtheDifference2();
		int result = stheDiff.solve(new ArrayList(input));
		System.out.println("Result is :-:" + result);

	}

}
