package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String,ArrayList<Integer>> anagramMap = new HashMap<>();
        int i=0;
        for(String a : A){
            String key = getSortedString(a);
            if(!anagramMap.containsKey(key)){
                ArrayList<Integer> first = new ArrayList<>();
                first.add(++i);
                anagramMap.put(key,first);
                continue;
            }
            anagramMap.get(key).add(++i);
        }

        return new ArrayList<>(anagramMap.values());
    }

    String getSortedString(String value){
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(char c : value.toCharArray()){
            if(!freqMap.containsKey(c)){
                freqMap.put(c,1);
                continue;
            }
            freqMap.put(c,freqMap.get(c)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i='a';i<='z';i++){
            if(!freqMap.containsKey((char)i)){
                continue;
            }
            for(int j =0;j<freqMap.get((char)i);j++){
                sb.append((char)i);
            }
        }

        return sb.toString();
    }

	public static void main(String[] args) {

		Anagrams anagrams = new Anagrams();
		//ArrayList<ArrayList<String>> result = anagrams.anagrams(Arrays.asList("cat", "dog", "god", "tca"));
		ArrayList<ArrayList<Integer>> result = anagrams.anagrams(Arrays.asList("rat", "tar", "art"));
		result.stream().forEach(a -> System.out.println(a));
		
	}

}
