package com.intermediate.stack;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/**
Alternating sequence

You are given a string A where each character is either a '+' or a '-'. Here, '+' 
means increment the current variable and '-' means decrement the current variable. 
Lets assume that we always start with current variable as 0.

So, for example if A = '++-+----', then the values of the variable will be [0, 1, 2, 1, 2, 1, 0, -1, -2] 
Explanation : Variable = 0 in the beginning. After the first '+', 
Variable becomes 1. With second '+', Variable becomes 2. With the third character as '-', Variable becomes 1 and so on.

In the above example, the maximum value variable takes is 2 and the minimum value it takes is -1. 
The range of the variable is the difference between the max and min value it takes, 
which in this case will be 2 - (-1) = 3.

You have to find a subsequence of the given string A which maximizes the range of the variable. Return the integer corresponding to the max range possible.

Example :

Input : "+++++", Output : 5 
Input : "++-+----", Output : 5 ( The subsequence as "++-----" )
Constraints :

  1 <= length(A) <= 2500
 */
public class AlternatingSequence {
	
	public int solve(String A) {

		int ncounter = -1, pcounter = -1;
		
		char[] myChar = A.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<myChar.length; i++) {
			if(myChar[i]=='+') {
				stack.push(myChar[i]);
				pcounter +=1; 
				
			}else if(myChar[i]=='-') {
				if(stack.isEmpty()) {
					stack.push(myChar[i]);
					ncounter++;
				}
				else {
					stack.pop();
					if(ncounter == -1) {
						ncounter++;
					}else {
						ncounter--;
					}
					
				}
			}
		}
		return Math.subtractExact(pcounter, ncounter);
	}

	public static void main(String[] args) {

		AlternatingSequence alternatingSequence = new AlternatingSequence();
		int result = alternatingSequence.solve("++-+----");
		System.out.println(result);

	}

}
