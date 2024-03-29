package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
 Wave Array
Problem Description

Given an array of integers A, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that

a1 >= a2 <= a3 >= a4 <= a5.....
NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.



Problem Constraints
1 <= len(A) <= 106
1 <= A[i] <= 106



Input Format
First argument is an integer array A.



Output Format
Return an array arranged in the sequence as described.



Example Input
Input 1:

A = [1, 2, 3, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[2, 1, 4, 3]
Output 2:

[2, 1]


Example Explanation
Explanation 1:

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].
Explanation 1:

Only possible answer is [2, 1].
 */
public class WaveArray {

	public ArrayList<Integer> wave(ArrayList<Integer> A) {
		
		int N = A.size();
		Collections.sort(A);
		
		for(int i = 0;i<N-1;i=i+2) {
			swap(A, i, i+1);
		}
		return A;
	}
	
	public void swap(ArrayList<Integer> A, int IndexA, int IndexB) {
		int temp = A.get(IndexA);
		A.set(IndexA, A.get(IndexB));
		A.set(IndexB, temp);
	}

	public static void main(String[] args) {
		
		WaveArray waveArray = new WaveArray();
		ArrayList<Integer> result = waveArray.wave(new ArrayList<Integer>(Arrays.asList(5, 1, 3, 2, 4)));
		System.out.println(result);

	}

}
