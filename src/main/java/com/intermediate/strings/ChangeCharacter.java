package com.intermediate.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 Change character
Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
First argument is a string A.

Second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */
public class ChangeCharacter {

	public int solve(String A, int B) {

		int N = null != A ? A.length() : 0;

		HashMap<Character, Integer> charCount = new LinkedHashMap<Character, Integer>();

		StringBuilder sb = new StringBuilder(A);

		if (N >= 1 && N <= 100000) {
			if (B >= 0 && B < N) {
				charCount.put(sb.charAt(0), 0);
				for (int i = 0; i < sb.length(); i++) {
					if (charCount.containsKey(sb.charAt(i))) {
						int value = charCount.get(sb.charAt(i));
						charCount.put(sb.charAt(i), ++value);
					} else {
						charCount.put(sb.charAt(i), 1);
					}

				}

			}
		}
		Map<Character, Integer> sortByValueMap = charCount.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
						(entry1, entry2) -> entry2, LinkedHashMap::new));

		for (int k = 0; k < B; k++) {
			Map.Entry<Character, Integer> entry = sortByValueMap.entrySet().iterator().next();
			Character key = entry.getKey();

			Integer value = entry.getValue();
			if (value == 1) {
				sortByValueMap.remove(key, value);
			} else {
				value = value - 1;
				sortByValueMap.replace(key, value);
			}
		}
		return sortByValueMap.size();
	}

	public static void main(String[] args) {

		ChangeCharacter chnc = new ChangeCharacter();
		int result = chnc.solve("abcabbccd", 3);

		System.out.println("Total No of Character is :>>" + result);

	}

}
