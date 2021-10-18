package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*Anti Diagonals
Problem Description

Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.


Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9


Input Format
First argument is an integer N, denoting the size of square 2D matrix.
Second argument is a 2D array A of size N * N.


Output Format
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.


Example Input
Input 1:
3
1 2 3
4 5 6
7 8 9
Input 2:

1 2
3 4


Example Output
Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:

1 0
2 3
4 0


Example Explanation
For input 1:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
For input 2:

The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].*/
public class AntiDiagonals2 {

	public int[][] diagonal(int[][] A) {
		

		int N = A.length;
		int[][] result = new int[N][N];
		/*
		 * for (int[] e : result) { Arrays.fill(e, 0); }
		 */

		// For each column start row is 0
		for (int col = 0; col < N; col++) {
			int startcol = col, startrow = 0;
			while (startcol >= 0 && startrow < N) {
				
				System.out.println("Hello:>>"+startrow+":"+startcol);
				
				result[startrow][startcol] = A[startrow][startcol];
				System.out.print(A[startrow][startcol] + " ");
				startcol--;
				startrow++;
			}
			System.out.println();
		}

		// For each row start column is N-1
		for (int row = 1; row < N; row++) {
			int startrow = row, startcol = N - 1;

			while (startrow < N && startcol >= 0) {
				result[startrow][startcol] = A[startrow][startcol];
				System.out.print(A[startrow][startcol] + " ");
				startcol--;
				startrow++;
			}
			System.out.println();
		}

		
		
		
		System.out.println("----------------------------------------");
		
		int[][] result2 = new int[N][N];
	    for(int i=0;i<N;i++){
	    	int[] temp = new int[N]; 
	        for(int j=0,k=i;j<=i;j++,k--){
	        	System.out.print(A[j][k]+" ");
	        	temp[j] = A[j][k];
	        }
	        System.out.println();
	        result2[j][k](temp);
	    }
	    for(int i=1;i<n;i++){
	        vector<int>temp; 
	        for(int j=i,k=n-1;k>=i;j++,k--){
	            temp.push_back(A[j][k]); 
	        }
	        res.push_back(temp);
	    }
	    return res;
		
		
		
		return result;
	}

	public static void main(String[] args) {
		/*
		 * ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		 * ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
		 * ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
		 * 
		 * // ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
		 * 
		 * ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		 * blist.add(a1); blist.add(a2); blist.add(a3);
		 */

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		AntiDiagonals2 eq = new AntiDiagonals2();
		int[][] result = eq.diagonal(arr);
		System.out.println("Result:>>" + result);

	}

}
