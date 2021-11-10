package com.intermediate.bitWise;

public class BitWiseOperations {
	
	int foo( int a, int b ) {
	    int c = ((a ^ b) >>> 0);
	    return c;
	}
	public static void main(String[] args) {
		BitWiseOperations bitWiseOperations = new BitWiseOperations();
		bitWiseOperations.foo(5, 1);
	}

}
