package com.intermediate.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 Maximum Rectangle
Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


Input Format

The only argument given is the integer matrix A.
Output Format

Return the area of the largest rectangle containing only 1's.
Constraints

1 <= N, M <= 1000
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:
    4

Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:
    1
 */
public class MaximumRectangle {

	public int solve(ArrayList<ArrayList<Integer>> A) {
		
		 if (A == null) {
	            throw new IllegalArgumentException("Input matrix is null");
	        }
	        if (A.size() == 0 || A.get(0).size() == 0) {
	            return 0;
	        }

			int rows = A.size();
			int cols = A.get(0).size();

	        if (cols < rows) {
	            return maximalRectangleHelper(A, rows, cols, true);
	        } else {
	            return maximalRectangleHelper(A, cols, rows, false);
	        }
	}
	
	private int maximalRectangleHelper(ArrayList<ArrayList<Integer>> matrix, int big, int small, boolean isColsSmall) {
        int[] heights = new int[small];
        int largestRectangle = 0;
        for (int i = 0; i < big; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j <= small; j++) {
                if (j < small) {
                    if (isColsSmall) {
                        heights[j] = matrix.get(i).get(j)  == 0 ? 0 : heights[j] + 1;
                    } else {
                        heights[j] = matrix.get(j).get(i)  == 0 ? 0 : heights[j] + 1;
                    }

                }
                while (!stack.isEmpty() && (j == small || heights[stack.peek()] >= heights[j])) {
                    int h = heights[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    largestRectangle = Math.max(largestRectangle, (j - 1 - left) * h);
                }
                stack.push(j);
            }
        }
        return largestRectangle;
    }

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> input1 = new ArrayList<>(Arrays.asList(0, 0, 1));
		ArrayList<Integer> input2 = new ArrayList<>(Arrays.asList(0, 1, 1));
		ArrayList<Integer> input3 = new ArrayList<>(Arrays.asList(1, 1, 1));
		matrix.add(input1);
		matrix.add(input2);
		matrix.add(input3);
		
		ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> input11 = new ArrayList<>(Arrays.asList(0, 1, 0, 1));
		ArrayList<Integer> input21 = new ArrayList<>(Arrays.asList(1, 0, 1, 0));
		matrix.add(input11);
		matrix.add(input21);
		
		
		
		MaximumRectangle maximumRectangle = new MaximumRectangle();
		int result = maximumRectangle.solve(matrix);
		System.out.println(result);

	}

}
