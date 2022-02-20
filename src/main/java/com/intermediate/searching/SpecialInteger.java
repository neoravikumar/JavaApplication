package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Special Integer
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the maximum value of K (sub array length).



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

Constraints are satisfied for maximal value of 2.
Explanation 2:

Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {
	
	public int solve(ArrayList<Integer> A, int B) {
		int ans = 0, mid = -1;
		int n = A.size();
		int l=1, r=n;
		while(l<=r) {
			mid = (l+r)/2;
			if(check(A,B,mid)) {
				ans = mid;
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		return ans;
    }

	private boolean check(ArrayList<Integer> A, int B, int mid) {
		
		long sum =0;
		for(int i=0;i<mid;i++) {
			sum += A.get(i);
		}
		if(sum>B) { return false;}
		for(int j=mid;j<A.size();j++) {
			sum += (A.get(j)-A.get(j-mid));
			if(sum>B) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		SpecialInteger specialInteger = new SpecialInteger();
		int result = specialInteger.solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 10);
		System.out.println(result);
		

	}

}
