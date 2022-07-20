package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 Largest Continuous Sequence Zero Sum
Problem Description

Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints
1 <= N <= 106

-107 <= A[i] <= 107



Input Format
Single argument which is an integer array A.



Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.



Example Input
A = [1,2,-2,4,-4]


Example Output
[2,-2,4,-4]


Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.
 */
public class LargestContinuousSequenceZeroSum {
	
	   static class Pair {
	        int x;
	        int y;
	        
	        public Pair(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		
		  int[] sum = new int[A.size()];
	        for (int i = 0; i < A.size(); i ++) {
	            if (i == 0) {
	                sum[i] = A.get(i);
	            } else {
	                sum[i] = A.get(i) + sum[i - 1];
	            }
	        }
	        Map<Integer, Pair> map = new HashMap<>();
	        for (int i = 0; i < sum.length; i ++) {
	            if (map.containsKey(sum[i])) {
	                Pair p = map.get(sum[i]);
	                p.x = Math.min(p.x, i);
	                p.y = Math.max(p.y, i);
	            } else {
	                Pair p = new Pair(i, i);
	                map.put(sum[i], p);
	            }
	        }
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MAX_VALUE;
	        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
	            Pair p = entry.getValue();
	            // System.out.println(entry.getKey() + ": <" + p.x + ", " + p.y + ">");
	            if (p.y - p.x > max - min || (p.y - p.x == max - min && p.x < min)) {
	                min = p.x;
	                max = p.y;
	            }
	            // System.out.println("min max: <" + min + ", " + max + ">");
	        }
	        if (map.containsKey(0)) {
	            Pair p = map.get(0);
	            if (p.y + 1 >= max - min) {
	                min = -1;
	                max = p.y;
	            }
	        }
	        return new ArrayList<Integer>(A.subList(min + 1, max + 1));
	    }

	public static void main(String[] args) {
		LargestContinuousSequenceZeroSum largetContinuousSeq = new LargestContinuousSequenceZeroSum();
		ArrayList<Integer> input =  new ArrayList<>(Arrays.asList(1,2,-2,4,-4)); 
		ArrayList<Integer> result = largetContinuousSeq.lszero(input);
		System.out.println(result);
		

	}

}
