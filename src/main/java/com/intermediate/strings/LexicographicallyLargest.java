package com.intermediate.strings;

/*
 Lexicographically Largest
You are given a string S. You want to change it to the lexicographically largest possible string by changing some of its characters. But you can only use characters of the string T as a replacement for characters of S. Formally, find the lexicographically largest string you can form by replacing some(or none) of the characters of S by using only the characters of string T. Note: Each character of T can be used at the most once.

Constraints:

1.   1 <= Length of S and T <= 50
2.   All the alphabets of S and T are lower case (a - z)
Input: A string A containing S and T separated by "_" character. (See example below)

Output: Lexicographically largest string P that can be formed by changing some or (none) characters of S using the characters of T.

Example:

Input:

A : "abb_c"
This implies S is "abb" and T is "c".

Output:

P = "cbb"
 */
public class LexicographicallyLargest {

	public String getLargest(String A) {
		StringBuilder input = null;

		String[] cString = A.toLowerCase().split("_");
		input = new StringBuilder(cString[0]);
		StringBuilder partString = new StringBuilder(cString[1]);
		int lastindex = 0;
		
		for(int i=0;i<input.length();i++) {
			char a = input.charAt(i);
			for (int j = 0; j < partString.length(); j++) {
				char b = partString.charAt(j);
				if (a < b) {
					a = b;
					lastindex = j;
				}
			}
			if(!(input.charAt(i) == a)) {
				input.replace(i, i + 1, Character.toString(a));
				partString.deleteCharAt(lastindex);
			}
		}
		return input.toString();
	}

	public static void main(String[] args) {
		LexicographicallyLargest lexicographicallyLargest = new LexicographicallyLargest();
		String result = lexicographicallyLargest
				.getLargest("psafelqnoe_eflqypyqecbrvxyoagogravxvlmrirxitihomztvjmenihqvfu");
		System.out.println(result);
	}

}
