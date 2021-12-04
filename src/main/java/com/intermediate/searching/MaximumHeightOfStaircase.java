package com.intermediate.searching;

/*
 Maximum height of staircase
Problem Description

Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks.

The first stair would require only one block, the second stair would require two blocks and so on.

Find and return the maximum height of the staircase.



Problem Constraints
0 <= A <= 109


Input Format
The only argument given is integer A.



Output Format
Return the maximum height of the staircase using these blocks.



Example Input
Input 1:

 A = 10
Input 2:

 20


Example Output
Output 1:

 4
Output 2:

 5
 */
public class MaximumHeightOfStaircase {
	
	public int solve(int A) {
        int sum =0;
        int index = 0;
        for(int k=1;k<=A;k++){
            sum +=k;
            if(sum == A) {
            	return k;
            }
            if(sum>A){
                return k-1;
            }
        }
        
        return index;
    }

	public static void main(String[] args) {
		MaximumHeightOfStaircase maxHeights = new MaximumHeightOfStaircase();
		System.out.println(maxHeights.solve(30));

	}

}
