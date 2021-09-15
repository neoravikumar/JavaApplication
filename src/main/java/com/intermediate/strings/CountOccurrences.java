package com.intermediate.strings;

/**
 * Count Occurrences Problem Description
 * 
 * Find number of occurrences of bob in the string A consisting of lowercase
 * english alphabets.
 * 
 * 
 * 
 * Problem Constraints 1 <= |A| <= 1000
 * 
 * 
 * Input Format The first and only argument contains the string A consisting of
 * lowercase english alphabets.
 * 
 * 
 * Output Format Return an integer containing the answer.
 * 
 * 
 * Example Input Input 1:
 * 
 * "abobc" Input 2:
 * 
 * "bobob"
 * 
 * 
 * Example Output Output 1:
 * 
 * 1 Output 2:
 * 
 * 2
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * The only occurrence is at second position. Explanation 2:
 * 
 * Bob occures at first and third position.
 * 
 *
 */
public class CountOccurrences {

	public int solve(String A) {
		int N = A.length();
		A = A.toLowerCase();
		final String input = "bob";
		int count = 0;
		if (N >= 1 && N <= 1000) {
			
			if (N >= 1 && N <= 1000) {
				for (int start = 0, end = 3; end <= N; start++, end++) {
					String subString = A.substring(start, end);
					if (subString.equals(input)) {
						count++;
					}
				}
			}

		}
		return count;
	}

	public static void main(String[] args) {
		CountOccurrences countOccurrences = new CountOccurrences();
		int result = countOccurrences.solve("jhjhjh");
		/*
		 * String A = "BOBOB";
		 * 
		 * System.out.println(A.subSequence(0, 3)); System.out.println(A.subSequence(1,
		 * 4)); System.out.println(A.subSequence(2, 5));
		 */

		System.out.println(result);

	}

}
