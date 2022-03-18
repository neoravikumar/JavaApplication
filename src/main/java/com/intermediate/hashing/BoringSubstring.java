package com.intermediate.hashing;

import java.util.Arrays;

/**
 Boring substring
Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Example Input
Input 1:

 A ="abcd"
Input 2:

 A = "aab"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:

 No arrangement of string A can make it free of boring substrings.
 */

public class BoringSubstring {
	
	public static boolean checkConsecutive(String s) {
		boolean ok = true;
		for (int i = 0; i + 1 < s.length(); ++i)
	        ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
	    return ok;
	}

	public int solve(String A) {
		
		/*
		 * String odd = "", even = "";
		 * 
		 * for (int i = 0; i < A.length(); ++i) { if (A.charAt(i) % 2 == 0) odd +=
		 * A.charAt(i); else even += A.charAt(i); }
		 * 
		 * // Sorting the two buckets char oddArray[] = odd.toCharArray();
		 * Arrays.sort(oddArray); odd = new String(oddArray);
		 * 
		 * char evenArray[] = even.toCharArray(); Arrays.sort(evenArray); even = new
		 * String(evenArray);
		 * 
		 * if (checkConsecutive(odd + even)) return 1; else if (checkConsecutive(even +
		 * odd)) return 1; return 0;
		 */
		
		String odd = "", even = "";
		 
	    // Loop to group the characters
	    // of the string into two buckets
	    for (int i = 0; i < A.length(); ++i)
	    {
	        if (A.charAt(i) % 2 == 0)
	            odd += A.charAt(i);
	        else
	            even += A.charAt(i);
	    }
	 
	    // Sorting the two buckets
	    char oddArray[] = odd.toCharArray();
	    Arrays.sort(oddArray);
	    odd = new String(oddArray);
	     
	    char evenArray[] = even.toCharArray();
	    Arrays.sort(evenArray);
	    even = new String(evenArray);
	     
	    // Condition to check if the
	    // concatenation point doesn't
	    // contains the monotonous string
	    if (checkConsecutive(odd + even))
	        return 1;
	    else if (checkConsecutive(even + odd))
	        return 1;
	    return 0;
		
		
		
	}

	public static void main(String[] args) {
		String str = "abcd";
	    int ans = new BoringSubstring().solve(str);
	    System.out.println( ans);

	}

}
