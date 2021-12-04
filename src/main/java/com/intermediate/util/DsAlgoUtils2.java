package com.intermediate.util;

import java.util.ArrayList;
import java.util.Arrays;

public class DsAlgoUtils2 {

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
		ArrayList<Integer> result = null;
		if (array == null) {
			return array;
		}

		if (array.size() > 1) {
			int mid = array.size() / 2;
			ArrayList<Integer> left = new ArrayList<Integer>();
			for (int i = 0; i < mid; i++) {
				left.add(array.get(i));
			}

			// Split right part
			ArrayList<Integer> right = new ArrayList<Integer>();
			for (int i = mid; i < array.size(); i++) {
				right.add(array.get(i));
			}
			mergeSort(left);
			mergeSort(right);
			result = mergetTwoSortedArrays(left, right);
		}
		return result;
	}

	public static ArrayList<Integer> mergetTwoSortedArrays(final ArrayList<Integer> A, final ArrayList<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int j = 0, k = 0;

		int ans = 0;

		while (j < A.size() && k < B.size()) {
			if ((j < A.size() && k < B.size()) && A.get(j) <= B.get(k)) {
				result.add(A.get(j));
				j++;
			}

			if ((j < A.size() && k < B.size()) && B.get(k) <= A.get(j)) {
				result.add(B.get(k));
				k++;
			}
		}

		while (j < A.size()) {
			result.add(A.get(j));
			j++;
		}
		while (k < B.size()) {
			result.add(B.get(k));
			k++;
		}

		return result;
	}

	public static void mergeSort(int[] array) {
		if (array == null) {
			return;
		}

		if (array.length > 1) {
			int mid = array.length / 2;

			// Split left part
			int[] left = new int[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = array[i];
			}

			// Split right part
			int[] right = new int[array.length - mid];
			for (int i = mid; i < array.length; i++) {
				right[i - mid] = array[i];
			}
			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;
			int inversionCount = 0;

			// Merge left and right arrays
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					array[k] = left[i];
					i++;
				} else {
					array[k] = right[j];
					inversionCount += (mid - i + 1);    // NOTE
					j++;
				}
				k++;
			}
			// Collect remaining elements
			while (i < left.length) {
				array[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length) {
				array[k] = right[j];
				j++;
				k++;
				ic++;
			}
			
			System.out.println("IC:>>"+ic);
		}
	}

	private static void mearge(int[] array, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		int ans = 0;
		// Merge left and right arrays
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
				ans += j;
			}
			k++;

		}
		// Collect remaining elements
		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
			ans += j;
		}

		System.out.println("ans:>>" + ans);
	}

	// Driver program to test above functions.
	public static void main(String[] args) {
		// ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(5, 17,
		// 100, 11));
		/*
		 * ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(5, 17,
		 * 100, 11)); System.out.println("Given arrayList is");
		 * 
		 * for(int i=0; i<inputArray.size(); i++)
		 * System.out.print(inputArray.get(i)+" ");
		 * 
		 * ArrayList<Integer> ressult = mergeSort(inputArray);
		 * 
		 * 
		 * System.out.println("\n"); System.out.println("Sorted arrayList is");
		 * 
		 * for(int i=0; i<ressult.size(); i++) System.out.print(ressult.get(i)+" ");
		 */

		// Arrays block
		int[] arr = new int[] { 3,2,1 };
		System.out.println("Given array is");

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		mergeSort(arr);

		System.out.println("\n");
		System.out.println("Sorted array is");

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

}
