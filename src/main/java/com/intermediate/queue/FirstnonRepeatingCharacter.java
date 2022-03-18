package com.intermediate.queue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
First non-repeating character
Problem Description

Given a string A denoting a stream of lowercase alphabets.

You have to make new string B. B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. if no non-repeating character is found then append '#' at the end of B.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string B after processing the stream of lowercase alphabets A.



Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output
Output 1:

"aabbdd"
Output 2:

"aaabc#"


Example Explanation
Explanation 1:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
 */
public class FirstnonRepeatingCharacter {

	public String solve(String A) {
		StringBuilder answer = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character a : A.toCharArray()) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
			queue.add(a);
			while (!queue.isEmpty() && map.get(queue.element()) > 1) {
				queue.poll();
			}
			if (!queue.isEmpty()) {
				//answer += queue.element();
				answer.append(queue.element());
			} else {
				answer.append('#');
				//answer += '#';
			}
		}
		return answer.toString();
	}

	public static void main(String[] args) {
		FirstnonRepeatingCharacter firstnonRepeatingCharacter = new FirstnonRepeatingCharacter();
		String result = firstnonRepeatingCharacter.solve("abcabc");
		System.out.println(result);

	}

}
