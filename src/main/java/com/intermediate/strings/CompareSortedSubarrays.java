package com.intermediate.strings;

import java.util.ArrayList;

/**
Compare Sorted Subarrays
Problem Description

Given an array A of length N. You have to answer Q queires.

Each query will contain 4 integers l1, r1, l2 and r2. If sorted segment from [l1, r1] is same as sorted segment from [l2 r2] then answer is 1 else 0.

NOTE The queries are 0-indexed.



Problem Constraints
0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000



Input Format
First argument is an array A.
Second will be 2-D array B denoting queries with dimension Q * 4.
Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].



Output Format
Return an array of length Q with answer of the queries in the same order in input.



Example Input
Input 1:

 A = [1, 7, 11, 8, 11, 7, 1]
 B = [ 
       [0, 2, 4, 6]
     ]
Input 2:

 A = [1, 3, 2]
 B = [
       [0, 1, 1, 2]
     ] 


Example Output
Output 1:

 [1]
Output 2:

 [0]


Example Explanation
Explanation 1:

 (0, 2) -> [1, 7, 11]
 (4, 6) -> [11, 7, 1]
 Both are same when sorted hence 1.
Explanation 2:

 (0, 1) -> [1, 3]
 (1, 2) -> [3, 2] 
 Both are different when sorted hence -1.
 */
public class CompareSortedSubarrays {
	
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		return A;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
