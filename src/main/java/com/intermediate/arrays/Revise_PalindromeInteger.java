package com.intermediate.arrays;

/*
 Palindrome Integer
Problem Description

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
 */
public class Revise_PalindromeInteger {

	public int isPalindrome(int A) {
		int result = 0;
		int reverseno=0;
		int copyNumber=A;
		
		if(A==0 || A>0) {
			for(int i=A;i!=0;) {
				int digit = A%10;
				reverseno = (reverseno*10)+digit;
				i=A=A/10;
			}
			
			if(copyNumber==reverseno) {
				return 1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		Revise_PalindromeInteger palindromeInteger = new Revise_PalindromeInteger();

		int result = palindromeInteger.isPalindrome(-9990);
		System.out.println(result);

	}

}
