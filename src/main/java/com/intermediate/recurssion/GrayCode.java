package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 Gray Code
Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints
1 <= A <= 16



Input Format
First argument is an integer A.



Output Format
Return an array of integers representing the gray code sequence.



Example Input
Input 1:

A = 2
Input 1:

A = 1


Example Output
output 1:

[0, 1, 3, 2]
output 2:

[0, 1]


Example Explanation
Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].
 */
public class GrayCode {

	private ArrayList<String> generateBinaryGray(int n) {

		// Base case
		if (n <= 0) {
			ArrayList<String> temp = new ArrayList<String>(Arrays.asList("0"));
			return temp;
		}
		if (n == 1) {
			ArrayList<String> temp = new ArrayList<String>(Arrays.asList("0", "1"));
			return temp;
		}

		// Recursive case
		ArrayList<String> recAns = generateBinaryGray(n - 1);
		ArrayList<String> mainAns = new ArrayList<String>();

		// Append 0 to the first half
		for (int i = 0; i < recAns.size(); i++) {
			String s = recAns.get(i);
			mainAns.add("0" + s);
		}

		// Append 1 to the second half
		for (int i = recAns.size() - 1; i >= 0; i--) {
			String s = recAns.get(i);
			mainAns.add("1" + s);
		}
		return mainAns;
	}

	public ArrayList<Integer> grayCode2(int a) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		result.add(0);
		int n = a;
		for (int i = 0; i < n; i++) {
			int curSize = result.size();
			for (int j = curSize - 1; j >= 0; j--) {
				String str = String.valueOf(result.get(j)) + String.valueOf((1 << i));
				System.out.println(str);
				result.add(Integer.valueOf(str));
			}
		}
		return result;
	}

	public ArrayList<Integer> grayCode(int a) {

		ArrayList<Integer> result = generateBinaryGray(a).stream().map(k -> Integer.parseInt(k, 2))
				.collect(Collectors.toCollection(ArrayList::new));
		return result;

	}

	public static void main(String[] args) {

		GrayCode greCode = new GrayCode();
		ArrayList<Integer> result = new ArrayList<Integer>();
		// ArrayList<Integer> result = greCode.grayCode(2);
		// System.out.println(result);
		ArrayList<String> fResult = greCode.generateBinaryGray(3);
		System.out.println(fResult);
		
		List<Integer> myResult = greCode.grayCode(3);
		System.out.println(myResult);
		
		
		// System.out.println(result);

	}

}
