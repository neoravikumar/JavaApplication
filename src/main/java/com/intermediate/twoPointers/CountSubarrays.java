package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Count Subarrays
Problem Description

Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

Since the number of subarrays could be large, return value % 109 +7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106



Input Format
The only argument given is an Array A, having N integers.



Output Format
Return the number of subarrays of A, that have unique elements.



Example Input
Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 1, 2]


Example Output
Output 1:

 4
Output 1:

 5


Example Explanation
Explanation 1:

 Subarrays of A that have unique elements only:
 [1], [1], [1, 3], [3]
Explanation 2:

 Subarrays of A that have unique elements only:
 [2], [1], [2, 1], [1, 2], [2]
 */
public class CountSubarrays {

	public int solve(ArrayList<Integer> A) {
		final Long MOD = (long) (Math.pow(10, 9)+7);
		final int N = A.size();
		Set<Integer> resultSet = new HashSet<Integer>();
		long counter = 0l;
		
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				java.util.List<Integer> result = A.subList(i, j+1);
				resultSet.clear();
				resultSet.add(result.get(0));
				boolean isDuplicate = false;
				for(int k=1;k<result.size();k++) {
					if(resultSet.contains(result.get(k))) {
						isDuplicate=true;
						break;
					}else {
						resultSet.add(result.get(k));
					}
				}
				if(!isDuplicate) {
					counter = (counter + 1) % MOD; 
				}
			}
			
		}
		return new Long(counter).intValue();
		
	}

	public static void main(String[] args) {
		
		CountSubarrays subarrayWithGivenSum = new CountSubarrays();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(2, 1, 2));
		
		int[] aa = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6 };
		
		int result = subarrayWithGivenSum.solve(inputArray);
		System.out.println(result);

	}

}
