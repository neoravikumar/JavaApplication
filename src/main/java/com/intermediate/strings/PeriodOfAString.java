package com.intermediate.strings;

/*
 Period of a string
Problem Description

Given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.



Problem Constraints
1 <= N <= 106



Input Format
First and only argument is a string A of length N.



Output Format
Return an integer, denoting the period of the string.



Example Input
Input 1:

 A = "abababab"
Input 2:

 A = "aaaa"


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Period of the string will be 2: 
 Since, for all i, A[i] = A[i%2]. 
Explanation 2:

 Period of the string will be 1.
 */
public class PeriodOfAString {

	private int[] zArray(String str) {
		int n = str.length();
		int Z[] = new int[n];
		int left = 0, right = 0;

		for (int i = 1; i < n; ++i) {
			if (i > right) {

				left = right = i;
				while (right < n && str.charAt(right - left) == str.charAt(right))
					right++;

				Z[i] = right - left;
				right--;

			} else {
				int k = i - left;
				if (Z[k] < right - i + 1)
					Z[i] = Z[k];
				else {
					left = i;
					while (right < n && str.charAt(right - left) == str.charAt(right))
						right++;

					Z[i] = right - left;
					right--;
				}
			}
		}
		return Z;
	}

	public int solve(String A) {

		int Z[] = zArray(A);
		int N = Z.length;
		int k = N;

		for (int i = 1; i < N; i++) {
			if (i + Z[i] == N) {
				k = i;
				break;
			}
		}

		return k;

	}

	public static void main(String[] args) {

		PeriodOfAString periodOfAString = new PeriodOfAString();

		int result = periodOfAString.solve("abababab");
		System.out.println(result);

		int i = 3;
		System.out.println(Math.floor(i / 2));

	}

}
