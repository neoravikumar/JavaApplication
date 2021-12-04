package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Matrix Search
Problem Description

Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format
Return 1 if B is present in A, else return 0.



Example Input
Input 1:

A = [ 
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]  
    ]
B = 3
Input 2:

A = [   
      [5, 17, 100, 111]
      [119, 120, 127, 131]    
    ]
B = 3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.
 */
public class MatrixSearch {

	int searchInArray(ArrayList<Integer> A, int start, int end, int key) {

		while (end >= start) {
			int mid = (start + end) / 2;

			if (key == A.get(mid)) {
				return 1;
			}

			if (key > A.get(mid)) {
				// searchInArray(A, mid + 1, end, key);
				start = mid + 1;
			} else {
				// searchInArray(A, start, mid - 1, key);
				end = mid - 1;
			}
		}
		return -1;
	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {

		for (ArrayList<Integer> a : A) {
			if (searchInArray(a, 0, a.size() - 1, B) == 1) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		MatrixSearch matrixSearch = new MatrixSearch();

		//ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(51, 51, 54, 54, 54, 54, 56, 58, 59));
		//ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(60, 61, 61, 62, 63, 64, 65, 66, 67));
		
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 111));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(119, 120, 127, 131));

		// ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(23, 30, 34,
		// 50));

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		// blist.add(a3);

		System.out.println(matrixSearch.searchMatrix(blist, 127));

	}

}
