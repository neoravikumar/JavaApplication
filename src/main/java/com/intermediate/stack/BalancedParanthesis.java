package com.intermediate.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 Balanced Paranthesis
Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the paranthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output
Output 1:

 1 
Output 2:

 0 
Output 3:

 1 


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
public class BalancedParanthesis {
	
	public int solve(String A) {
		
		char[] myinputArray = A.toCharArray();
		Map<Character, Integer> mymap = new HashMap<>();
		Stack<Integer> myStack = new Stack<>();

		for (char a : myinputArray) {

			switch (a) {
			case '{':
				mymap.put('{', 1);
				break;
			case '}':
				mymap.put('}', 10);
				break;
			case '(':
				mymap.put('(', 2);
				break;
			case ')':
				mymap.put(')', 20);
				break;
			case '[':
				mymap.put('[', 3);
				break;
			case ']':
				mymap.put(']', 30);
				break;
			default:
			}
		}

		for (char a : myinputArray) {
			int getValue = mymap.get(a);
			
			if (!myStack.isEmpty() && myStack.peek()*10 == getValue) {
				myStack.pop();
			}else {
				myStack.push(getValue);
			}
		}

		if (myStack.isEmpty()) {
			return 1;
		}
		return 0;
		
		/*
		 String opening = "{([";
        String closing = "})]";
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : A.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char temp = stack.pop();
                if (opening.indexOf(temp) != closing.indexOf(c)) {
                    return 0;
                }
            }
        }
        
        return stack.isEmpty() == true ? 1 : 0;
		 */
	}

	public static void main(String[] args) {
		BalancedParanthesis balancedParanthesis = new BalancedParanthesis();
		int result = balancedParanthesis.solve("{([)}");
		System.out.println(result);

	}

}
