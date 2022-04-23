package com.intermediate.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 Evaluate Expression
Problem Description
An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.



Problem Constraints
1 <= N <= 105



Input Format
The only argument given is character array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
    9
Output 2:
    6


Example Explanation
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {
	
	public int evalRPN(ArrayList<String> A) {
		Stack<Integer> stack = new Stack<>();
        for (int i=0; i<A.size(); i++) {
            if ("*/-+".contains(A.get(i))) {
                int a = stack.pop();
                int b = stack.pop();
                
                if (A.get(i).equals("+")) {
                	stack.push(b+a);
                }
                else if (A.get(i).equals("-")) {
                	stack.push(b-a);
                }
                else if (A.get(i).equals("*")) {
                	stack.push(b*a);
                }
                else {
                	stack.push(b/a);
                }
            }
            else {
            	stack.push(Integer.parseInt(A.get(i)));
            }
        }
        return stack.peek();
	}

	public static void main(String[] args) {
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		int result = evaluateExpression.evalRPN(new ArrayList<String>(Arrays.asList("2", "1", "+", "3", "*")));
		System.out.println(result);
	}

}
