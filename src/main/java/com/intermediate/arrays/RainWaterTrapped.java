package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Rain Water Trapped
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.
 */
public class RainWaterTrapped {

	public int trap(final List<Integer> A) {

		int N = A.size();
		int ans = 0;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>(Collections.nCopies(N, 0));
		
		left.add(A.get(0));
		for(int i=1;i<A.size();i++) {
			if(A.get(i)>left.get(i-1)) {
				left.add(A.get(i));
			}else {
				left.add(left.get(i-1));
			}
		}
		
		
		right.set(N-1, A.get(N-1));
		for(int i=N-2;i>=0;i--) {
			int value = Math.max(A.get(i),right.get(i+1));
			right.set(i, value);
		}
		
		for (int i = 1; i < N - 1; i++) {
	        ans += Math.min(left.get(i), right.get(i)) - A.get(i);
	    }
		

		/*
		 * int[] arr = new int[N]; Arrays.fill(arr, 0); for (int i = 0; i < N; i++) {
		 * right.add(0); } left.add(A.get(0)); right.set(N - 1, A.get(N - 1)); for (int
		 * j = N - 1, i = 1; i < N && j >= 0; i++, j--) { int l = Math.max((int)
		 * left.get(i - 1), A.get(i)); int r = Math.max((int) right.get(j), A.get(j -
		 * i)); left.add(l); right.set(j - i, r); }
		 */
		
		

		return ans;
	}

	public static void main(String[] args) {
		RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
		// int result = rainWaterTrapped.trap(Arrays.asList(0, 1, 0, 2));
		int result = rainWaterTrapped.trap(Arrays.asList(1,2));
		System.out.println("Result is:>>" + result);

	}

}
