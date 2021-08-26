package com.intermediate.bitWise;

import java.math.BigInteger;

/*Add Binary Strings
Problem Description

Given two binary strings, return their sum (also a binary string).
Example:

a = "100"

b = "11"
Return a + b = "111". */

public class BitwiseQuestion3 {

	/*
	 * public String addBinary(String A, String B) {
	 * 
	 * char[] a = A.toCharArray(); char[] b = B.toCharArray(); int firstDecimal =
	 * convertBinaryToDecimal(a); int secondDecimal = convertBinaryToDecimal(b);
	 * String result = convertDecimalToBinary(firstDecimal + secondDecimal); return
	 * result;
	 * 
	 * }
	 */

	private String convertDecimalToBinary(int i) {
		String result = "", finalResult = "";
		while (i > 0) {
			result += String.valueOf(i % 2);
			i = i / 2;
		}
		char[] binayResult = result.toCharArray();
		for (int k = binayResult.length - 1; k >= 0; k--) {

			finalResult += binayResult[k];
		}
		return finalResult;
	}

	private int convertBinaryToDecimal(char[] a) {
		int result = 0, powerValue = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			result += (int) (Character.getNumericValue(a[i]) * Math.pow(2, powerValue));
			++powerValue;
		}
		return result;
	}

	/**
	 * Another method for Binary operation;
	 * @param A
	 * @param B
	 * @return
	 */
	public String addBinary(String A, String B) {
		BigInteger sum = new BigInteger(A, 2).add(new BigInteger(B, 2));
		String resultString = sum.toString(2);
        return resultString;
    	}
	

	public static void main(String[] args) {
		
		/*
		 * BitwiseQuestion3 bitwiseQuestion3 = new BitwiseQuestion3(); String result =
		 * bitwiseQuestion3.addBinary(
		 * "10001100010111000101100010100110001001101010000010011010",
		 * "101111000100100100111110010010101110101001100100101001111010011000000110");
		 * System.out.println("Result:>>"+result);
		 */
		
		/*
		 * Long first = new
		 * Long("10001100010111000101100010100110001001101010000010011010"); Long second
		 * = new Long(
		 * "101111000100100100111110010010101110101001100100101001111010011000000110");
		 */
		
		BitwiseQuestion3 bitwiseQuestion3 = new BitwiseQuestion3();
		String result = bitwiseQuestion3.addBinary("10001100010111000101100010100110001001101010000010011010", "101111000100100100111110010010101110101001100100101001111010011000000110");
		System.out.println(result);
		
		/*
		 * BigInteger i = new BigInteger("111", 2); BigInteger j = new
		 * BigInteger("1000", 2); BigInteger sum = i.add(j); String resultString =
		 * sum.toString(2); System.out.println(resultString);
		 */
		
		
		 
		
		
	}

}
