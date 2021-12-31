package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountOfPairWithGivenSum {

	public int solve(ArrayList<Integer> A, int B) {

		// sort the array in ascending order
		Collections.sort(A);

		// maintain two indices pointing to endpoints of the array
		int low = 0;
		int high = A.size() - 1;

		int count = 0;

		// reduce the search space `nums[low…high]` at each iteration of the loop

		// loop till the search space is exhausted
		while (low < high) {
			// sum found
			if (A.get(low) + A.get(high) == B) {
				count++;
			}

			// increment `low` index if the total is less than the desired sum;
			// decrement `high` index if the total is more than the desired sum
			if (A.get(low) + A.get(high) < B) {
				low++;
			} else {
				high--;
			}
		}
		return count;
	}

	// Function to find a pair in an array with a given sum using sorting
	public static void findPair(int[] nums, int target) {
		// sort the array in ascending order
		Arrays.sort(nums);

		// maintain two indices pointing to endpoints of the array
		int low = 0;
		int high = nums.length - 1;

		// reduce the search space `nums[low…high]` at each iteration of the loop

		// loop till the search space is exhausted
		while (low < high) {
			// sum found
			if (nums[low] + nums[high] == target) {
				System.out.println("Pair found (" + nums[low] + "," + nums[high] + ")");
				return;
			}

			// increment `low` index if the total is less than the desired sum;
			// decrement `high` index if the total is more than the desired sum
			if (nums[low] + nums[high] < target) {
				low++;
			} else {
				high--;
			}
		}

		// we reach here if the pair is not found
		System.out.println("Pair not found");
	}

	public static void main(String[] args) {
		CountOfPairWithGivenSum subarrayWithGivenSum = new CountOfPairWithGivenSum();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		int result = subarrayWithGivenSum.solve(inputArray, 5);
		System.out.println(result);

	}

}
