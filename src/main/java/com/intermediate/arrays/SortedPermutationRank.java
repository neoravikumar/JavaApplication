package com.intermediate.arrays;

/*
 Sorted Permutation Rank
Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints
1 <= |A| <= 1000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank of the given string.



Example Input
Input 1:

A = "acb"
Input 2:

A = "a"


Example Output
Output 1:

2
Output 2:

1


Example Explanation
Explanation 1:

Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1.
 */
public class SortedPermutationRank {

	public int findRank(String A) {

		long rank = 1;

		if (A == null) {
			return 0;
		}

		for (int i = 0; i < A.length() - 1; i++) {
			int count = 0;
			for (int j = i + 1; j < A.length(); j++) {
				if (A.charAt(i) > A.charAt(j)) {
					count++;
				}
			}

			long facValue = factorial(A.length() - 1 - i) % 1000003;
			rank += (count * facValue) % 1000003;
			
			rank = rank % 1000003;
		}
		return new Long(rank).intValue();
	}

	public static long factorial(int n) {
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = (fact * i) % 1000003;
		}
		return fact % 1000003;
	}

	public static void main(String[] args) {

		SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();

		int result = sortedPermutationRank.findRank("DTNGJPURFHYEW");
		System.out.println(result);
	}

}
