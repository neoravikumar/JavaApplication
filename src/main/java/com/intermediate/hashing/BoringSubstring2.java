package com.intermediate.hashing;

/**
 Boring substring
Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Example Input
Input 1:

 A ="abcd"
Input 2:

 A = "aab"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:

 No arrangement of string A can make it free of boring substrings.
 */

public class BoringSubstring2 {
	
	public int solve(String A) {

		char[] charArr = A.toCharArray();
		int oddMax = Integer.MIN_VALUE;
		int evenMax = Integer.MIN_VALUE;
		int oddMin = Integer.MAX_VALUE;
		int evenMin = Integer.MAX_VALUE;
		if (charArr.length == 0) {
			return 0;
		}
		for (char c : charArr) {
			if (c % 2 == 0) {
				evenMax = Math.max(evenMax, c);
				evenMin = Math.min(evenMin, c);
			} else {
				oddMax = Math.max(oddMax, c);
				oddMin = Math.min(oddMin, c);
			}
		}

		// either of string is empty
		if (evenMax == Integer.MIN_VALUE || oddMin == Integer.MAX_VALUE) {
			return 1;
		}

		if ((oddMax + 1 == evenMin || oddMax - 1 == evenMin) && (oddMin + 1 == evenMax || oddMin - 1 == evenMax)) {
			return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		String str = "abcd";
	    int ans = new BoringSubstring2().solve(str);
	    System.out.println( ans);

	}

}
