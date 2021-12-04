package com.intermediate.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Find a peak element
Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
 */
public class FindAPeakElement {

	private int findPeakElement(ArrayList<Integer> A, int start, int end, int n) {

		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (mid == 0 || A.get(mid - 1) < A.get(mid) && mid == n - 1 || A.get(mid + 1) < A.get(mid)) {
			return mid;
		} else if (mid > 0 && A.get(mid - 1) > A.get(mid)) {
			return findPeakElement(A, start, mid - 1, n);
		} else {
			return findPeakElement(A, mid + 1, end, n);
		}

	}

	public int solve(ArrayList<Integer> A) {
		int N = A.size();
		int index = findPeakElement(A, 0, N - 1, N);
		return A.get(index);

	}

	public static void main(String[] args) {
		FindAPeakElement findAPeakElement = new FindAPeakElement();
		int result = findAPeakElement.solve(new ArrayList<Integer>(Arrays.asList(506, 521, 522, 530, 532, 537, 560, 569,
				577, 578, 585, 590, 591, 594, 622, 632, 639, 665, 674, 678, 695, 707, 714, 722, 730, 752, 754, 759, 766,
				787, 790, 810, 817, 857, 871, 883, 887, 897, 913, 914, 925, 930, 956, 976, 979, 987, 1015, 1065, 1085,
				1089, 1109, 1117, 1156, 1169, 1191, 1195, 1202, 1207, 1208, 1257, 1297, 1327, 1396, 1422, 1423, 1432,
				1435, 1439, 1470, 1487, 1511, 1521, 1522, 1549, 1561, 1564, 1585, 1642, 1661, 1664, 1682, 1685, 1703,
				1704, 1708, 1712, 1723, 1728, 1732, 1738, 1754, 1771, 1775, 1822, 1844, 1926, 1989, 1979, 1955, 1947,
				1927, 1907, 1845, 1789, 1788, 1780, 1776, 1772, 1758, 1734, 1732, 1719, 1709, 1680, 1677, 1670, 1651,
				1644, 1643, 1555, 1541, 1534, 1529, 1388, 1365, 1355, 1341, 1335, 1332, 1303, 1286, 1265, 1250, 1233,
				1224, 1164, 1159, 1144, 1133, 1118, 1098, 1053, 1051, 985, 972, 949, 947, 935, 933, 925, 902, 870, 865,
				854, 852, 830, 825, 817, 802, 770, 757, 754, 746, 745, 677, 669, 599, 561, 527, 503)));
		// int result = findAPeakElement.solve(new ArrayList<Integer>(Arrays.asList(5,
		// 17, 100, 11)));
		System.out.println(result);
	}

}
