package com.intermediate.arithmetic.primeNumber;

import java.util.HashMap;
import java.util.Map;


/*
 Excel Column Title
Problem Description

Given a positive integer A, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 


Problem Constraints
1 <= A <= 109



Input Format
First and only argument of input contains single integer A



Output Format
Return a string denoting the corresponding title.



Example Input
Input 1:

A = 3
Input 2:

 
A = 27


Example Output
Output 1:

"C"
Output 2:

"AA"


Example Explanation
Explanation 1:

 
3 corrseponds to C.
Explanation 2:

    1 -> A,
    2 -> B,
    3 -> C,
    ...
    26 -> Z,
    27 -> AA,
    28 -> AB 
 */
public class ExcelColumnTitle {

	public String convertToTitle(int A) {
		
		Map<Integer, Character> charMap = new HashMap<Integer, Character>();
		StringBuilder restultString = new StringBuilder();
		int alpha = 64;
		for(int i=1;i<=26;i++) {
			charMap.put(i, (char)++alpha);
		}
		
		if(A%26==0) {
			A = A/26;
			if(A>=1) {
				for(int k=1;k<=A;k++) {
					restultString.append('Z');
				}
			}
			return restultString.toString();
		}else {
			while(A > 1) {
				int k = A%26;
				A= A/26;
				restultString.append((char)A);
				restultString.append((char)k);
			}
		}
		return restultString.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ExcelColumnTitle().convertToTitle(53));
	}

}
