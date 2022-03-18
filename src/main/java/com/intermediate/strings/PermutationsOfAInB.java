package com.intermediate.strings;

/**
Permutations of A in B
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two argument, A and B of type String.



Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
 */
public class PermutationsOfAInB {
	
	static int MAX = 256;
	
	static boolean compare(char arr1[], char arr2[])
    {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
	
	public int solve(String A, String B) {
		int count=0;
		int M = A.length();
        int N = B.length();
        
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++)
        {
            (countP[A.charAt(i)])++;
            (countTW[B.charAt(i)])++;
        }
        
        for (int i = M; i < N; i++)
        {
            if (compare(countP, countTW)) {
            	count++;
            }
             
            (countTW[B.charAt(i)])++;
 
            countTW[B.charAt(i-M)]--;
        }
        
        if (compare(countP, countTW)) {
        	count++;
        }
           return count;
        
	}

	public static void main(String[] args) {
		String txt = "abcbacabc";
        String pat = "abc";
        PermutationsOfAInB permutationsOfAInB = new PermutationsOfAInB();
       int result = permutationsOfAInB.solve(pat, txt);
       System.out.println(result);

	}

}
