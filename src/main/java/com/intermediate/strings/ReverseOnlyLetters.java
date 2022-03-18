package com.intermediate.strings;

import java.util.Stack;

/**
 Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
 */
public class ReverseOnlyLetters {
	
	public String solve(String s) {
		
		Stack<Character> myCharStack = new Stack<>();
		// Push all the letters in to stack
		for(char c : s.toCharArray()) {
			if(Character.isLetter(c)) {
				myCharStack.push(c);
			}
		}
		
		StringBuilder result = new StringBuilder();
		// pop only letter from the stack
		for(char c : s.toCharArray()) {
			if(Character.isLetter(c)) {
				result.append(myCharStack.pop());
			}else {
				result.append(c);
			}
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
		String result = reverseOnlyLetters.solve("ab123cd");
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
