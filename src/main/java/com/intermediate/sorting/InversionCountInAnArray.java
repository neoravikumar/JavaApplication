package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Inversion count in an array
Problem Description
Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
 */
public class InversionCountInAnArray {

	public int solve(ArrayList<Integer> A) {
		int N = A.size();
		int ic = 0;

		// Brute Force Approach start
		for (int i = 0; i < N; i++) {
			for (int k = i + 1; k < N; k++) {
				if (A.get(i) > A.get(k)) {
					++ic;
				}
			}
		}
		// Brute Force Approach end
		ArrayList<Integer> temp = new ArrayList<Integer>();
		return mergeSort(A, temp, 0, A.size()-1);
	}

	private int mergeSort(ArrayList<Integer> originalArr, ArrayList<Integer> temp, int start, int end) {
		int inversion_count = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			inversion_count += mergeSort(originalArr, temp, start, mid);
			inversion_count += mergeSort(originalArr, temp, mid + 1, end);
			inversion_count += merge(originalArr, temp, start, mid + 1, end);
		}
		return inversion_count;

	}

	private int merge(ArrayList<Integer> originalArr, ArrayList<Integer> temp, int start, int mid, int end)
	{
	        int i = start;
	        int j = mid;
	        int k = start;
	        int inversion_count = 0;
	        while(i <= mid-1 && j<= end)
	        {
	            if(originalArr.get(i)< originalArr.get(j)) {
	            	temp.add( originalArr.get(i++));
	            	//temp.set(k++, originalArr.get(i++));
	            }
	            else{
	                inversion_count += mid-i;
	                temp.add( originalArr.get(j++));
	                //temp.set(k++, originalArr.get(j++));
	            }
	        }
	        while(i <= mid-1) {
	        	 //temp.set(k++, originalArr.get(i++));
	        	 temp.add( originalArr.get(i++));
	        }
	        while(j <= end) {
	        	 //temp.set(k++, originalArr.get(j++));
	        	 temp.add( originalArr.get(j++));
	        }
	        for(int a = start; a <= end; a++) {
	           //originalArr.set(a, temp.get(a)) ;
	           originalArr.add( temp.get(a));
	        }
	        return inversion_count;
	}

	public static void main(String[] args) {

		InversionCountInAnArray inAnArray = new InversionCountInAnArray();

		int result = inAnArray.solve(new ArrayList<Integer>(Arrays.asList(45, 10, 15, 25, 50)));
		System.out.println("Result is:>>" + result);

	}

}
