package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Xor queries
Problem Description

You are given an array A (containing only 0 and 1) as element of N length.
Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.



Problem Constraints
1<=N,Q<=100000
1<=L<=R<=N


Input Format
First argument contains the array of size N containing 0 and 1 only. 
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.


Output Format
Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.


Example Input
A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]


Example Output
[[0 3]
[0 3]
[1 2]]


Example Explanation
In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
Similarly for other queries.
 */
public class XorQueries {

	public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> zeroPrefixSum = new ArrayList<Integer>();
		zeroPrefixSum = prefixSum(0,A, zeroPrefixSum);
		ArrayList<Integer> onePrefixSum = new ArrayList<Integer>();
		onePrefixSum = prefixSum(1,A, onePrefixSum);
		
		for(int i=0;i<B.size();i++) {
			int l=B.get(i).get(0)-1;
			int r=B.get(i).get(1)-1;
			
			int totalLengthOfArray = r-l+1;
			int noOfZero=zeroPrefixSum.get(r) - zeroPrefixSum.get(l-1);
			int noOfOne=onePrefixSum.get(r) - onePrefixSum.get(l-1);
			
			System.out.println("No of Zero is :"+noOfZero);
			
		}
		

		return resultList;
	}

	private ArrayList<Integer> prefixSum(int n,ArrayList<Integer> A, ArrayList<Integer> resultArray) {
		int counter =0;
		for (int i = 0; i < A.size(); i++) {
			if(A.get(i)==n) {
				resultArray.add(++counter);
			}
			else {
				resultArray.add(counter);
			}
		}
		return resultArray;
	}


	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 0, 0, 0, 1);
		// List<Integer> integers = Arrays.asList(0, 1, 0, 1);

		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.addAll(integers);

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(4);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(1);
		a2.add(5);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(3);
		a3.add(5);

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		blist.add(a3);

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		XorQueries eq = new XorQueries();
		result = eq.solve(inputArray, blist);
		System.out.println("Result:>>" + result);

	}

}
