package com.intermediate.strings;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/*
 * Reverse the String
Problem Description

Given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105



Input Format
The only argument given is string A.



Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"  


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"    


Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "the sky is blue".
Explanation 2:
    We reverse the string word by word so the string becomes "this is ib".
 */
public class ReverseString {

	public String solve(String A) {
		Pattern pattern = Pattern.compile("\\s");
		String[] temp = pattern.split(A);
		String result = "";
		int N = A.length();
		if (N >= 1 && N <= (3 * Math.pow(10, 5))) {
			for (int i = 0; i < temp.length; i++) {
				if (i == temp.length - 1)
					result = temp[i] + result;
				else
					result = " " + temp[i] + result;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		ReverseString reverse = new ReverseString();
		System.out.println(reverse.solve("the sky is blue"));
	}

}
