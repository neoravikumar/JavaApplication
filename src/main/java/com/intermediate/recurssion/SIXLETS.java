package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;

/*
 SIXLETS
Problem Description

Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return number of subsequences of A of size B having sum <= 1000.



Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence
 */
public class SIXLETS {

	public int solve(ArrayList<Integer> A, int B) {
		int sum = 0;
		int index=0;
		int count = 0;
		int result = sixLets(A, B, sum, count, index);
		
		return result;
	}
	
	private int sixLets(ArrayList<Integer> A, int B, int sum, int count, int index) {
		if(sum>1000) return 0;
		if(count==B) return 1;
		if(index==A.size()) return 0;
		
		sum = sixLets(A, B, sum+A.get(index),count+1,index+1) + sixLets(A, B, sum,count,index+1);
		
		return sum;
	}

	public static void main(String[] args) {
		
		SIXLETS sixlets = new SIXLETS();
		int result = sixlets.solve(new ArrayList<Integer>(Arrays.asList(5, 17, 1000, 11)), 4);
		System.out.println(result);

	}

}
