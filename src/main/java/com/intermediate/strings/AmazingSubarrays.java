package com.intermediate.strings;

import java.util.ArrayList;
import java.util.List;

/*
 Amazing Subarrays
You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubarrays {

	public int solve(String A) {
		A = A.toLowerCase();
		// StringBuilder sb= new StringBuilder(A.toLowerCase());
		char[] sbArray = A.toCharArray();

		/*
		 * ArrayList<Integer> vowelArray = new ArrayList<Integer>();
		 * vowelArray.add(Integer.valueOf('a')); vowelArray.add(Integer.valueOf('e'));
		 * vowelArray.add(Integer.valueOf('i')); vowelArray.add(Integer.valueOf('o'));
		 * vowelArray.add(Integer.valueOf('u'));
		 */
		
		/*
		 * Actually, the second loop is not needed as you could see that there is no use
		 * of k in the nested loop. You just need to find how many subarrays are
		 * possible starting at index j. That is A.size()-j; so just check of jth
		 * character is vowel then just add A.size()-j in the answer.
		 */

		int count = 0;
		for (int j = 0; j < A.length(); j++) {
			int a = sbArray[j];
			if (a == 97 || a == 101 || a == 105 || a == 111 || a == 117) {
				count += A.length()-j;
			}
		}
		
		return count % 10003;
	}

	public static void main(String[] args) {

		AmazingSubarrays amazingSubarrays = new AmazingSubarrays();
		int result = amazingSubarrays.solve("ABEC");
		System.out.println(result);

	}

}
