package com.intermediate.arrays;

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
	
	
	
	/*
	 * // Iterative function to calculate factorial of a number public static long
	 * factorial(int n) { long fact = 1; for (int i = 1; i <= n; i++) { fact = fact
	 * * i; } return fact; }
	 */
    
 // Returns Factorial of N
 	static BigInteger factorial(int N) {
 		// Initialize result
 		BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

 		// Multiply f with 2, 3, ...N
 		for (int i = 2; i <= N; i++)
 			f = f.multiply(BigInteger.valueOf(i));

 		return f;
 	}
 
    // Function to find the lexicographic rank of a string
    public static long findLexicographicRank(String str)
    {
    	int n = str.length(); 
        long mod = 1000003;
        long ans = 1; // As we have to add 1 to get rank. 
        for (int i = 0; i < n; i++) { 
        	long less_than = 0; 
            for (int j = i + 1; j < n; j++) { 
                if ((int)str.charAt(i) > (int)str.charAt(j)) { 
                    less_than += 1; 
                } 
            } 
            
            long permutation = (factorial(n-i-1).longValue()) % mod;
            long total_permutation = (less_than * permutation) % mod;
            
            ans = (ans + total_permutation)%mod; 
        } 
        return ans; 
    }
 
    public static void main(String[] args)
    {
        String str = "gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv";
 
        System.out.println("The lexicographic rank of " + str + " is ::\n"
                + findLexicographicRank(str));
    }
	
	
	
	

	/*
	 * public int findRank(String A) {
	 * 
	 * long rank = 1;
	 * 
	 * if (A == null) { return 0; }
	 * 
	 * for (int i = 0; i < A.length() - 1; i++) { int count = 0; for (int j = i + 1;
	 * j < A.length(); j++) { if (A.charAt(i) > A.charAt(j)) { count++; } }
	 * 
	 * long facValue = factorial(A.length() - 1 - i) % 1000003; rank += (count *
	 * facValue) % 1000003;
	 * 
	 * rank = rank % 1000003; } return new Long(rank).intValue(); }
	 * 
	 * public static long factorial(int n) { long fact = 1; for (int i = 1; i <= n;
	 * i++) { fact = (fact * i) % 1000003; } return fact % 1000003; }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();
	 * 
	 * int result = sortedPermutationRank.findRank("DTNGJPURFHYEW");
	 * System.out.println(result); }
	 */

}
