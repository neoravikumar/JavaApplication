package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;

/*
 NQueens
Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
1 <= A <= 10



Input Format
First argument is an integer n denoting the size of chessboard



Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input
Input 1:

A = 4
Input 2:

A = 1


Example Output
Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation
Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:

 */
public class NQueens {

public ArrayList<ArrayList<String>> solveNQueens(int A) {
	    
	 ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    int N = A;
		int r = 0;
        char[][] matrix = new char[N][N];
 
        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], '.');
        }
 
        boolean isvalid = nQueen(matrix, r);
       if(isvalid) {
        ArrayList<ArrayList<String>> resp = printSolution(matrix);
        result.addAll(resp);
       }else {
    	   return new ArrayList<ArrayList<String>>();
       }
       
       return result;
	}
	
	 private boolean isValid(char[][] mat, int r, int c) {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++)
        {
            if (mat[i][c] == 'Q') {
                return false;
            }
        }
 
		
     // return false if two queens share the same `` diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }
 
        // return false if two queens share the same `/` diagonal
        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++)
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }
		 
 
        return true;
    }
    
    private boolean nQueen(char[][] mat, int r)
    {
        // if `N` queens are placed successfully, print the solution
        if (r == mat.length)
        {
           return true;
        }
 
        // place queen at every square in the current row `r` and recur for each valid movement
        for (int i = 0; i < mat.length; i++)
        {
            // if no two queens threaten each other
            if (isValid(mat, r, i))
            {
                // place queen on the current square
                mat[r][i] = 'Q';
 
                // recur for the next row
                if(nQueen(mat, r + 1)) {
                	System.out.println("NQuewnD");
                	return true;
                }
 
                // backtrack and remove the queen from the current square
                mat[r][i] = '.';
            }
        }
         return false;
    }

	/* A utility function to print solution */
	private ArrayList<ArrayList<String>> printSolution(char board[][]) {
	    int N = board.length;
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < N; i++) {
			ArrayList<String> temp = new ArrayList<String>();
			for (int j = 0; j < N; j++) {
				char delta = board[i][j];
				temp.add(String.valueOf(delta));
			}
			result.add(temp);
		}
		return result;
	}

	public static void main(String[] args) {
		NQueens n = new NQueens();
		ArrayList<ArrayList<String>> result = n.solveNQueens(4);
		System.out.println(result);

	}

}
