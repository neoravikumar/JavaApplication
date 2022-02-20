package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Maximum Unsorted Subarray Problem Description
 * 
 * Given an array A of non-negative integers of size N. Find the minimum
 * sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that
 * sub-array, then the whole array should get sorted. If A is already sorted,
 * output -1.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 1000000 1 <= A[i] <= 1000000
 * 
 * 
 * 
 * Input Format First and only argument is an array of non-negative integers of
 * size N.
 * 
 * 
 * 
 * Output Format Return an array of length 2 where First element denotes the
 * starting index(0-based) and second element denotes the ending index(0-based)
 * of the sub-array. If the array is already sorted, return an array containing
 * only one element i.e. -1.
 * 
 * 
 * 
 * Example Input 
 * 
 * Input 1:
 * 
 * A = [1, 3, 2, 4, 5] 
 * 
 * Input 2:
 * 
 * A = [1, 2, 3, 4, 5]
 * 
 * 
 * Example Output Output 1:
 * 
 * [1, 2] Output 2:
 * 
 * [-1]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * If we sort the sub-array A1, A2, then the whole array A gets sorted.
 * Explanation 2:
 * 
 * A is already sorted.
 *
 */
public class MaximumUnsortedSubarray {

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// Approach
		//1. Create a copy of an Array
		//2. Sort the copied array
		//3. Create the start and end variable
		//4. Compare from last and start and store the value in mapping.
		//5. Create the result array and return.MaximumUnsortedSubarray
		
		int startIndex = -1;
		int endIndex = -1;
		ArrayList<Integer> copyArray = new ArrayList<>(A);
		Collections.sort(copyArray);
		
		for(int i=0;i<A.size();i++) {
			if(A.get(i) != copyArray.get(i)) {
				startIndex=i;
				break;
			}
		}
		
		for(int i=A.size()-1;i>=0;i--) {
			if(A.get(i) != copyArray.get(i)) {
				endIndex=i;
				break;
			}
		}
		
		if(startIndex == -1 && endIndex == -1) {
			result.add(-1);
		}
		else {
			result.add(startIndex);
			result.add(endIndex);
		}
		
		return result;
	}

	public static void main(String[] args) {
		MaximumUnsortedSubarray maximumUnsortedSubarray = new MaximumUnsortedSubarray();
		ArrayList<Integer>  result = maximumUnsortedSubarray.subUnsort(new ArrayList<Integer>(Arrays.asList(1, 3, 2, 4, 5)));
		System.out.println(result);

	}

}
