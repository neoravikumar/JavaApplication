package com.intermediate.strings;

/**
 Smallest Prefix String
Problem Description
Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.



Problem Constraints
1 <= N, M <= 100000



Input Format
The first argument is a string A of size N.
The second argument is a string B of size M.



Output Format
Return lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).



Example Input
Input 1:

 A = "abba"
 B = "cdd"
Input 2:

 A = "acd"
 B = "bay"


Example Output
Output 1:

 "abbac"
Output 2:

 "ab"


Example Explanation
Explanation 1:

 We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
 The lexicographically smallest string will be "abbac".
Explanation 2:

 We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
 The lexicographically smallest string will be "ab".
 */
public class SmallestPrefixString {
	
	public String smallestPrefix(String A, String B) {
		StringBuilder sb = new StringBuilder();
		sb.append(A.charAt(0));
		for (int i = 1; i < A.length(); i++) {
			
			if( A.charAt(i) < B.charAt(0)) {
				sb.append(A.charAt(i));
			}
			else {
				break;
			}
		}
		sb.append(B.charAt(0));
		return sb.toString();
	}

	public static void main(String[] args) {
		SmallestPrefixString smallestPrefixString = new SmallestPrefixString();
		String result =  smallestPrefixString.smallestPrefix("acd", "bay");
		//String result =  smallestPrefixString.smallestPrefix("twvvsl", "wtcyawv");
		System.out.println(result);

	}

}
