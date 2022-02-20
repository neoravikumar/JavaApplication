package com.intermediate.hashing;

import java.util.HashMap;

/*
 Longest Substring Without Repeat
Problem Description

Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format
Single Argument representing string A.



Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input
Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) {

		int ans = 0;
		int j = -1;
		int i = -1;
		HashMap<Character, Integer> charMap = new HashMap<>();
		
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			// Acquire
			while (i < A.length() - 1) {
				f1 = true;
				i++;
				char ch = A.charAt(i);
				charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
				if (charMap.get(ch) == 2) {
					break;
				} else {
					int len = i - j;
					if (len > ans) {
						ans = len;
					}
				}
			}

			// Release
			while (j < i) {
				f2 = true;
				j++;
				char ch = A.charAt(j);
				charMap.put(ch, charMap.get(ch) - 1);
				if (charMap.get(ch) == 1) {
					break;
				}
			}

			if (f1 == false && f2 == false) {
				break;
			}
		}
		return ans;
	}
	
	
	
	public int lengthOfLongestSubstring2(String A) {
		HashMap<Character, Integer> myMap = new HashMap<>();
		int max_ans = 0;
		int start = 0;
		for (int end = 0; end < A.length(); end++) {
			if (myMap.containsKey(A.charAt(end))) {
				start = Math.max(start, myMap.get(A.charAt(end)) + 1);
			}
			myMap.put(A.charAt(end), end);
			max_ans = Math.max(max_ans, end - start + 1);
		}
		return max_ans;
	}
	

	public static void main(String[] args) {
		LongestSubstringWithoutRepeat longestSubstringWithoutRepeat = new LongestSubstringWithoutRepeat(); 
		int ans = longestSubstringWithoutRepeat.lengthOfLongestSubstring("abcabcbb");
		System.out.println(ans);
		

		int ans2 = longestSubstringWithoutRepeat.lengthOfLongestSubstring2("abcabcbb");
		System.out.println(ans2);

		

	}

}
