package com.intermediate.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 Problem Description

Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints

1 <= A <= 100000



Input Format

The only argument given is an integer A.



Output Format

Return a string that denotes the Ath Perfect Number.



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 22
Output 2:

 1111


Example Explanation

Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
 */
public class PerfectNumberQueue {

	public String solve(int A) {

		Deque<String> dq = new ArrayDeque<>();
		dq.addLast("1");
		dq.addLast("2");
		ArrayList<String> series = new ArrayList<>();
		while (A > 0) {
			StringBuilder sb = new StringBuilder();
			String temp = dq.peekFirst();
			String temp1 = sb.append(temp).reverse().toString();
			dq.removeFirst();
			String x = temp + "1";
			String y = temp + "2";
			dq.addLast(x);
			dq.addLast(y);
			series.add(temp + temp1);
			sb.delete(0, sb.length() + 1);
			A--;
		}
		return series.get(series.size() - 1);
	}

	public static void main(String[] args) {
		
		PerfectNumberQueue perfectNumberQueue = new PerfectNumberQueue();
		String result = perfectNumberQueue.solve(4);
		System.out.println(result);

	}

}
