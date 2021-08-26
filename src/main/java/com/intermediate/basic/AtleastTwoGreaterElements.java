package com.intermediate.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Elements which have at-least two greater elements
Problem Description

You are given an array of distinct integers A, you have to find and return all elements in array which have at-least two greater elements than themselves.

NOTE: The result should have the order in which they are present in the original array.



Problem Constraints
3 <= |A| <= 105

-109 <= A[i] <= 109

Input Format
First and only argument is an integer array A.

Output Format
Return an integer array containing the elements of A which have at-least two greater elements than themselves in A.



Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [11, 17, 100, 5]
Example Output
Output 1:
 [1, 2, 3]
Output 2:
 [11, 5]*/

public class AtleastTwoGreaterElements {

	public List solve(List A) {
		ArrayList resultArray = new ArrayList<Integer>();
		if (null != A && (A.size() >= 3 && A.size() <= Math.pow(10, 5))) {
			int index = 0;
			for (int k = 0; k < A.size(); k++) {
				int value = (Integer) A.get(k);
				if (value > Math.pow(-10, 9) && value < Math.pow(10, 9)) {
					int counter = 0;
					for (int i = 0; i < A.size(); i++) {
						int newValue = (Integer) A.get(i);
						if (value < newValue) {
							counter++;
						}
						if (counter == 2) {
							resultArray.add( value) ;
							index++;
							break;
						}
					}

				}
			}
		}
		return resultArray;
	}

	public static void main(String[] args) {

		AtleastTwoGreaterElements abc = new AtleastTwoGreaterElements();
		ArrayList finalInput = new ArrayList<Integer>();
		finalInput.add(0);
		finalInput.add(10101);
		finalInput.add(-1010101);
		
		
		System.out.println(abc.solve(finalInput));

	}

}
