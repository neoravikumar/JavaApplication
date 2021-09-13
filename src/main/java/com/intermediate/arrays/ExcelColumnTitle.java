package com.intermediate.arrays;

import java.util.HashMap;

import com.sun.javafx.binding.StringFormatter;

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

		String result = "";
		HashMap<Integer, Character> alphabetMap = new HashMap<Integer, Character>();
		for (int a = 65, i = 1; a <= 90; a++, i++) {
			char al = (char) a;
			alphabetMap.put(i, al);
		}

		if (A >= 1 && A <= Math.pow(10, 9)) {
			while (A != 0) {
				int number = A % 26;
				if (number == 0) {
					result += 'Z';
					A = (A / 26) - 1;
				}else {
					if (alphabetMap.containsKey(number)) {
						result += alphabetMap.get(number);
					}
					A = A / 26;
				}
				
				
			}

		}

		StringBuilder sb = new StringBuilder(result);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {

		ExcelColumnTitle excelColumnNumber = new ExcelColumnTitle();
		String result = excelColumnNumber.convertToTitle(705);
		// BCSUS -- 980089
		// 943566 -- BAQTZ
		System.out.println("The Column Title is:>>" + result);

	}

}
