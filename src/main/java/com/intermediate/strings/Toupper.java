package com.intermediate.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*toupper()
Problem Description

You are given a function to_upper() consisting of a character array A.

Convert each charater of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.

Return the uppercase version of the given character array.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return the uppercase version of the given character array.



Example Input
Input 1:

 A = ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2:

 A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']


Example Output
Output 1:

 ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y']
Output 2:

 ['S', 'C', 'A', 'L', 'E', 'R', '#', '2', '0', '2', '0']


Example Explanation
Explanation 1:

 All the characters in the returned array are in uppercase alphabets.*/
public class Toupper {

	public ArrayList<Character> to_upper(ArrayList<Character> A) {

		HashMap<Character, Character> listMap = new HashMap<Character, Character>();

		for (int a = 97, k = 65; a <= 122; a++, k++) {
			char cvalue = (char) k;
			char cKey = (char) a;
			listMap.put(cKey, cvalue);
		}

		int index = 0;
		for (char a : A) {

			if (listMap.containsKey(a)) {
				A.set(index, listMap.get(a));
			}
			index++;
		}

		return A;
	}

	public static void main(String[] args) {
		Toupper tolower = new Toupper();
		List<Character> lst = Arrays.asList('R', 'a', 'J', 'a', '#');

		ArrayList<Character> abc = new ArrayList<Character>();
		abc.addAll(lst);

		System.out.println(tolower.to_upper(abc));

	}

}
