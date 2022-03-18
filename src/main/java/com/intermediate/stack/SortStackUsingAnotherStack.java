package com.intermediate.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Sort stack using another stack Problem Description
 * 
 * Given a stack of integers A, sort it using another stack.
 * 
 * Return the array of integers after sorting the stack using another stack.
 * 
 * 
 * 
 * Problem Constraints
 * 
 * 1 <= |A| <= 5000
 * 
 * 0 <= A[i] <= 1000000000
 * 
 * 
 * 
 * Input Format
 * 
 * The only argument given is the integer array A.
 * 
 * 
 * 
 * Output Format
 * 
 * Return the array of integers after sorting the stack using another stack.
 * 
 * 
 * 
 * Example Input
 * 
 * Input 1:
 * 
 * A = [5, 4, 3, 2, 1] Input 2:
 * 
 * A = [5, 17, 100, 11]
 * 
 * 
 * Example Output
 * 
 * Output 1:
 * 
 * [1, 2, 3, 4, 5] Output 2:
 * 
 * [5, 11, 17, 100]
 * 
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * 
 * Just sort the given numbers. Explanation 2:
 * 
 * Just sort the given numbers.
 */
public class SortStackUsingAnotherStack {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> sortedStack = new Stack<>();
		for (Integer a : A) {
			stack.push(a);
		}
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
				int temp2 = sortedStack.pop();
				stack.push(temp2);
			}
			sortedStack.push(temp);
		}

		return new ArrayList<Integer>(sortedStack);
	}

	public static void main(String[] args) {
		SortStackUsingAnotherStack stackUsingAnother = new SortStackUsingAnotherStack();
		ArrayList<Integer> result = stackUsingAnother.solve(new ArrayList<>(Arrays.asList(5, 17, 100, 11, 200, 8)));
		System.out.println(result);

	}

}
