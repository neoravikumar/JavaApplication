package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Minimum Difference Puzzle Problem Description
 * 
 * There is a shop whose assistant told you that there are A puzzles in the shop
 * and you want to buy B of them. They might differ in difficulty and size. The
 * first jigsaw puzzle consists of A1 pieces, the second one consists of A2
 * pieces and so on.
 * 
 * You decided that the difference between the numbers of pieces in bought
 * puzzles must be as small as possible. Let x be the number of pieces in the
 * largest puzzle that the you buy and y be the number of pieces in the smallest
 * such puzzle. You want to choose such B puzzles that x-y is as minimum as
 * possible. Find the least possible value of x-y.
 * 
 * 
 * 
 * Problem Constraints 1 <= A <= 103
 * 
 * 1 <= B <= A
 * 
 * 1 <= A[i] <= 106
 * 
 * 
 * 
 * Input Format First argument is a vector A whose ith element represents number
 * of pieces of ith puzzle.
 * 
 * Second argument is an integer B as per the question.
 * 
 * 
 * 
 * Output Format Return an integer showing minimum possible value of x-y.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A={10, 12, 10, 7, 5, 22}, B=4
 * 
 * 
 * Example Output Output 1:
 * 
 * 5
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Selected puzzles are 10, 10, 12, 7: (Max-Min) = (12-7) = 5.
 */
public class MinimumDifferencePuzzle {

	public int solve(ArrayList<Integer> A, int B) {

		int N = A.size();
		int diff = Integer.MAX_VALUE;

		if (N >= 1 && N <= Math.pow(10, 5)) {
			if (B >= 1 && B <= N) {
				Collections.sort(A);
				for (int i = 0; i < N - B + 1; i++) {
					if (A.get(i) >= 1 && A.get(i) <= Math.pow(10, 6)) {
						diff = Math.min(diff, (A.get(i + B - 1) - A.get(i)));
					}
				}
				return diff;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(10, 12, 10, 7, 5, 22);

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		MinimumDifferencePuzzle eq = new MinimumDifferencePuzzle();
		int result = eq.solve(inputArray, 4);
		System.out.println("Result:>>" + result);

	}

}
