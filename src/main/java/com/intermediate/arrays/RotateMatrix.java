package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Rotate Matrix Problem Description
 * 
 * You are given a n x n 2D matrix A representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * You need to do this in place.
 * 
 * Note: If you end up using an additional array, you will only receive partial
 * score.
 * 
 * 
 * 
 * Problem Constraints 1 <= n <= 1000
 * 
 * 
 * 
 * Input Format First argument is a 2D matrix A of integers
 * 
 * 
 * 
 * Output Format Return the 2D rotated matrix.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * [ [1, 2], [3, 4] ] Input 2:
 * 
 * [ [1] ]
 * 
 * 
 * Example Output Output 1:
 * 
 * [ [3, 1], [4, 2] ] Output 2:
 * 
 * [ [1] ]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * After rotating the matrix by 90 degree: 1 goes to 2, 2 goes to 4 4 goes to 3,
 * 3 goes to 1 Explanation 2:
 * 
 * 2D array remains the ssame as there is only element.
 */
public class RotateMatrix {

	public void solve(ArrayList<ArrayList<Integer>> A) {

		int N = Objects.nonNull(A) ? A.size() : 0;

		if (N >= 1 && N <= 1000) {
			// Transpose
			for (int i = 0; i < A.size(); i++) {
				for (int j = i; j < A.get(0).size(); j++) {
					int temp = A.get(i).get(j);
					A.get(i).set(j, A.get(j).get(i));
					A.get(j).set(i, temp);
				}
			}

			// reverse
			for (int i = 0; i < A.size(); i++) {

				int li = 0;
				int ri = A.get(i).size() - 1;

				while (li < ri) {
					int temp = A.get(i).get(li);
					A.get(i).set(li, A.get(i).get(ri));
					A.get(i).set(ri, temp);
					li++;
					ri--;
				}

			}

			display(A);
		}

	}

	private void display(ArrayList<ArrayList<Integer>> a) {
		for (ArrayList<Integer> list : a) {
			if (null != list && list.size() > 0) {
				System.out.print(list);
			}

		}

	}

	public static void main(String[] args) {

		ArrayList<Integer> a1 = new ArrayList<Integer>();

		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(1));

		// ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		// blist.add(a3);

		RotateMatrix eq = new RotateMatrix();
		eq.solve(blist);

	}

}
