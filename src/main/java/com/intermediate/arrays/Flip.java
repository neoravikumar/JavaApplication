package com.intermediate.arrays;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Flip
Problem Description

You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.



Problem Constraints
1 <= size of string <= 100000



Input Format
First and only argument is a string A.



Output Format
Return an array of integers denoting the answer.



Example Input
Input 1:

A = "010"
Input 2:

A = "111"


Example Output
Output 1:

[1, 1]
Output 2:

[]


Example Explanation
Explanation 1:

A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].

 */
public class Flip {

	public ArrayList<Integer> flip(String A) {
		char[] strArray = A.toCharArray();
		int count = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (strArray[i] == '1') {
				count++;
			} else {
				break;
			}
		}

		if (count == A.length()) {
			return result;
		}

		int diff = 0;
		int ansdiff = 0;
		int left = 1, right = 1;
		int fromIndex = 0;
		int toIndex = 0;

		for (int k = 0; k < strArray.length; k++) {
			if (strArray[k] == '0') {
				diff++;
			} else {
				diff--;
			}

			if (diff > ansdiff) {
				ansdiff = diff;
				fromIndex = left;
				toIndex = right;
			}
			
			if (diff < 0) {
				diff = 0;
				left = k + 1+ 1;
			}
			right++;
		}

		/*
		 * for (int i = 0; i < strArray.length; i++) { if (strArray[i] == '0') {
		 * intArray[i] = 1; } else { intArray[i] = -1; } }
		 * 
		 * int maxSum = 0; int currSum = 0; int N = intArray.length; int fromIndex = 0;
		 * int toIndex = 0;
		 * 
		 * for (int i = 0; i < N; i++) { currSum = currSum + intArray[i]; if (currSum >
		 * maxSum) { maxSum = currSum; toIndex = i; } if (currSum < 0) { currSum = 0;
		 * fromIndex = i + 1; } }
		 */

		result.add(fromIndex);
		result.add(toIndex);

		return result;
	}

	public static void main(String[] args) {
		Flip filp = new Flip();
		System.out.println(filp.flip("010"));

	}

}
