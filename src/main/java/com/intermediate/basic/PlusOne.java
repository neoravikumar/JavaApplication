package com.intermediate.basic;

import java.util.ArrayList;

/*
 * Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: 
for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class PlusOne {
	
	public ArrayList<Integer> plusOne2(ArrayList<Integer> A) {
        
		
		  int lastIndex = A.size()-1; A.set(lastIndex, A.get(lastIndex)+1);
		  
		  if(A.get(0) == 0) { A.remove(0); }
		  
		  return A;
		 
		
		
    }
	
	public Integer[] plusOne(Integer[] A) {

        int lastIndex = A.length-1;
        A[lastIndex] = A[lastIndex]+1;
		/*
		 * if(A[0] == 0) { A.remove(0); }
		 */
       
       return A;

   }

	public static void main(String[] args) {
		
		PlusOne plusone = new PlusOne();
		
		ArrayList<Integer> sampleList = new ArrayList<Integer>();
		sampleList.add(0);
		sampleList.add(1);
		sampleList.add(2);
		sampleList.add(4);
		
		Integer[] arr = new Integer[sampleList.size()];
        arr = sampleList.toArray(arr);
        
        Integer[] result = plusone.plusOne(arr);

        for(int i=0;i<result.length;i++) {
        	System.out.println(result[i]);
        }
        
		
	}
}
