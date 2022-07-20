package com.intermediate.sorting;

/*
 Single Element in a Sorted Array
Problem Description

Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2


Example Explanation
Explanation 1:

 7 appears once
Explanation 2:

 2 appears once
 */

public class SingleElementInASortedArray {

	public static int search(int[] arr) {
		/*
		 * int mid = 0; if (high == 0) { return arr[0]; } else if (arr[0] != arr[1])
		 * return arr[0]; else if (arr[high] != arr[high - 1]) return arr[high];
		 * 
		 * while (low <= high) { mid = (low + high) / 2; if (arr[mid] != arr[mid + 1] &&
		 * arr[mid] != arr[mid - 1]) { return arr[mid]; } if (((arr[mid] % 2 == 0) &&
		 * (arr[mid] == arr[mid + 1])) || ((arr[mid] % 2 == 1) && (arr[mid] == arr[mid -
		 * 1]))) { low = mid + 1; } else { high = mid - 1; } } return -1;
		 */
		
		int left = 0, right = arr.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && arr[mid] == arr[mid +1]) || (mid %2 == 1 && arr[mid] == arr[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return arr[left];
        
	}


	public int solve(int[] A) {
		int left = 0, right = A.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && A[mid] == A[mid +1]) || (mid %2 == 1 && A[mid] == A[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return A[left];
	}

	public static void main(String[] args) {

		int[] input = {1,1,7};
		int result = new SingleElementInASortedArray().solve(input);
		System.out.println(result);

	}
	
	
	public class Solution {
		public int solve(int[] A) {
			int left = 0, right = A.length - 1;
			while (left < right) {
				int mid = (left + right) / 2;
				if ((mid % 2 == 0 && A[mid] == A[mid + 1]) || (mid % 2 == 1 && A[mid] == A[mid - 1]))
					left = mid + 1;
				else
					right = mid;
			}
			return A[left];
		}
	}


}
