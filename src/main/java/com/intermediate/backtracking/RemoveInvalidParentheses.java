package com.intermediate.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
Remove Invalid Parentheses
Problem Description

Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

Return all possible results.

You can return the results in any order.



Problem Constraints
1 <= length of the string <= 20



Input Format
The only argument given is string A.



Output Format
Return all possible strings after removing the minimum number of invalid parentheses.



Example Input
Input 1:

 A = "()())()"
Input 2:

 A = "(a)())()"


Example Output
Output 1:

 ["()()()", "(())()"]
Output 2:

 ["(a)()()", "(a())()"]


Example Explanation
Explanation 1:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"
Explanation 2:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"
 */
public class RemoveInvalidParentheses {
	
	
	
	

	public static void main(String[] args) {
		RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
		ArrayList<String> result = removeInvalidParentheses.solve("()())()");
		System.out.println(result);

	}
	
	private Set<String> valid = new HashSet<>();
    private int min = Integer.MAX_VALUE;
	
	 public ArrayList<String> solve(String A) {
		 backTrack(A, 0, 0, 0, 0, new StringBuilder());
	        return new ArrayList<>(valid.stream().collect(Collectors.toList())); // convert out set to a list
	    }
	 
	 private void backTrack(String s, int l, int r, int i, int removed, StringBuilder sb) {
	        if (removed > min) // no point in exploring a sub-optimal solution
	            return;
	        
	        if (i == s.length()) { // traversed the entire string
	            if (l == r) { // is valid
	                if (min > removed) // we found a smaller solution, so reset
	                    valid.clear();
	                min = removed;
	                valid.add(sb.toString());
	            }
	            return;
	        }
	        
	        int len = sb.length();
	        char c = s.charAt(i);
	        if (c != '(' && c != ')') { // always keep non-parens char
	            sb.append(c);
	            backTrack(s, l, r, i+1, removed, sb);
	        } else {
	        	backTrack(s, l, r, i+1, removed+1, sb); // consider sequence without current char
	            sb.append(c); // now consider WITH the current char
	            if (c == '(') {
	            	backTrack(s, l+1, r, i+1, removed, sb);
	            } else if (r < l) { // ensures adding ")" to current SB remains valid
	            	backTrack(s, l, r+1, i+1, removed, sb);
	            }
	        }
	        sb.deleteCharAt(len); // backtrack
	    }
	 
	 
}
