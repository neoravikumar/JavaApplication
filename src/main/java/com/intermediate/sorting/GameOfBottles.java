package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Game of Bottles Problem Description
 * 
 * Given an array of integers A of size N which denotes N cylindrical empty
 * bottles. The radius of the ith bottle is A[i]. You can put the ith bottle
 * into the jth bottle if the following conditions are met:
 * 
 * ith bottle is not put into another bottle. jth bottle dosen't contain any
 * other bottle. The radius of bottle i is smaller than bottle j (A[i] < A[j]).
 * You can put bottles into each other any number of times. You want to MINIMIZE
 * the number of visible bottles. A bottle is called visible if it is not put
 * into any other bottle.
 * 
 * Find and return the minimum number of visible bottles.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 100000
 * 
 * 1<= A[i] <= 100000000
 * 
 * 
 * 
 * Input Format First argument is an integer array A denoting the radius of the
 * cyclindrical bottles.
 * 
 * 
 * 
 * Output Format Return a single integer corresponding to the minimum number of
 * visible bottles.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2, 3] Input 2:
 * 
 * A = [1, 1]
 * 
 * 
 * Example Output Output 1:
 * 
 * 1 Output 2:
 * 
 * 2
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * In example 1 it is possible to put bottle 1 into bottle 2, and 2 into 3.
 * Explanation 2:
 * 
 * Both bottles will be visible.
 */
public class GameOfBottles {

	public int solve(ArrayList<Integer> A) {

		int N = A.size();
		Collections.sort(A);
		if (N == 1) {
			return 1;
		}
		
		HashMap<Integer, Integer> hMap = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < N; i++) {
			if(!(hMap.containsKey(A.get(i)))) {
				hMap.put(A.get(i), 1);
			}else {
				int getValue = hMap.get(A.get(i));
				hMap.put(A.get(i), ++getValue);
			}
		}
		int MAX = Integer.MIN_VALUE;
		for(Integer k : hMap.values()) {
			if(k>MAX) {
				MAX = Math.max(MAX, k);
			}
		}
		
		return MAX;
	}

	public static void main(String[] args) {
		GameOfBottles arrayWithCon = new GameOfBottles();
		int result = arrayWithCon.solve(new ArrayList<Integer>(Arrays.asList(1,1)));
		System.out.println(result);

	}

}
