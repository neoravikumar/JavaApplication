package com.intermediate.basic;

import java.util.ArrayList;

/*Pascal Triangle
Problem Description

Write a program to input an integer N from user and print pascal triangle up to N rows.



Problem Constraints
1 <= N <= 25



Input Format
First line is an integer N.



Output Format
N lines whose each row contains N+1 space separated integers.



Example Input
Input 1:

3
Input 2:

5


Example Output
Output 1:

1 0 0 
1 1 0 
1 2 1 
Output 2:

1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1 


Example Explanation
Explanation 1:

Row 1 = 1 0 0 0 0
Row 2 = 1C0 1C1 0 0 0= 1 1 0 0 0
Row 3 = 2C0 2C1 2C2 0 0= 1 2 1 0 0
Row 4 = 3C0 3C1 3C2 3C3 0= 1 3 3 1 0*/
public class PascalTraingle {

	public ArrayList<ArrayList<Integer>> solve(int A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row, pre = null;
		for (int i = 0; i < A; i++) {
			row = new ArrayList<Integer>();
			for (int k = 0; k <= i; k++) {
				if (k == 0 || k == i) {
					row.add(1);
				} else {
					row.add(pre.get(k - 1) + pre.get(k));
				}
			}
			pre = row;
			for (int l = row.size(); l < A; l++) {
				row.add(0);
			}
			result.add(row);
		}
		return result;
	}

	public static void main(String[] args) {
		PascalTraingle pascal = new PascalTraingle();
		pascal.solve(5);

	}

}
