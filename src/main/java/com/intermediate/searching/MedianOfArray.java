package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 Median of Array
Problem Description

There are two sorted arrays A and B of size N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log (m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N, M <= 106



Input Format
First argument is an integer array A of size N.
Second argument is an integer array B of size M.



Output Format
Return a decimal value denoting the median of two sorted arrays.



Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */
public class MedianOfArray {
	
	
	int length1 = 0;
    int length2 = 0;
    
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		
		/** double median;
		List<Integer> myList = new ArrayList<>();
		myList.addAll(a);
		myList.addAll(b);

		Collections.sort(myList);
		if (myList.size() % 2 != 0) {
			int temp = myList.size() / 2;
			median = myList.get(temp);
			return median;
		} else {
			int temp = myList.size() / 2;
			median = (double) (myList.get(temp) + myList.get(temp - 1)) / 2;
			return median;
		} */
		
		int sum = a.size() + b.size();
        int left = sum / 2;
        int lower = Integer.max(0, left - b.size());
        int upper = Integer.min(a.size(), left);
        while (true) {
            int i = (lower + upper) / 2;
            int j = left - i;
            int left1 = i == 0 ? Integer.MIN_VALUE : a.get(i-1);
            int left2 = j == 0 ? Integer.MIN_VALUE : b.get(j - 1);
            int right1 = i == a.size() ? Integer.MAX_VALUE : a.get(i);
            int right2 = j == b.size() ? Integer.MAX_VALUE : b.get(j);
            if (right1 < left2) {
                lower = i + 1;
            } else if (right2 < left1) {
                upper = i - 1;
            } else {
                int minRight = Integer.min(right1, right2);
                if (sum % 2 == 1) {
                    return minRight;
                }
                int maxLeft = Integer.max(left1, left2);
                return (maxLeft + minRight) / 2.0;
            }
        }
	}
	
	public static void main(String[] args) {
		MedianOfArray medianOfArray = new MedianOfArray();
		double myresult = medianOfArray.findMedianSortedArrays(Arrays.asList(1,4,5), Arrays.asList(2,3));
		System.out.println(myresult);

	}

}
