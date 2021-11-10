package com.intermediate.arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KadaneAlogrithms {
	
	public int solveMaxSumSubArrayUsingKadane(ArrayList<Integer> A) {
		
		int maxSum = 0;
		int currSum = 0;
		int N = A.size();
		int fromIndex = 0;
		int toIndex = 0;
		
		for(int i=0;i<N;i++) {
			currSum = currSum + A.get(i);
			if(currSum>maxSum) {
				maxSum = currSum;
				toIndex = i;
			}
			if(currSum < 0) {
				currSum = 0;
				fromIndex = i+1;
			}
		}
		
		List<Integer> largestSumArray = A.subList(fromIndex, toIndex+1);
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		
		KadaneAlogrithms kadaneAlogrithms = new KadaneAlogrithms();
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5,-4,-2,6,-1));
		int result = kadaneAlogrithms.solveMaxSumSubArrayUsingKadane(input);
		System.out.println("Result is:>>"+result);
		
	}

}
