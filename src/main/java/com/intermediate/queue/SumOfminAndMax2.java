package com.intermediate.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**

Sum of min and max
Problem Description
Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 
Explanation 2:

 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
 */


public class SumOfminAndMax2 {

	public int solve(ArrayList<Integer> A, int B) {
		Deque<Integer> maxqueue = new LinkedList<Integer>();
		Deque<Integer> minqueue = new LinkedList<Integer>();
		int start = 0;
		int length = 0;
		int min = 0;
		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			if (maxqueue.isEmpty())
				maxqueue.addLast(i);
			else {
				while (!maxqueue.isEmpty() && A.get(maxqueue.peekLast()) < A.get(i)) {
					maxqueue.removeLast();
				}
				maxqueue.addLast(i);
			}
			if (minqueue.isEmpty())
				minqueue.addLast(i);
			else {
				while (!minqueue.isEmpty() && A.get(minqueue.peekLast()) > A.get(i)) {
					minqueue.removeLast();
				}
				minqueue.addLast(i);
			}
			length++;
			if (length >= B) {
				min = ((min % 1000000007) + (A.get(minqueue.peekFirst()) % 1000000007) % 1000000007);
				max = ((max % 1000000007) + (A.get(maxqueue.peekFirst()) % 1000000007) % 1000000007);
				if (start == maxqueue.peekFirst())
					maxqueue.removeFirst();
				if (start == minqueue.peekFirst())
					minqueue.removeFirst();
				start++;
			}
		}

		int sum = min + max;
		while (sum < 0)
			sum += 1000000007;
		return sum;
	}


	public static void main(String[] args) {
		SumOfminAndMax2 sumOfminAndMax = new SumOfminAndMax2();
		int result = sumOfminAndMax.solve(new ArrayList<Integer>(Arrays.asList(2, 5, -1, 7, -3, -1, -2)), 4);
		System.out.println(result);
	}
}
