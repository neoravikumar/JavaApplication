package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 Largest Number
Problem Description

Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
First argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320. 
 */
public class LargestNumber {

	public String largestNumber(final List<Integer> A) {

		/*
		 * StringBuilder result = new StringBuilder();
		 * 
		 * for(int i=0;i<A.size();i++) { for(int k=i;k<A.size();k++) {
		 * System.out.print(A.subList(i, k+1)+"\t"); } System.out.println(); }
		 * 
		 * return null;
		 * 
		 * List<String> sTringArray = new ArrayList<String>(); for(int
		 * k=0;k<A.size();k++) { String aa = A.get(k).toString(); sTringArray.add(
		 * A.get(k).toString()); }
		 * 
		 * Collections.sort(sTringArray, new Comparator<String>() { // A comparison
		 * function which is used by // sort() in printLargest()
		 * 
		 * @Override x` public int compare(String X, String Y) {
		 * 
		 * // first append Y at the end of X String XY = X + Y;
		 * 
		 * // then append X at the end of Y String YX = Y + X;
		 * 
		 * // Now see which of the two // formed numbers // is greater return
		 * XY.compareTo(YX) > 0 ? -1 : 1; } });
		 * 
		 * Iterator it = A.iterator(); StringBuilder sb = new StringBuilder();
		 * 
		 * while (it.hasNext()) { sb.append(it.next()); }
		 * 
		 * return sb.toString();
		 */

		// sort using a custom function object

		int zeroCounter = 0;
		
		for (int k = 0; k < A.size(); k++) {
			if (A.get(k) == 0) {
				++zeroCounter;
			}
		}
		if (zeroCounter == A.size()) {
			return "0";
		}

		Collections.sort(A, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
		
		String result = A.stream().map(Object::toString).collect(Collectors.joining(""));

		return result;
	}

	public static void main(String[] args) {

		LargestNumber ln = new LargestNumber();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));

		String result = ln.largestNumber(A);
		System.out.println(result);

		System.out.println(new Integer(00000));
	}

}
