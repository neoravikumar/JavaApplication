package com.intermediate.strings;

/*
 Rotate string
Problem Description

Given a string A, rotate the string B times in clockwise direction and return the string.



Problem Constraints
1 <= |A| <= 105

1 <= B <= 109

String A consist only of lowercase characters.



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the rotated string.



Example Input
Input 1:

 A = "scaler"
 B = 2
Input 2:

 A = "academy"
 B = 7


Example Output
Output 1:

 "erscal"
Output 2:

 "academy"


Example Explanation
Explanation 1:

 Rotate the given string twice so the string becomes "erscal".
 */
public class RotateString {

	public String solve(String A, int B) {
		int N = A.length();
		String result = "";
		if (N > +1 && N <= Math.pow(10, 5)) {
			if (B >= 1 && B <= Math.pow(10, 9)) {
				if (B > N) {
					B = B % N;
				}
				if (N != B) {
					result = A.substring(N-B, N) + A.substring(0, N-B);
				} else {
					return A;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		//System.out.println("scaler".substring(0, 4));
		
		
		  RotateString rotateString = new RotateString();
		  
		  System.out.println(rotateString.solve("scaler", 2));
		 
	}

}
