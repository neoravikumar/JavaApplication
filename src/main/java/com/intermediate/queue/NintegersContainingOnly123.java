package com.intermediate.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * N integers containing only 1, 2 & 3
 Problem Description

Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1, 2 and 3.

NOTE: All the A integers will fit in 32 bit integer.



Problem Constraints

1 <= A <= 29500



Input Format

The only argument given is integer A.



Output Format

Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input

Input 1:

 A = 3
Input 2:

 A = 7


Example Output

Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation

Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */
public class NintegersContainingOnly123 {
	
	public ArrayList<Integer> solve(int A) {
		
		  Deque<Integer> dq = new ArrayDeque<>();
			ArrayList<Integer> series = new ArrayList<>();
			for(int i=1;i<=A && i<=3;i++) {
				series.add(i);
				dq.addLast(i);
			}
			int tempA = A;
			while (tempA > 3 && tempA < 29500 ) {
				Integer temp = dq.peekFirst();
				dq.addLast(temp*10+1);
				dq.addLast(temp*10+2);
				dq.addLast(temp*10+3);
				series.add(temp*10+1);
				series.add(temp*10+2);
				series.add(temp*10+3);
				dq.removeFirst();
				tempA--;
			}
			return new ArrayList<>(series.subList(0, A));
    }

	public static void main(String[] args) {
		NintegersContainingOnly123 nintegersContainingOnly123 = new NintegersContainingOnly123();
		ArrayList<Integer> result = nintegersContainingOnly123.solve(7);
		System.out.println(result);
	}

}
