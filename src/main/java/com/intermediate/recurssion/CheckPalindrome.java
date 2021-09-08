package com.intermediate.recurssion;

/*Check Palindrome
Problem Description

Write a recursive function that checks whether a string A is a palindrome or Not.
Return 1 if the string A is palindrome, else return 0.

Note: A palindrome is a string that's the same when reads forwards and backwards.



Problem Constraints
1 <= A <= 50000

String A consist only of lowercase letters.



Input Format
First and only argument is a string A.



Output Format
Return 1 if the string A is palindrome, else return 0.



Example Input
Input 1:

 A = "naman"
Input 2:

 A = "strings"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 "naman" is a palindomic string, so return 1.
Explanation 2:

 "strings" is not a palindrome, so return 0.*/
public class CheckPalindrome {

	public int solve(String A) {

		char[] strArray = A.toLowerCase().toCharArray();
		int N = strArray != null ? strArray.length : 0;
		int result = 0;
		if (N >= 1 && N <= 50000) {
			result= isPalindrome(strArray, 0, N - 1);
		}
		return result;
	}

	private int isPalindrome(char[] input, int startIndex, int endIndex) {

		if (startIndex >= endIndex) {
			return 1;
		}

		if (input[startIndex] == input[endIndex]) {
			startIndex = startIndex + 1;
			endIndex = endIndex - 1;
			return isPalindrome(input, startIndex, endIndex);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		CheckPalindrome checkPalindrome = new CheckPalindrome();
		int result = checkPalindrome.solve("naman");
		System.out.println(result);

	}

}
