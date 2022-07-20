package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

class Main {
	// Function to find the closest pair to `target` in given sorted arrays
	// `first` and `second`
	private static void findClosestPair(int[] first, int[] second, int target) {
		// base case
		if (first.length == 0 || second.length == 0) {
			return;
		}

		/* `x` and `y` points to the indexes of the closest pair found so far */

		// `x` initially points at the beginning of the first array
		int x = 0;

		// `y` initially points at the end of the second array
		int y = second.length - 1;

		// `i` initially points at the beginning of the first array
		// `j` initially points at the end of the second array

		for (int i = 0, j = second.length - 1; i < first.length && j >= 0;) {
			// maintain a search space `first[i…]` and `second[…j]`

			// update the closest pair found so far if the current pair `(i, j)`
			// is closer to `target`
			if (Math.abs(first[i] + second[j] - target) < Math.abs(first[x] + second[y] - target)) {
				x = i;
				y = j;
			}

			// if the sum of the current pair `(i, j)` is less than the given sum,
			// increment `i` (as an element at index `i+1` has more value than the
			// element at index `i`)
			if (first[i] + second[j] < target) {
				i++;
			}
			// if the sum of the current pair `(i, j)` is more than the given sum,
			// decrement `j` (as an element at index `j-1` has less value than the
			// element at index `j`)
			else if (first[i] + second[j] > target) {
				j--;
			}
			// otherwise, increment `i` and decrement `j`
			else {
				i++;
				j--;
			}
		}

		System.out.printf("The closest pair is [%d, %d]", first[x], second[y]);
	}

	ArrayList<Integer> solve22(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		int n = A.size();
		int m = B.size();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int diff = Integer.MAX_VALUE;
		int res_l = 0, res_r = 0;
		int l = 0, r = m - 1;
		while (l < m && r >= 0) {
			if (Math.abs(A.get(l) + B.get(r) - C) < diff) {
				res_l = A.get(l);
				res_r = B.get(r);
				diff = Math.abs(A.get(l) + B.get(r) - C);
			}
			if (A.get(l) + B.get(r) > C)
				r--;
			else
				l++;
		}

		ans.add(res_l);
		ans.add(res_r);
		return ans;
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		int diff = Integer.MAX_VALUE;
		int resl = 0, resr = 0;
		int l = 0, r = B.size() - 1;
		while (l < A.size() && r >= 0) {
			int temp = A.get(l) + B.get(r) - C;
			if (temp < 0)
				temp = temp * -1;
			if (temp < diff) {
				resl = l;
				resr = r;
				diff = temp;
			} else if (diff == temp && resl == l) {
				resr = r;
			}
			if (A.get(l) + B.get(r) >= C)
				r--;
			else
				l++;
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(A.get(resl));
		ans.add(B.get(resr));
		return ans;
	}

	public static void main(String[] args) {
		int[] first = { 1 };
		int[] second = { 2, 4 };
		int target = 4;
		Main closestPairFromSortedArrays = new Main();
		// findClosestPair(first, second, target);
		ArrayList<Integer> ar1 = new ArrayList<Integer>(Arrays.asList(1));
		ArrayList<Integer> ar2 = new ArrayList<Integer>(Arrays.asList(2, 4));
		ArrayList<Integer> result = closestPairFromSortedArrays.solve(ar1, ar2, 4);
		System.out.println(result);

	}
}