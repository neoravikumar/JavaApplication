package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Noble Integer
Problem Description

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.



Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is found else return -1.



Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array. So, return 1.
Explanation 2:

 There is no such integer exists.
*/
public class NobleInteger {

	public int solve(ArrayList<Integer> A) {
		
		if(null != A) {
			Collections.sort(A, Collections.reverseOrder());
		}
		
		for(int i=0;i<A.size();i++) {
			if(i == A.get(i)) {
				if(i==0 && A.get(i)== 0) {
					return 1;
				}else {
					if (A.get(i) != A.get(i-1)) {
						return 1;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		NobleInteger smallerAndGreater2 = new NobleInteger();

		List<Integer> lst = Arrays.asList(1, 1, 3, 3);
		//List<Integer> lst = Arrays.asList(-4, -2, 0, -1, -6 );

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(smallerAndGreater2.solve(abc));
	}

}
