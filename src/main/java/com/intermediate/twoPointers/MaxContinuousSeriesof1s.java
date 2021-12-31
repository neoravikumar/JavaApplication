package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Max Continuous Series of 1s
Problem Description

Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.

For this problem, return the indices of maximum continuous series of 1s in order.

If there are multiple possible solutions, return the sequence which has the minimum start index.



Problem Constraints
0 <= B <= 105

1 <= size(A) <= 105

A[i]==0 or A[i]==1



Input Format
First argument is an binary array A.

Second argument is an integer B.



Output Format
Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.



Example Input
Input 1:

 A = [1 1 0 1 1 0 0 1 1 1 ]
 B = 1
Input 2:

 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2


Example Output
Output 1:

 [0, 1, 2, 3, 4]
Output 2:

 [3, 4, 5, 6]


Example Explanation
Explanation 1:

 Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
Explanation 2:

 Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
 */
public class MaxContinuousSeriesof1s {

	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
		
		int start = 0;
	    int len = A.size();
	    int p1 = 0;
	    int p2 = 0;
	    int zeros = B;
	    int lastZero = -1;
	    int[] ans = new int[2];

	    int maxLen = Integer.MIN_VALUE;

	    while (start < len) {
	      if (A.get(start).equals(0)) {
	        if (lastZero == -1) {
	          lastZero = start;
	        }
	        if (zeros == 0) {
	          if (maxLen < (p2-p1)) {
	            ans[0] = p1;
	            ans[1] = p2 - 1;
	            maxLen = p2 - p1;
	          }
	          p1 = lastZero + 1;
	          start = p1;
	          lastZero = -1;
	          p2 = p1;
	          zeros = B;
	        }
	        else {
	          zeros--;
	          start++;
	          p2++;
	        }
	      }
	      else {
	        start++;
	        p2++;
	      }
	    }

	    if (maxLen < p2-p1) {
	      ans[0] = p1;
	      ans[1] = p2 - 1;
	    }
	    ArrayList<Integer> res = new ArrayList<>();
	    start = ans[0];
	    while (start <= ans[1]) {
	      res.add(start++);
	    }

	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxContinuousSeriesof1s subarrayWithGivenSum = new MaxContinuousSeriesof1s();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 1, 0, 1));
		
		int[] aa = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6 };
		
		ArrayList<Integer> result = subarrayWithGivenSum.maxone(inputArray,2);
		System.out.println(result);

	}

}
