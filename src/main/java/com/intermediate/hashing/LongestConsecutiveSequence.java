package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 Longest Consecutive Sequence
Problem Description

Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from the array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(final List<Integer> A) {
		
		int max = 0;
		  
		  Set<Integer> set = new HashSet<Integer>();
		  for (int i = 0; i < A.size(); i++) {
		    set.add(A.get(i));
		  }
		  
		  for (int i = 0; i < A.size(); i++) {
		    int count = 1;
		    
		    // look left
		    int num = A.get(i);
		    while (set.contains(--num)) {
		      count++;
		      set.remove(num);
		    }
		    
		    // look right
		    num = A.get(i);
		    while (set.contains(++num)) {
		      count++;
		      set.remove(num);
		    }
		    
		    max = Math.max(max, count);
		  }
		  
		  return max;
	}

	public static void main(String[] args) {

		LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
		int result = longestConsecutiveSequence
				.longestConsecutive(new ArrayList<Integer>(Arrays.asList(50, 41)));
		System.out.println(result);

	}

}
