package com.intermediate.arrays;

import java.util.Arrays;

public class DuplicateZeros {

	/*
	 * Duplicate Zeros
	 * 
	 * Solution Given a fixed-length integer array arr, duplicate each occurrence of
	 * zero, shifting the remaining elements to the right.
	 * 
	 * Note that elements beyond the length of the original array are not written.
	 * Do the above modifications to the input array in place and do not return
	 * anything.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [1,0,2,3,0,4,5,0] Output: [1,0,0,2,3,0,0,4] Explanation: After
	 * calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
	 * Example 2:
	 * 
	 * Input: arr = [1,2,3] Output: [1,2,3] Explanation: After calling your
	 * function, the input array is modified to: [1,2,3]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= arr.length <= 104 0 <= arr[i] <= 9
	 */

	public void duplicateZeros2(int[] arr) {
		int[] result = new int[arr.length];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (j < arr.length) {
				if (arr[i] != 0) {
					result[j] = arr[i];
					j++;
				} else {
					result[j] = 0;
					j += 1;
					if (j < arr.length)
						result[j] = 0;
					j++;
				}
			}

		}

		System.out.println("The result is :" + Arrays.toString(result));
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = result[i];
		}
		
		System.out.println("The result is :" + Arrays.toString(arr));
		
	}

	public int[] duplicateZeros(int[] arr) {
		int[] result = new int[arr.length];
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (temp < arr.length) {
				if (arr[i] != 0) {
					result[temp] = arr[i];
					temp++;
				} else {
					result[temp] = 0;
					temp += 1;
					if (temp < arr.length)
						result[temp] = 0;
					temp++;
				}
			}
		}
		return result;
	}

	private void fillArray(int[] arr, int[] result, int i) {
		int index = i + 1;
		while (index < arr.length - 1) {
			result[index + 1] = arr[index];
			index++;
		}
	}

	public static void main(String[] args) {
		// OUTPUT = 1,0,0,2,3,0,0,4
		int[] input = { 1, 0, 2, 3, 0, 4, 5, 1 };
		DuplicateZeros duplicateZeros = new DuplicateZeros();
		// duplicateZeros.duplicateZeros(intput);
		int[] result = duplicateZeros.duplicateZeros(input);
		System.out.println(Arrays.toString(result));

		duplicateZeros.duplicateZeros2(input);
	}

}
