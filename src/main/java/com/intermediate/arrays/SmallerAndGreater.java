package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Smaller and Greater
You are given an Array A of size N.

Find for how many elements, there is a strictly smaller element and a strictly greater element.



Input Format

Given only argument A an Array of Integers.
Output Format

Return an Integer X, i.e number of elements.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e6
For Example

Example Input:
    A = [1, 2, 3]

Example Output:
    1

Explanation:
    only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.*/


/*The expected time complexity is O(n). 
 * You just have to find the min and max elements in the array. After that iterate the array and check if that lies between the min and max. 
 * if yes then increase the count.*/

public class SmallerAndGreater {

	public int solve(ArrayList<Integer> A) {
		int count = 0;
		if (null != A && (A.size() >= 1 && A.size() <= Math.pow(10, 5))) {
			for (int k = 0; k < A.size(); k++) {
				int value = (Integer) A.get(k);
				count = minMaxCount(A, count, value);
			}
		}
		return count;

	}

	private int minMaxCount(ArrayList<Integer> A, int count, int value) {
		if (value >= 1 && value < Math.pow(10, 6)) {
			int upper = value;
			int smaller = value;
			boolean upflag = false;
			boolean downFlag = false;

			for (int j = 0; j < A.size(); j++) {
				int newValue = (Integer) A.get(j);

				if (newValue > upper) {
					upflag = true;
				    continue;
				}
				else if (newValue < smaller) {
					downFlag = true;
					continue;
				}
			}

			if (upflag && downFlag) {
				++count;
			}

		}
		return count;
	}

	public static void main(String[] args) {

		SmallerAndGreater smg = new SmallerAndGreater();
		
		
		List<Integer> lst = Arrays.asList(913, 440, 865, 72, 612, 445, 101, 994, 356, 91, 461, 930, 583, 448, 543, 170, 333, 107, 425, 73, 172, 416, 899, 826, 659, 561, 314, 25, 110 );
		//List<Integer> lst = Arrays.asList(1,2,3 );
		
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);
		
		
		
		System.out.println(smg.solve(abc));

	}

}
