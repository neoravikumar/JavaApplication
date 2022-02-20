package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Anagrams
Problem Description

Given an array A of N strings, return all groups of strings that are anagrams.

Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.

NOTE: Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'.



Problem Constraints
1 <= N <= 104

1 <= |A[i]| <= 104

Each string consists only of lowercase characters.

Sum of length of all the strings doesn't exceed 107



Input Format
Single Argument A which is an array of strings.



Output Format
Return a two-dimensional array where each row describes a group.

Note:

Ordering of the result :
You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.



Example Input
Input 1:

 A = [cat, dog, god, tca]
Input 2:

 A = [rat, tar, art]


Example Output
Output 1:

 [ [1, 4],
   [2, 3] ]
Output 2:

 [ [1, 2, 3] ]


Example Explanation
Explanation 1:

 "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).
Explanation 2:

 All three strings are anagrams.

 */
public class Anagrams {

	public ArrayList<ArrayList<String>> anagrams(final List<String> A) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		for (int i = 0; i < A.size(); i++) {
			String str = A.get(i);
			String key = buildAnagramsKey(str);

			if (!groups.containsKey(key)) {
				groups.put(key, new ArrayList<String>());
			}
			groups.get(key).add(str);
		}

		for (Map.Entry<String, List<String>> pair : groups.entrySet()) {
			result.add(pair.getValue());
		}

		return result;
	}

	public String buildAnagramsKey(String str) {
		int[] map = new int[26];

		for (Character c : str.toCharArray()) {
			map[c - 'a'] += 1;
		}
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			build.append(map[i]);
			build.append((char) (i + 'a'));
		}
		return build.toString();
	}

	public static void main(String[] args) {

	}

}
