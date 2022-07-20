package com.intermediate.arrays;

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
public class SpiralOrderMatrixII2 {

	public int[][] generateMatrix(int n) {

		int[][] m = new int[n][n];
		int x = 0, y = 0;
		int dir = 1;

		for (int i = 1; i <= n * n; i++) {
			m[x][y] = i;
			if (dir == 1) {
				if (y + 1 < n && m[x][y + 1] == 0) {
					y++;
				} else {
					x++;
					dir = 2;
				}
			} else if (dir == 2) {
				if (x + 1 < n && m[x + 1][y] == 0) {
					x++;
				} else {
					y--;
					dir = 3;
				}
			} else if (dir == 3) {
				if (y - 1 >= 0 && m[x][y - 1] == 0) {
					y--;
				} else {
					x--;
					dir = 4;
				}
			} else if (dir == 4) {
				if (x - 1 >= 0 && m[x - 1][y] == 0) {
					x--;
				} else {
					y++;
					dir = 1;
				}
			}
		}
		return m;
	}

	private void display(int[][] a) {
		for (int[] list : a) {
			if (null != list && list.length > 0) {
				for (int i = 0; i < list.length; i++) {
					System.out.print(a[i]);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		SpiralOrderMatrixII2 spiralOrderMatrixII = new SpiralOrderMatrixII2();
		spiralOrderMatrixII.generateMatrix(2);

	}

}
