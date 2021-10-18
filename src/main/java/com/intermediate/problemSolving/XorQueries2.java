package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
public class XorQueries2 {

	public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> xorArray = new ArrayList<Integer>();
		ArrayList<Integer> zeroPrefixSumArray = new ArrayList<Integer>();
		

		xorArray.add(A.get(0));
		int zeroCounter = 0;
		int first = A.get(0)== zeroCounter?++zeroCounter:0;
		zeroPrefixSumArray.add(first);
		
		// Prefix Zero Sum Array
        for(int i=1;i<A.size();i++){
        	if(A.get(i)==0) {
        		zeroPrefixSumArray.add( zeroPrefixSumArray.get(i-1) +  1);
        	}else {
        		zeroPrefixSumArray.add(zeroPrefixSumArray.get(i-1));
        	}
        }
        
		/*
		 * int xor = 0; for(int i=0;i<A.size();i++) { for(int j=i;j<A.size();j++) {
		 * if(null != A.subList(i, j) && A.subList(i, j).size()>0) { List<Integer>
		 * subArray = A.subList(i, j); int start =0, end =0;
		 * if(Objects.nonNull(subArray) && subArray.size()>1) { start = subArray.get(0);
		 * end = subArray.get(1); } else { start = subArray.get(0); end =
		 * subArray.get(0); }
		 * 
		 * System.out.println("start and end index>>"+start+"::"+end);
		 * if(zeroPrefixSumArray.get(end) - zeroPrefixSumArray.get(start-1) !=0) { xor
		 * += 1; } } System.out.println("xor Value:>>"+xor);
		 * 
		 * } }
		 */
        int xor = 0;

		for (int i = 0; i < B.size(); i++) {
			ArrayList<Integer> temp = B.get(i);
			int start = temp.get(0)-1;
			int end  = temp.get(1)-1;
			System.out.println("start and end index>>"+start+"::"+end);
			if(start !=0) {
				if (zeroPrefixSumArray.get(end) - zeroPrefixSumArray.get(start - 1) != 0) {
					xor = 1;
				}
				else {
					xor = 0;
				}
			}
			
			System.out.println("xor Value:>>" + xor);
		}

		return resultList;
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

		XorQueries2 eq = new XorQueries2();
		result = eq.solve(inputArray, blist);
		System.out.println("Result:>>" + result);

	}

}
