package com.intermediate.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 tolower()
Problem Description

You are given a function to_lower() consisting of a character array A.

Convert each charater of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.

Return the lowercase version of the given character array.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return the lowercase version of the given character array.



Example Input
Input 1:

 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2:

 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
Output 2:

 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Explanation
Explanation 1:

 All the characters in the returned array are in lowercase alphabets.


 */
public class Tolower {

	public ArrayList<Character> to_lower(ArrayList<Character> A) {

		HashMap<Character, Character> listMap = new HashMap<Character, Character>();
		
		for(int a=65, k=97;a<=90;a++,k++) {
			char cvalue = (char) k;
			char cKey = (char) a;
			listMap.put(cKey, cvalue);
		}

		int index =0;
		for(char a : A) {
			
			if(listMap.containsKey(a)) {
				A.set(index, listMap.get(a));
			}
			index++;
		}
		
		return A;
	}

	public static void main(String[] args) {

		Tolower tolower = new Tolower();
		List<Character> lst = Arrays.asList('R', 'a', 'j', 'a', '#');

		ArrayList<Character> abc = new ArrayList<Character>();
		abc.addAll(lst);

		int abv = 'z';
		System.out.println(abv);

		System.out.println(tolower.to_lower(abc));

	}

}
