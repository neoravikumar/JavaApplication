package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplicationOfPreviousAndNext {

	/*
	 * Multiplication of previous and next Given an array of integers A, update
	 * every element with multiplication of previous and next elements with
	 * following exceptions. a) First element is replaced by multiplication of first
	 * and second. b) Last element is replaced by multiplication of last and second
	 * last.
	 * 
	 * 
	 * Input Format
	 * 
	 * The only argument given is the integer array A. Output Format
	 * 
	 * Return the updated array. Constraints
	 * 
	 * 1 <= length of the array <= 100000 -10^4 <= A[i] <= 10^4 For Example
	 * 
	 * Input 1: A = [1, 2, 3, 4, 5] Output 1: [2, 3, 8, 15, 20]
	 * 
	 * Input 2: A = [5, 17, 100, 11] Output 2: [85, 500, 187, 1100]
	 */

	public ArrayList<Integer> solve(ArrayList<Integer> A) {

		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		final int N = null != A ? A.size() : null;
		if (N >= 1 && N <= 100000) {
			for (int i = 0; i < N; i++) {
				int value = A.get(i);
				if (value >= (-Math.pow(10, 4)) && value <= Math.pow(10, 4)) {
					int resultInt = 0;
					if (i == 0) {
						if(N ==1) {
							resultInt = A.get(i) * 1;
						}else {
							resultInt = A.get(i) * A.get(i + 1);
						}
						
					} else if (i == N - 1) {
						resultInt = A.get(N-1) * A.get(N-2);
					} else {
						resultInt = A.get(i-1) * A.get(i + 1);
					}
					
					resultArray.add(resultInt);
				}
			}
			//resultArray.forEach(a -> System.out.print(a + " "));
		}
		return resultArray;
	}

	public static void main(String[] args) {

		MultiplicationOfPreviousAndNext mpAndNext = new MultiplicationOfPreviousAndNext();

		List<Integer> arrays = Arrays.asList(1,2,3,4,5);
		//List<Integer> arrays = Arrays.asList( 0 );

		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.addAll(arrays);

		mpAndNext.solve(myList);

	}

}
