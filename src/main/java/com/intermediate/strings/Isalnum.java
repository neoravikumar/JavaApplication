package com.intermediate.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*Isalnum()
Problem Description

You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Example Input
Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 All the characters are alphanumeric.
Explanation 2:

 All the characters are NOT alphabets i.e ('#').*/
public class Isalnum {

	public int solve(ArrayList<Character> A) {

		return isAlphaNumeric(A);
	}

	private int isAlphaNumeric(ArrayList<Character> A) {
		HashSet<Integer> myalphaNumericSet = new HashSet<Integer>();

		for (int i = 65, j = 97, k = 48; i <= 90; i++, j++) {
			if (i < 75) {
				myalphaNumericSet.add(k++);
			}
			myalphaNumericSet.add(i);
			myalphaNumericSet.add(j);

		}

		int N = null != A ? A.size() : 0;
		for (int start = 0, end = N - 1; start < end; start++, end--) {
			int mystartInt = A.get(start);
			int endInt = A.get(end);
			if (!(myalphaNumericSet.contains(mystartInt)) || !(myalphaNumericSet.contains(endInt))) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {

		Isalnum isalnum = new Isalnum();
		List<Character> lst = Arrays.asList('s', 'g', '7', 'A', 'd', 'v', 't', 'W', '4', 'A', '4', '2', '8', 'f', 'h', 'B', 'p', 'h', '7', '0', 'v', 'q', 'w', '9', 'o');

		ArrayList<Character> abc = new ArrayList<Character>();
		abc.addAll(lst);

		System.out.println(isalnum.solve(abc));
	}

}
