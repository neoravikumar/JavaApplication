package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
Minimum Difference
Problem Description

You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly build array is minimized.

Cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly build array.



Problem Constraints
2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106



Input Format
The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.



Output Format
Return an integer denoting the minimum cost of the newly build array.



Example Input
Input 1:

 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]
Input 2:

 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
Explanation 2:

 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).
 */
public class MinimumDifference {
	
	int bsearch(int low, int high, int n, ArrayList<Integer> arr)
	{
	    int mid = (low + high)/2;
	 
	    if(low <= high)
	    {
	        if(arr.get(mid) < n)
	            return bsearch(mid +1, high, n, arr);
	        return bsearch(low, mid - 1, n, arr);
	    }
	 
	    return low;
	}
	
	int mindiff(ArrayList<ArrayList<Integer>> arr, int n, int m)
	{
	 
	    // Sort each row of the matrix.
	    for (int i = 0; i < n; i++)
	    	Collections.sort(arr.get(i));
	 
	    int ans = Integer.MAX_VALUE;
	 
	    // For each matrix element
	    for (int i = 0; i < n - 1; i++)
	    {
	        for (int j = 0; j < m; j++)
	        {
	 
	        int p = bsearch(0, m-1, arr.get(i).get(j), arr.get(i + 1));
	        ans = Math.min(ans, Math.abs(arr.get(i+1).get(p)  - arr.get(i).get(j)));
	 
	        if (p-1 >= 0)
	            ans = Math.min(ans,
	                        Math.abs(arr.get(i + 1).get(p - 1) - arr.get(i).get(j)));
	        }
	    }
	    return ans;
	}
	 
	
	public int solve(int n, int m, ArrayList<ArrayList<Integer>> arr) {
		
		 int ans = Integer.MAX_VALUE;
		 
		 for (int i = 0; i < n; i++)
		    	Collections.sort(arr.get(i));
		 
		 for (int i = 0; i < n - 1; i++)
		    {
		        for (int j = 0; j < m; j++)
		        {
		 
		        int p = bsearch(0, m-1, arr.get(i).get(j), arr.get(i + 1));
		        ans = Math.min(ans, Math.abs(arr.get(i+1).get(p)  - arr.get(i).get(j)));
		 
		        if (p-1 >= 0)
		            ans = Math.min(ans,
		                        Math.abs(arr.get(i + 1).get(p - 1) - arr.get(i).get(j)));
		        }
		    }
		return ans;
	}

	public static void main(String[] args) {
		MinimumDifference minimumDifference = new MinimumDifference();
		
		ArrayList<ArrayList<Integer>>  input = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(7);
		a.add(3);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(1);
		
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(4);
		c.add(9);
		
		input.add(a);
		input.add(b);
		input.add(c);
		
		int result = minimumDifference.solve(3, 2, input);
		System.out.println("REsult is :>>"+result);

	}

}
