package com.intermediata.test;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {

	public int binarySearch(ArrayList<Integer> A, int start, int end, int key) {

		/*
		 * while (start <= end) { int mid = (start + end) / 2; if (k == A.get(mid)) {
		 * return mid; } else if (k > A.get(mid)) { start = mid + 1; } else { end = mid
		 * - 1; } } return -1;
		 */

		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (A.get(mid) == key)
				return mid;
			if (key > A.get(mid))
				return binarySearch(A, mid + 1, end, key);
			return binarySearch(A, start, mid - 1, key);
		}
		return -1;

		/*
		 * if (start == end) { if (A.get(start) == key) { return start; } } else { int
		 * mid = (start + end) / 2; if (key == A.get(mid)) { return mid; } if (key >
		 * A.get(mid)) { binarySearch(A, mid + 1, end, key); } else { binarySearch(A,
		 * start, mid - 1, key); } } return start;
		 */
	}

	// Driven Program
	public static void main(String[] args) {
		BinarySearch your = new BinarySearch();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 9, 88, 99, 909));
		int N = A.size();
		int start = 0;
		int end = N - 1;

		int result = your.binarySearch(A, start, end, 99);
		System.out.println(result);
	}

}
