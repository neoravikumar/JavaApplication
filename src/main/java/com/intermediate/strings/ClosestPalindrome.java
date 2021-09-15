package com.intermediate.strings;

/*
 Closest Palindrome
Problem Description

Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.



Problem Constraints
1 <= N <= 105



Input Format
First and only argument is a string A.



Output Format
Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.



Example Input
Input 1:

 A = "abbba"
Input 2:

 A = "adaddb"


Example Output
Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation
Explanation 1:

 We can change the character at index 3(1-based) to any other character. The string will be palindromic.
Explanation 2:

 To make the string palindromic we need to change 2 characters. 
 */
public class ClosestPalindrome {

	public String solve(String A) {

		int N = null != A ? A.length() : 0;
		int count = 0;
		A = A.toLowerCase();
		String result = "NO";

		if (N >= 1 && N <= Math.pow(10, 5)) {
			

			for (int i = 0, j = N -1 ; j >= i; i++, j--) {
				if ((A.charAt(i) != A.charAt(j))) {
					count++;
				}
			}
			if (count == 0 && ((N % 2) == 1)) {
				result = "YES";
			}
			else if(count ==1) {
				result = "YES";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ClosestPalindrome closestPalindrome = new ClosestPalindrome();
		String result = closestPalindrome.solve("abyu");
		System.out.println(result);
	}

}
