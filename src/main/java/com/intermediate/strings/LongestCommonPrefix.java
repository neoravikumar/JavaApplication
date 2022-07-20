package com.intermediate.strings;

import java.util.*;

/*
 Longest Common Prefix
Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(ArrayList<String> A) {

		int N = null != A ? A.size() : 0;
		StringBuilder sb = new StringBuilder();

		Collections.sort(A,  Comparator.comparingInt(String::length));
		if (N >= 0 && N <= 1000000) {
			boolean isNotAdd = false;

			for (int i = 0; i < A.get(0).length(); i++) {

				for (int k = 1; k < N; k++) {
					if (A.get(0).charAt(i) != A.get(k).charAt(i)) {
						isNotAdd = true;
						break;
					}
				}
				if (!isNotAdd) {
					sb.append(A.get(0).charAt(i));
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();

		List<String> arrays = Arrays.asList("abab", "abdc", "abcd");
		//List<String> arrays = Arrays.asList("abcdefgh", "aefghijk", "abcefgh");
		ArrayList<String> abc = new ArrayList<String>();
		abc.addAll(arrays);
		String result = lcp.longestCommonPrefix(abc);

		System.out.println(result);

	}

}
