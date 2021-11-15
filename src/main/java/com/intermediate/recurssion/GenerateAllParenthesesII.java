package com.intermediate.recurssion;

import java.util.ArrayList;

/*
 Generate all Parentheses II
Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.



Problem Constraints
1 <= A <= 20



Input Format
First and only argument is integer A.



Output Format
Return a sorted list of all possible paranthesis.



Example Input
Input 1:

A = 3
Input 2:

A = 1


Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]


Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.
 */
public class GenerateAllParenthesesII {

	public ArrayList<String> generateParenthesis(int A) {

		ArrayList<String> res = new ArrayList<String>();
		StringBuilder temp = new StringBuilder();
		generateParenthesis(A, A, res, temp);
		return res;

	}

	private void generateParenthesis(int closeCount, int openCount, ArrayList<String> res, StringBuilder temp) {
		if (openCount == 0 && closeCount == 0) {
			res.add(temp.toString());
		}

		if (openCount > 0) {
			temp.append("(");
			generateParenthesis(closeCount, openCount - 1, res, temp);
			temp.deleteCharAt(temp.length() - 1);
		}

		if (closeCount > openCount) {
			temp.append(")");
			generateParenthesis(closeCount - 1, openCount, res, temp);
			temp.deleteCharAt(temp.length() - 1);
		}
	}
	

	public static void main(String[] args) {
		GenerateAllParenthesesII generateAllParenthesesII = new GenerateAllParenthesesII();
		ArrayList<String> result = generateAllParenthesesII.generateParenthesis(3);
		System.out.println(result);
	}

}
