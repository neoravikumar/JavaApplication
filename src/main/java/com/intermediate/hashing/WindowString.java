package com.intermediate.hashing;

/*
 Window String
Problem Description

Given a string A and a string B, find the window with minimum length in A which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index )


Problem Constraints
1 <= size(A), size(B) <= 106



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return a string denoting the minimum window.



Example Input
Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"


Example Output
Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation
Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.
 */
public class WindowString {

	public String minWindow(String A, String B) {
		
		int[] needToFind = new int[256];
	    int[] hasFound = new int[256];

	    for(int i = 0; i < B.length(); ++i) {
	       needToFind[B.charAt(i)]++;
	    }
	    
	    int count = 0;
	    int minWindowSize = Integer.MAX_VALUE;
	    int start = 0, end = -1;
	    String window = "";
	    
	    while (++end < A.length()) {
	        char c = A.charAt(end);
	        if(++hasFound[c] <= needToFind[c]) {
	           count++;
	        }

	        if(count < B.length()) continue;
	        while (hasFound[A.charAt(start)] > needToFind[A.charAt(start)]) {
	           hasFound[A.charAt(start++)]--;
	        }

	        if(end - start + 1 < minWindowSize) {
	           minWindowSize = end - start + 1;
	           window = A.substring(start, end + 1);
	        }
	    }
	    return window;
		
	}

	public static void main(String[] args) {
		
		WindowString windowString = new WindowString();
		String result = windowString.minWindow("Aa91b", "ab");
		System.out.println(result);

	}

}
