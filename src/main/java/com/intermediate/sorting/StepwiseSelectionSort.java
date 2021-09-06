package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Stepwise Selection Sort!
Problem Description

Given an integer array A of size N.

You need to sort the elements in increasing order using SelectionSort. Return a array containing the min value's index position before every iteration.

NOTE:

Consider 0 based indexing while looking for min value in each step of selection sort.
There will be total N - 1 iterations in selection sort so the output array will contain N - 1 integers.


Problem Constraints
2 <= N <= 104

1 <= A[i] <= 106

All elements are distinct in array A.



Input Format
First and only argument is an integer array A.



Output Format
Return an integer array containing N - 1 integers denoting min value's index position before every iteration.



Example Input
Input 1:

 A = [6, 4, 3, 7, 2, 8]


Example Output
Output 1:

 [4, 2, 2, 4, 4]


Example Explanation
Explanation 1:

 Explanation : 6 4 3 7 2 8 : Index of 1st min - 4
 After 1st Iteration : 2 4 3 7 6 8 : Index of 2nd min - 2
 After 2nd Iteration : 2 3 4 7 6 8 : Index of 3rd min - 2
 After 3rd Iteration : 2 3 4 7 6 8 : Index of 4th min - 4
 After 4th iteration : 2 3 4 6 7 8 : Index of 5th min - 4
 After 5th iteration. : 2 3 4 6 7 8.*/
public class StepwiseSelectionSort {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int min = Integer.MAX_VALUE;

		int N = null != A ? A.size() : 0;
		if (N >= 2 && N <= Math.pow(10, 4)) {
			
			for(int i=0 ; i < N ; i++) {
				findMinAndSwap(A, result,min, i);
			}
			
		}
		result.remove(N-1);
		return result;
	}

	private void findMinAndSwap(ArrayList<Integer> A, ArrayList<Integer> result, int min, int startindex) {
		int findindex = 0;
		for (int i = startindex; i <  A.size(); i++) {
			int value = A.get(i);
			if (value >= 1 && value <= Math.pow(10, 6)) {
				if (value < min) {
					min = value;
					findindex = i;
				}

			}
		}
		
		int temp = A.get(startindex);
		A.set(findindex, temp);
		A.set(startindex,min);
		result.add(findindex);
	}

	public static void main(String[] args) {

		StepwiseSelectionSort stepwiseSelectionSort = new StepwiseSelectionSort();

		List<Integer> lst = Arrays.asList(6, 4, 3, 7, 2, 8);
		// List<Integer> lst = Arrays.asList(-4, -2, 0, -1, -6 );

		ArrayList<Integer> datas = new ArrayList<Integer>();
		datas.addAll(lst);

		ArrayList<Integer> result = stepwiseSelectionSort.solve(datas);

		System.out.println("=========== Result =====================:");
		result.forEach(a -> System.out.print(a));

	}

}
