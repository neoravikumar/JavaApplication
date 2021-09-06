package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Elements Removal
Problem Description

Given an integer array A of size N. In one operation, you can remove any element from the array, and the cost of this operation is the sum of all elements in the array present before this operation.

Find the minimum cost to remove all elements from the array.



Problem Constraints
0 <= N <= 1000
1 <= A[i] <= 103



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the total cost of removing all elements from the array.



Example Input
Input 1:

 A = [2, 1]
Input 2:

 A = [5]


Example Output
Output 1:

 4
Output 2:

 5*/
public class ElementsRemoval {

	public int solve(ArrayList<Integer> A) {
		int N = null != A ? A.size() : 0;
		Long result = new Long(0L);
		int lElement = 0;

		if (N >= 1 && N <= 1000) {
			Collections.sort(A,Collections.reverseOrder());
			
			
			for (int a : A) {
				if (a >= 1 && a <= Math.pow(10, 3)) {
					result 
				}
			}
			if(N>1) {
				if()
				lElement = A.get(N-1);
				result += lElement;
			}
		}
		return result.intValue();
	}

	public static void main(String[] args) {

		ElementsRemoval elementsRemoval = new ElementsRemoval();
		List<Integer> lst = Arrays.asList(8, 0, 10 );
		// List<Integer> lst = Arrays.asList(-4, -2, 0, -1, -6 );

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(elementsRemoval.solve(abc));
	}

}
