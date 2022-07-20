package com.intermediate.hashing;

import java.util.*;

/*First Repeating element
Problem Description

Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of first occurrence is smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the first repeating element.



Example Input
Input 1:

 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:

 A = [6, 10, 5, 4, 9, 120]


Example Output
Output 1:

 5
Output 2:

 -1


Example Explanation
Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1*/
public class FirstRepatingElement {

	public int solve(ArrayList<Integer> A) {

		int result = -1;

		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (Integer a : A) {
			if (map.containsKey(a)) {
				map.put(a, 1);
			}else {
				map.put(a, 0);
			}
		}

		 for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			 Integer k = entry.getKey();
			 Integer v = entry.getValue();
	            if(v==1) {
	            	result = k;
	            	return result;
	            }
	        }

		return result;
	}

	public static void main(String[] args) {

		FirstRepatingElement firstRepatingElement = new FirstRepatingElement();

		List<Integer> lst = Arrays.asList(6, 10, 5, 4, 9, 120);
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		int result = firstRepatingElement.solve(abc);
		System.out.println("The Rresult is:" + result);

	}

}
