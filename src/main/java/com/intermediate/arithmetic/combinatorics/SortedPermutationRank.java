package com.intermediate.arithmetic.combinatorics;

import java.math.BigInteger;

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

	static int MAX_CHAR = 256;

	public int findRank(String A) {

		char[] str = A.toCharArray();

		int len = str.length;
		long mul = factorial(len).longValue();
		long rank = 1l, i;

		// all elements of count[] are initialized with 0
		int count[] = new int[MAX_CHAR];

		// Populate the count array such that count[i]
		// contains count of characters which are present
		// in str and are smaller than i
		populateAndIncreaseCount(count, str);

		for (i = 0l; i < len; ++i) {
			mul /= len - i;

			// count number of chars smaller than str[i]
			// from str[i+1] to str[len-1]
			rank += count[str[(int) i] - 1] * mul;

			// Reduce count of characters greater than str[i]
			updatecount(count, str[(int) i]);
		}

		BigInteger ab = new BigInteger(String.valueOf(rank));
		System.out.println(">>>"+ab.longValue() % 1000003);
		return new Long(ab.longValue() % 1000003).intValue();

	}

	static void populateAndIncreaseCount(int[] count, char[] str) {
		int i;

		for (i = 0; i < str.length; ++i)
			++count[str[i]];

		for (i = 1; i < MAX_CHAR; ++i)
			count[i] += count[i - 1];
	}

	// A utility function to find factorial of n
	private long fact(int n) {
		return (n <= 1) ? 1 : (n * fact(n - 1));
	}

	// Returns Factorial of N
	static BigInteger factorial(int N) {
		// Initialize result
		BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

		// Multiply f with 2, 3, ...N
		for (int i = 2; i <= N; i++)
			f = f.multiply(BigInteger.valueOf(i));

		return f;
	}

	static void updatecount(int[] count, char ch) {
		int i;
		for (i = ch; i < MAX_CHAR; ++i)
			--count[i];
	}

	public static void main(String[] args) {
		SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();
		// int result = sortedPermutationRank.findRank("DTNGJPURFHYEW");
		int result = sortedPermutationRank.findRank("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv");
		// 342501 // 318057 //569228
		System.out.println("Result is:>>" + result);

	}

}
