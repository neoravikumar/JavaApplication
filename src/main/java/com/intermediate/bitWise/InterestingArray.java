package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Interesting Array
Problem Description

You have an array A with N elements. We have 2 types of operation available on this array :
We can split a element B into 2 elements C and D such that B = C + D.
We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?



Problem Constraints
1 <= N <= 100000

1 <= A[i] <= 106



Input Format
The first argument is an integer array A of size N.



Output Format
Return "Yes" if it is possible otherwise return "No".



Example Input
Input 1:

 A = [9, 17]
Input 2:

 A = [1]


Example Output
Output 1:

 Yes
Output 2:

 No


Example Explanation
Explanation 1:

 Following is one possible sequence of operations -  
 1) Merge i.e 9 XOR 17 = 24  
 2) Split 24 into two parts each of size 12  
 3) Merge i.e 12 XOR 12 = 0  
 As there is only 1 element i.e 0. So it is possible.
Explanation 2:

 There is no possible way to make it 0.
 */
public class InterestingArray {
	
	public String solve(ArrayList<Integer> A) {
		String result = "No";
		int oddCount=0;
		for(int k=0;k<A.size();k++) {
			if(A.get(k)%2 !=0) {
				oddCount++;
			}
			
		}
		if(oddCount%2==0) {
			return "Yes";
		}
		return result;
    }

	public static void main(String[] args) {
		
		  System.out.println(new InterestingArray().solve(new
		  ArrayList<Integer>(Arrays.asList(9,17))));
		 
		//System.out.println(new InterestingArray().solve(new ArrayList<Integer>(Arrays.asList(9,17))));

	}

}
