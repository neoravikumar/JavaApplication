package com.intermediate.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Time to equality
Problem Description

Given an integer array A of size N. In one second you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000


Input Format
First argument is an integer array A.


Output Format
Return an integer denoting the minimum time to make all elements equal.


Example Input
A = [2, 4, 1, 3, 2]


Example Output
8


Example Explanation
We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
*/

public class TimeToEquality {

	public int solve(ArrayList<Integer> A) {

		int sum = 0;
		int greatest = Integer.MIN_VALUE;

		//Constraiant 1 <= N <= 1000000
		if (null != A && (A.size() >= 1 && A.size() <= 1000000)) {
			
			for(int i=0;i<A.size();i++) {
				int value = A.get(i);
				//Constraiant 1 <= A[i] <= 1000
				if(value>=1 && value<=1000) {
					if(greatest < value) {
						greatest = value;
					}
				}
			}
			for(int j=0;j<A.size();j++) {
				sum += (greatest-A.get(j));
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(2, 5, 1, 3, 2);
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);
		
		TimeToEquality timeToEquality = new TimeToEquality();
		timeToEquality.solve(abc);

	}

}
