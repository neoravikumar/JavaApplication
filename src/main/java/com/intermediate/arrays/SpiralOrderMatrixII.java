package com.intermediate.arrays;

import java.util.ArrayList;

import javax.swing.Spring;

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

		int left = 0, right = A - 1, top = 0, bottom = A - 1, dir = 0, value = 1;

		while (top <= bottom && left <= right) {

			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					System.out.println(left+":"+i+"\t"+value++);
				}
				top++;
			}
			else if(dir==1) {
				for(int i=top;i<=bottom;i++) {
					System.out.println(top+":"+i+"\t"+value++);
				}
				right--;
			}
			else if(dir==2) {
				for(int i = right;i>=left;i--) {
					System.out.println(bottom+":"+i+"\t"+value++);
				}
				bottom--;
			}
			else if(dir==3) {
				for(int i = bottom;i>= top ; i--) {
					System.out.println(bottom+":"+i+"\t"+value++);
				}
				left++;
			}
			
		dir = (dir +1 ) % 4 ;
		}

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
		spiralOrderMatrixII.generateMatrix(3);

	}

}
