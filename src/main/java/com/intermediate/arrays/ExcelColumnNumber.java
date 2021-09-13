package com.intermediate.arrays;

import java.util.HashMap;

/*
 Excel Column Number
Problem Description

Given a column title as appears in an Excel sheet, return its corresponding column number.



Problem Constraints
1 <= length of the column title <= 5



Input Format
Input a string which represents the column title in excel sheet.



Output Format
Return a single integer which represents the corresponding column number.



Example Input
Input 1:

 AB
Input 2:

 ABCD


Example Output
Output 1:

 28
Output 2:

 19010


Example Explanation
Explanation 1:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 
 
 */
public class ExcelColumnNumber {

	public int titleToNumber(String A) {

		char[] cloumnTitle = A.toUpperCase().toCharArray();
		HashMap<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
		for (int a = 65, i = 1; a <= 90; a++, i++) {
			char al = (char) a;
			alphabetMap.put(al, i);
		}

		int columnNumber = 0;
		int N = cloumnTitle.length;
		if (N >= 1 && N <= 5) {
			for (int i = N - 1,k=0; i >= 0; i--,k++) {
				if (alphabetMap.containsKey(cloumnTitle[i])) {
					columnNumber += (int) ((alphabetMap.get(cloumnTitle[i])%27)*Math.pow(26, k));
				}

			}
		}

		return columnNumber;

	}

	public static void main(String[] args) {

		ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
		int result = excelColumnNumber.titleToNumber("ABCD");
		System.out.println("The Column Nmber is:>>" + result);

	}

}
