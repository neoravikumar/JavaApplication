package com.intermediate.strings;


/*
 Make String Pallindrome
Problem Description
Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.



Problem Constraints
1 <= N <= 106



Input Format
The only argument given is a string A.



Output Format
Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.



Example Input
Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome.  
 */
public class MakeStringPallindrome2 {
	
	public static int solve(String A) {

		StringBuilder s = new StringBuilder();
		s.append(A);
		// Get concatenation of string, special character and reverse string
		String rev = s.reverse().toString();
		s.reverse().append("$").append(rev);
		// Get LPS array of this concatenated string
		int lps[] = computeLPSArray(s.toString());
		return A.length() - lps[s.length() - 1];

	}

	public static int[] computeLPSArray(String str) {
		int n = str.length();
		int lps[] = new int[n];
		int i = 1, len = 0;
		lps[0] = 0; // lps[0] is always 0

		while (i < n) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		MakeStringPallindrome2 makeStringPallindrome = new MakeStringPallindrome2();
		int result = makeStringPallindrome.solve("aaaac");
		System.out.println(result);
	}

}
