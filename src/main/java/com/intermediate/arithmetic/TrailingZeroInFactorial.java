package com.intermediate.arithmetic;

public class TrailingZeroInFactorial {

	public int trailingZeroes(int A) {
		if (A < 0) {
			return -1;
		}
		int count = 0;

		for (int i = 5; A / i >= 1; i *= 5) {
			count += A / i;
		}
		return count;
	}

	public static void main(String[] args) {
		TrailingZeroInFactorial trailingZeroInFactorial = new TrailingZeroInFactorial();
		
		int result = trailingZeroInFactorial.trailingZeroes(6);
		System.out.println(result);

	}

}
