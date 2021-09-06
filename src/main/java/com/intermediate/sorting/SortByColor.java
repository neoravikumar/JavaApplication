package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Sort by Color
Problem Description

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2


Input Format
First and only argument of input contains an integer array A.


Output Format
Return an integer array in asked order


Example Input
Input 1 :
    A = [0 1 2 0 1 2]
Input 2:

    A = [0]


Example Output
Output 1:
    [0 0 1 1 2 2]
Output 2:

    [0]


Example Explanation
Explanation 1:
    [0 0 1 1 2 2] is the required order.*/
public class SortByColor {

	
	  //Approach #1 
		/*
		 * public ArrayList<Integer> sortColors(ArrayList<Integer> A) { int N = null !=
		 * A ? A.size() : 0; int zeros = 0; int ones = 0; int twos = 0; if (N >= 1 && N
		 * <= 100000) {
		 * 
		 * for (int i = 0; i < N; i++) { if (A.get(i) >= 0 && A.get(i) <= 2) { if
		 * (A.get(i) == 0) { zeros++;
		 * 
		 * } else if (A.get(i) == 1) { ones++;
		 * 
		 * } else if (A.get(i) == 2) { twos++;
		 * 
		 * } } else { return null; }
		 * 
		 * }
		 * 
		 * for (int i = 0; i < zeros; i++) { A.set(i, 0); } long onezero = zeros + ones;
		 * for (int i = zeros; i < onezero; i++) { A.set(i, 1); } Long myVal = new
		 * Long(onezero); for (int i = myVal.intValue(); i < N; i++) { A.set(i, 2); } }
		 * 
		 * return A; }
		 */
	 

	public ArrayList<Integer> sortColors(ArrayList<Integer> nums) {

		int len = nums.size();
		int l = 0;
		int m = 0;
		int h = len - 1;

		while (m <= h) {
			if (nums.get(m) == 0) {
				swap(nums, l++, m++);
			} else if (nums.get(m) == 1) {
				++m;
			} else if (nums.get(m) == 2) {
				swap(nums, m, h--);
			}
		}
		return nums;
	}

	private void swap(ArrayList<Integer> nums, int A, int B) {
		int t = nums.get(A);
		nums.set(A, nums.get(B));
		nums.set(B, t);
	}

	public static void main(String[] args) {
		SortByColor sortByColor = new SortByColor();

		// List<Integer> lst = Arrays.asList(0);
		List<Integer> lst = Arrays.asList(0, 1, 2, 0, 1, 2);

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(sortByColor.sortColors(abc));

	}

}
