package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Minimize the absolute difference
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinimizeTheAbsoluteDifference {
	

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		
		int i = A.size()-1,j = B.size()-1, k = C.size()-1;
	    int ans = Math.max(A.get(i), Math.max(B.get(j),C.get(k))) - Math.min(A.get(i),Math.min(B.get(j),C.get(k)));
	    
	    while(i!=-1 && j!= -1 && k!=-1){
	        int cnt = Math.max(A.get(i), Math.max(B.get(j),C.get(k)))  - Math.min(A.get(i),Math.min(B.get(j),C.get(k)));
	        if(cnt < ans) ans = cnt;
	        int mx = Math.max(A.get(i), Math.max(B.get(j),C.get(k)));
	        if(mx == A.get(i)) i--;
	        else if(mx == B.get(j)) j--;
	        else k--;
	    }
	    return ans;
	}

	public static void main(String[] args) {
		MinimizeTheAbsoluteDifference minimizeTheAbsoluteDifference = new MinimizeTheAbsoluteDifference();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 8, 10));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(6, 9, 15));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 6 ));
		int result = minimizeTheAbsoluteDifference.solve(A, B, C);
		System.out.println(result);

	}

}
