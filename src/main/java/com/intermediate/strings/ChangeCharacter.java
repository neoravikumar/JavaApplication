package com.intermediate.strings;

/*
 Change character
Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
First argument is a string A.

Second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */
public class ChangeCharacter {

	public int solve(String A, int B) {

		int N = null != A ? A.length() : 0;
		int result = 0;
		StringBuilder sb = new StringBuilder(A);
		if (N >= 1 && N <= 100000) {
			if (B >= 0 && B < N) {

				sb.toString().replaceAll("d", "a");
				System.out.println(sb);
			}
		}
		return B;
	}

	public static void main(String[] args) {

		ChangeCharacter chnc = new ChangeCharacter();
		int result = chnc.solve("abcabbccd", 3);
		
		System.out.println("Total No of Character is :>>"+result);

	}

}
