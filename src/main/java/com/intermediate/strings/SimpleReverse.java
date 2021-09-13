package com.intermediate.strings;

/*Simple Reverse
Problem Description

Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints
1 <= |A| <= 105

String A consist only of lowercase characters.



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the reversed string.



Example Input
Input 1:

 A = "scaler"
Input 2:

 A = "academy"


Example Output
Output 1:

 "relacs"
Output 2:

 "ymedaca"


Example Explanation
Explanation 1:

 Reverse the given string.
 */
public class SimpleReverse {

	public String solve(String A) {
		int N = A.length();
		char[] inputArray = A.toCharArray();
		if (N >= 1 && N <= Math.pow(10, 5)) {
			for(int i=0, j=N-1; j>=i;i++,j--) {
				swap(inputArray, i, j);
			}
		}
		return new String(inputArray);
	}
	
	private void swap(char[] inputArray,int a, int b) {
		
		char temp = inputArray[a];
		inputArray[a] = inputArray[b];
		inputArray[b] = temp;
	}
	

	public static void main(String[] args) {
		SimpleReverse simpleReverse = new SimpleReverse();

		System.out.println(simpleReverse.solve("Raja"));

	}

}
