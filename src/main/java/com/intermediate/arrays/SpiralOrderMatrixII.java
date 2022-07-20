package com.intermediate.arrays;

import java.util.ArrayList;

/**
 * Spiral Order Matrix II Problem Description
 * 
 * Given an integer A, generate a square matrix filled with elements from 1 to
 * A2 in spiral order.
 * 
 * 
 * 
 * Problem Constraints 1 <= A <= 1000
 * 
 * 
 * 
 * Input Format First and only argument is integer A
 * 
 * 
 * Output Format Return a 2-D matrix which consists of the elements in spiral
 * order.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * 1 Input 2:
 * 
 * 2
 * 
 * 
 * Example Output Output 1:
 * 
 * [ [1] ] Output 2:
 * 
 * [ [1, 2], [4, 3] ]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * 
 * Only 1 is to be arranged. Explanation 2:
 * 
 * 1 --> 2 | | 4<--- 3
 */
public class SpiralOrderMatrixII {

	public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Integer[][] num = new Integer[A][A];

		int count = 1;
		for (int i = 0; i < A; i++) {
			for (int j = i; j < A - i; j++) {
				num[i][j] = count;
				count++;
			}
			for (int k = i + 1; k < A - i - 1; k++) {
				num[k][A - i - 1] = count;
				count++;
			}
			for (int l = A - i - 1; l > i; l--) {
				num[A - i - 1][l] = count;
				count++;
			}
			for (int m = A - 1 - i; m > i; m--) {
				num[m][i] = count;
				count++;
			}
		}

		for (Integer[] ints : num) {
			ArrayList<Integer> integerArray = new ArrayList<>(ints.length);
			for (int i : ints) {
				integerArray.add(i);
			}
			result.add(integerArray);
		}
		display(result);
		return result;
	}

	private void display(ArrayList<ArrayList<Integer>> a) {
		for (ArrayList<Integer> list : a) {
			if (null != list && list.size() > 0) {
				System.out.print(list);
			}
		}
	}

	public static void main(String[] args) {
		SpiralOrderMatrixII spiralOrderMatrixII = new SpiralOrderMatrixII();
		spiralOrderMatrixII.generateMatrix(2);
	}

}
