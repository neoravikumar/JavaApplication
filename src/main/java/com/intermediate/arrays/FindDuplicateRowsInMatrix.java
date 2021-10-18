package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Find duplicate rows in a binary matrix
Given a binary matrix A of integers 0 and 1, of size N x M.

Find and return the indices of the rows which are duplicate of rows which are already present in the matrix.

If row[i] and row[j] are same and i < j then answer will contain only index j.

Note: Rows are numbered from top to bottom and columns are numbered from left to right. There will be at least one duplicate row in the matrix.


Input Format

The first argument given is the integer matrix A.
Output Format

Return the indices of the rows in the form of an integer array.
Constraints

2 <= N, M <= 1000
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [1, 0, 0]
            [0, 1, 0]
            [0, 1, 0]   ]
Output 1:
    [3]

Input 2:
    A = [   [1, 1, 1, 0]
            [0, 0, 0, 1]
            [1, 1, 1, 0]
            [0, 0, 0, 1]    ]
Output 2:
    [3, 4]
 */
public class FindDuplicateRowsInMatrix {

	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int N = A.size();
		if (N >= 2 && N <= 1000) {
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(A.get(i).equals(A.get(j))) {
						if(!result.contains(j+1)) {
							result.add(j+1);
						}
					}
				}
			}
		}
		
		Collections.sort(result);
		
		return result;

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1));
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0));
		ArrayList<Integer> a4 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1));

		input.add(a1);
		input.add(a2);
		input.add(a3);
		input.add(a4);

		FindDuplicateRowsInMatrix findDuplicateRowsInMatrix = new FindDuplicateRowsInMatrix();
		ArrayList<Integer> result = findDuplicateRowsInMatrix.solve(input);
		System.out.println(result);

	}

}
