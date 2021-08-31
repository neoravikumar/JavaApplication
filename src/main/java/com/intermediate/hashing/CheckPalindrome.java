package com.intermediate.hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*Check Palindrome!
Problem Description

Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.



Input Format
First argument is an string A.



Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Example Input
Input 1:

 A = "abcde"
Input 2:

 A = "abbaee"


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No possible rearrangement to make the string palindrome.
Explanation 2:

 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.*/
public class CheckPalindrome {

	public int solve(String A) {

		Map<Character, Integer> mapOne = new HashMap<Character, Integer>();

		if (null != A && (A.length() >= 1 && A.length() <= Math.pow(10, 5))) {
			String inputString = A.toLowerCase();

			char[] charList = inputString.toCharArray();

			for (Character a : charList) {
				if (mapOne.containsKey(a)) {
					int value = mapOne.get(a);
					mapOne.put(a, value + 1);
				} else {
					mapOne.put(a, 1);
				}
			}

			int oddCounter = 0;
			
			if (inputString.length() % 2 == 0) {
				for (Integer b : mapOne.values()) {
					if (b % 2 != 0) {
						return 0;
					}
				}

			} else {
				for (Integer b : mapOne.values()) {
					if (b % 2 != 0) {
						oddCounter++;
						if(oddCounter>1) {
							return 0;
						}
					}
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		CheckPalindrome checkPalindrome = new CheckPalindrome();
		int isPalindrome = checkPalindrome.solve("abbaee");
		System.out.println("Palindrome: ( 0:false, 1:true)>>" + isPalindrome);

	}

}
