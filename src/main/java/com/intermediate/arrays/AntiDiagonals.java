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
public class AntiDiagonals {

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    int n=A.size();
	    for(int i=0;i<n;i++){
	    	Integer[] integers = new Integer[n];
	    	Arrays.fill(integers, 0);
	    	ArrayList<Integer> diagonal = new ArrayList<Integer>(Arrays.asList(integers));
	        for(int j=0,k=i;j<=i;j++,k--){
	        	diagonal.set(j, A.get(j).get(k));
	        }
	        result.add(diagonal);
	    }
	    for(int i=1;i<n;i++){
	    	Integer[] integers = new Integer[n];
	    	Arrays.fill(integers, 0);
	    	ArrayList<Integer> diagonal = new ArrayList<Integer>(Arrays.asList(integers));
	        for(int l=0,j=i,k=n-1;k>=i;j++,k--,l++){
	        	diagonal.set(l, A.get(j).get(k));
	        }
	        result.add(diagonal);
	    }

        return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));

		// ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		blist.add(a3);

		AntiDiagonals eq = new AntiDiagonals();
		ArrayList<ArrayList<Integer>> result = eq.diagonal(blist);
		System.out.println("Result:>>" + result);
		
		/* [1 0 0 ] [2 4 0 ] [3 5 7 ] [6 8 0 ] [9 0 0 ] */

	}

}
