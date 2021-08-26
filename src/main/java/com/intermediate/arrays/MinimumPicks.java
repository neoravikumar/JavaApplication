package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.List;

/*MINIMUM PICKS
Problem Description

You are given an array of integers A of size N.
Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.



Problem Constraints
2 <= N <= 10^5
-10^9 <= A[i] <= 10^9
There is atleast 1 odd and 1 even number in A



Input Format
The first argument given is the integer array, A.



Output Format
Return maximum among all even numbers of A - minimum among all odd numbers in A.


Example Input
Input 1:

 A = [0, 2, 9]
Input 2:

 A = [5, 17, 100, 1]


Example Output
Output 1:

-7
Output 2:

99


Example Explanation
Explanation 1:

Maximum of all even numbers = 2
Minimum of all odd numbers = 9
ans = 2 - 9 = -7
Explanation 2:

Maximum of all even numbers = 100
Minimum of all odd numbers = 1
ans = 100 - 1 = 99

*
*/

public class MinimumPicks {

	public int solve(int[] A) {

		List oddArray = new ArrayList<Integer>();
		List evenArray = new ArrayList<Integer>();

		int k = 0, l = 0;
		int maxEven = Integer.MIN_VALUE, minOdd = Integer.MAX_VALUE;
		if (null != A && (A.length >= 2 && A.length <= Math.pow(10, 5))) {

			for (int i = 0; i < A.length; i++) {
				System.out.println(A[i]);
				if (A[i] >= Math.pow(10, -9) || A[i] <= Math.pow(10, 9)) {
					System.out.println("JKKj::"+A[i]);
					if (A[i] % 2 == 0) {
						System.out.println(A[i]+"kjfjkd::"+A[i] % 2);
						maxEven = maxEven > A[i] ? maxEven : A[i];
						evenArray.add(A[i]);
					} else {
						minOdd = A[i] < minOdd ? A[i] :minOdd;
						//System.out.println(minOdd+":"+A[i]);
						oddArray.add(A[i]);
					}
				}
			}

			System.out.println("OddAray:" + oddArray);
			System.out.println("EvenArray:" + evenArray);

			System.out.println("MaxEven:" + maxEven + "\t MinOdd:" + minOdd);
		}
		return maxEven - minOdd;
	}

	public static void main(String[] args) {

		MinimumPicks mp = new MinimumPicks();
		//int[] intputArray = { -98, 54, -52, 15, 23, -97, 12, -64, 52, 85};
		 //int[] intputArray = {-15, -45, 43, 23, -63, 69, 35, 19, 37, -52 };
		int[] intputArray = {5, 17, 100, 1 };
		System.out.println(mp.solve(intputArray));
	}

}
