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
public class NQueens2 {

	public ArrayList<ArrayList<String>> solveNQueens(int A) {
		int[] board = new int[A];
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		return placeQueen(board, 0, A, result);
	}

	private ArrayList<ArrayList<String>> placeQueen(int[] board, int current, int noOfQueens,
			ArrayList<ArrayList<String>> result) {
		if (current == noOfQueens) {
			ArrayList<String> res = displayQueens2(board);
			result.add(res);
			//displayQueens(board, result);
			return result;
		}

		for (int i = 0; i < noOfQueens; i++) {
			board[current] = i;
			if (noKill(board, current)) {
				placeQueen(board, current + 1, noOfQueens, result);
			}
		}
		return result;
	}

	private static boolean noKill(int[] board, int currentColumnOfQueen) {

		for (int i = 0; i < currentColumnOfQueen; i++) {
			// same row
			if (board[i] == board[currentColumnOfQueen])
				return false;

			// Diagonal
			if ((currentColumnOfQueen - i) == Math.abs(board[currentColumnOfQueen] - board[i])) {
				return false;
			}
		}
		return true;
	}

	private ArrayList<String> displayQueens2(int[] board) {
		int n = board.length;
		ArrayList<String> pattern = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String data = "";
			for (int value : board) {
				if (value == i) {
					data +="Q";
				} else {
					data +=".";
				}
			}
			pattern.add(data);
		}
		return pattern;
	}
	
	
	private void displayQueens(int[] board, ArrayList<ArrayList<String>> result) {
		System.out.print("\n");
		StringBuilder resultString = new StringBuilder();
		int n = board.length;
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			
			for (int value : board) {
				if (value == i) {
					temp.add("Q");
					resultString.append("Q");
					//System.out.print("Q\t");
					System.out.print("Q");
				} else {
					System.out.print(".");
					resultString.append(".");
					//System.out.print("*\t");
					temp.add("*");
				}

			}
			//System.out.print("\n");
		}
		result.add(temp);
	}
	

	

	public static void main(String[] args) {
		NQueens2 n = new NQueens2();
		ArrayList<ArrayList<String>> result = n.solveNQueens(4);
		System.out.println(result);

	}

}
