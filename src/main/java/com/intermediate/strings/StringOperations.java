package com.intermediate.strings;

import java.util.HashSet;

/*
 String operations
Problem Description

Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.



Problem Constraints
1<=N<=100000


Input Format
First argument is a string A of size N.



Output Format
Return the resultant string.



Example Input
A="AbcaZeoB"



Example Output
"bc###bc###"



Example Explanation
First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
Delete all the uppercase letters so string A becomes "bcaeobcaeo".
Now replace vowel with '#'.
A becomes "bc###bc###".
 */
public class StringOperations {

	public String solve(String A) {
		int N = null != A ? A.length() : 0;
		StringBuilder resultString = new StringBuilder();
		if (N >= 1 && N <= 100000) {
			// Concatenate the string with itself.
			// Delete all the uppercase letters.
			HashSet<Character> capslist = new HashSet<Character>();
			for (int i = 65; i <= 90; i++) {
				capslist.add((char) i);
			}
			HashSet<Character> vlist = new HashSet<Character>();
			vlist.add('a');
			vlist.add('e');
			vlist.add('i');
			vlist.add('o');
			vlist.add('u');
			for (int i = 0; i < A.length(); i++) {
				char value = A.charAt(i);
				if (capslist.contains(value)) {
				} else if (vlist.contains(value)) {
					resultString.append('#');
				} else {
					resultString.append(A.charAt(i));
				}
			}
		}
		resultString.append(resultString);
		return resultString.toString();
	}

	public static void main(String[] args) {
		StringOperations stringOperations = new StringOperations();
		String result = stringOperations.solve("AbcaZeoB");
		System.out.println(result);
	}
}
