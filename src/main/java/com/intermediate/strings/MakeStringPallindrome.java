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
public class MakeStringPallindrome {
	
	public static int solve(String A) {
       // Approach #1
		
	/*
	 * int cnt = 0; int flag = 0; while (A.length() > 0) { if (ispalindrome(A)) {
	 * flag = 1; break; } else { cnt++; A = A.substring(0, A.length() - 1); } } if
	 * (flag == 1) { return cnt; } return -1; }
	 * 
	 * 
	 * 
	 * private static boolean ispalindrome(String s) { int l = s.length(); for (int
	 * i = 0, j = l - 1; i <= j; i++, j--) { if (s.charAt(i) != s.charAt(j)) {
	 * return false; } } return true; }
	 */
		
		int start = 0;
		int end = 0;
		int count = 0;
		String copy = new StringBuilder(A).reverse().toString();

		while (true) {
			if (ispalindrome(copy.substring(start, end) + A))
				break;
			end++;
			count++;
		}

		return count;
	}

	public static boolean ispalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s);
	}

	public static void main(String[] args) {
		MakeStringPallindrome makeStringPallindrome = new MakeStringPallindrome();
		int result = makeStringPallindrome.solve("bb");
		System.out.println(result);
	}

}
