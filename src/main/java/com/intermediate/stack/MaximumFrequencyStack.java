package com.intermediate.stack;

import java.util.*;

/*
 Maximum Frequency stack
Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers denoting answer to each operation.



Example Input
Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output
Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation
Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations
 */
public class MaximumFrequencyStack {
	
	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

		Map<Integer,Stack<Integer>> myStack = new HashMap<>();
		Map<Integer, Integer> myfreqMap = new HashMap<>();
		ArrayList<Integer> resultArray = new  ArrayList<Integer>();
		int maxFrequency = 0;
		for(ArrayList<Integer> aa : A) {
			// Push into Stack and maintain frequency
			if(aa.get(1)!=0) {
				int key = aa.get(1);

				myfreqMap.put(key, myfreqMap.getOrDefault(key, 0) + 1);
				myStack.computeIfAbsent(myfreqMap.get(key), k -> new Stack<>()).add(key);
				maxFrequency = Math.max(maxFrequency, myfreqMap.get(key));
				resultArray.add(-1);
			}
			else {
				// pop the element from stack
				int val = myStack.get(maxFrequency).pop();
				myfreqMap.put(val, myfreqMap.getOrDefault(val, 0) - 1);
				if (myStack.get(maxFrequency).isEmpty()) {
					maxFrequency--;
				}
				resultArray.add(val);
			}

		}
		return resultArray;
    }
	
	

	public static void main(String[] args) {
		MaximumFrequencyStack maxstack = new MaximumFrequencyStack();
		
//		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,5));
//		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1,7));
//		ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(1,5));
//		ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(1,7));
//		ArrayList<Integer> a5 = new ArrayList<>(Arrays.asList(1,4));
//		ArrayList<Integer> a6 = new ArrayList<>(Arrays.asList(1,5));
//		ArrayList<Integer> a7 = new ArrayList<>(Arrays.asList(2,0));
//		ArrayList<Integer> a8 = new ArrayList<>(Arrays.asList(2,0));
//		ArrayList<Integer> a9 = new ArrayList<>(Arrays.asList(2,0));
//		ArrayList<Integer> a10 = new ArrayList<>(Arrays.asList(2,0));
//		
//		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
//		input.add(a1);
//		input.add(a2);
//		input.add(a3);
//		input.add(a4);
//		input.add(a5);
//		input.add(a6);
//		input.add(a7);
//		input.add(a8);
//		input.add(a9);
//		input.add(a10);
		
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 5));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(2, 0));
		ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(1, 4));
////		ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(1,7));
////		ArrayList<Integer> a5 = new ArrayList<>(Arrays.asList(1,4));
////		ArrayList<Integer> a6 = new ArrayList<>(Arrays.asList(1,5));
////		ArrayList<Integer> a7 = new ArrayList<>(Arrays.asList(2,0));
////		ArrayList<Integer> a8 = new ArrayList<>(Arrays.asList(2,0));
////		ArrayList<Integer> a9 = new ArrayList<>(Arrays.asList(2,0));
////		ArrayList<Integer> a10 = new ArrayList<>(Arrays.asList(2,0));
////		
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(a1);
		input.add(a2);
		input.add(a3);
////		input.add(a4);
////		input.add(a5);
////		input.add(a6);
////		input.add(a7);
////		input.add(a8);
////		input.add(a9);
////		input.add(a10);
		
		
		ArrayList<Integer>  result = maxstack.solve(input);
		System.out.println(result);

	}

}
