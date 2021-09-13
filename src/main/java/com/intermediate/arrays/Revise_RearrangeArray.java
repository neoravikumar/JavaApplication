package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Rearrange Array
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */
public class Revise_RearrangeArray {

	public void arrange(ArrayList<Integer> a) {
		int N = null != a ? a.size() : 0;
		for(int i=0;i<N;i++) {
			int value = (a.get(a.get(i))% N)*N;
			a.set(i, a.get(i)+ value );
		}
		
		for(int i=0;i<N;i++) {
			a.set(i, a.get(i) / N);
		}
		
	}

	public static void main(String[] args) {
		
		Revise_RearrangeArray rearrangeArray = new Revise_RearrangeArray();
		
		List<Integer> lst = Arrays.asList(3,2,0,1);

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);
		
		rearrangeArray.arrange(abc);

	}

}
