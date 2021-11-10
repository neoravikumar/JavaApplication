package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Single Number III
Problem Description

Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.



Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
First argument is an array of interger of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

 3 and 4 appear only once.
Explanation 2:

 1 and 2 appear only once.
 */
public class SingleNumberIII {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> resultList = new ArrayList<Integer>();

		int resultbit = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			resultbit = resultbit ^ A.get(i);
		}
		resultbit = resultbit - (resultbit & (resultbit - 1));
		int x = 0, y = 0;
		for (int i = 0; i < A.size(); i++) {
			if ((A.get(i) & resultbit) > 0) {
				x = x ^ A.get(i);
			} else {
				y = y ^ A.get(i);
			}
		}
		
		
		resultList.add(x);
		resultList.add(y);
		Collections.sort(resultList);
		return resultList;
	}

	public static void main(String[] args) {

		SingleNumberIII singleNumberIII = new SingleNumberIII();
		ArrayList<Integer> result = singleNumberIII.solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 2, 4)));
		System.out.println(result);
	}

}
