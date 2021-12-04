package com.intermediata.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test22 {

	private static final long MOD = 0;
	static int MAX = 100;

	// Return summation of r * nCr
	int summation(int n) {
		System.out.println();
		return n << (n - 1);
	}

	public static void main(String[] args) {
		int A = 39;

		long power = (long) Math.pow(3, A - 2);
		long multiple = A * (A-1);
		long MOD = (long) (Math.pow(10, 9)+7);
		long result = ((power % MOD) * (multiple%MOD) % MOD);
		
		long result2 = new Long(25);
		
		System.out.println(result);
		
		
		ArrayList<Integer> Aa = new ArrayList<Integer>(Arrays.asList(-1, -2, -3, 4, 5));
		Collections.sort(Aa);
		System.out.print(Aa);
		
		
		
		System.out.println(4980%10);
	}

}
