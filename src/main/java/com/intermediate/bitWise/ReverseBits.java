package com.intermediate.bitWise;

/*
 Reverse Bits
Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.



Example Input
Input 1:

 0
Input 2:

 3


Example Output
Output 1:

 0
Output 2:

 3221225472


Example Explanation
Explanation 1:

        00000000000000000000000000000000    
=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011    
=>      11000000000000000000000000000000
 */
public class ReverseBits {

	/*
	 * public static String toBinaryString(int n) { return String.format("%32s",
	 * Integer.toBinaryString(n)) .replaceAll(" ", "0"); }
	 * 
	 * 
	 * public static double log(int x, int base) { return (Math.log(x) /
	 * Math.log(base)); }
	 * 
	 * // Function to reverse bits of a given integer public static int
	 * reverseBits(int n) { // store reversed bits of `n`. Initially, all bits are
	 * set to 0 int reverse = 0;
	 * 
	 * // do till all set bits are processed while (n != 0) { // find the position
	 * of the rightmost set bit double pos = log(n & -n, 2) + 1;
	 * 
	 * // set the corresponding bit in the result // (set the leftmost bit at `pos`)
	 * reverse = reverse | (1 << (Integer.SIZE - (int)pos));
	 * 
	 * // unset the rightmost set bit of a number n = n & (n - 1); }
	 * 
	 * return reverse; }
	 * 
	 * public long reverse(long a) {
	 * 
	 * 
	 * 
	 * char[] binaryString = new char[32];
	 * 
	 * char[] inputString = Long.toBinaryString(a).toCharArray(); for (int k = 0; k
	 * < binaryString.length; k++) { if (k < inputString.length) { binaryString[k] =
	 * inputString[k]; } else { binaryString[k] = '0'; } }
	 * 
	 * StringBuilder sb = new StringBuilder(); sb.append(binaryString);
	 * 
	 * BigInteger i = new BigInteger(sb.toString(), 2); System.out.println(i);
	 * 
	 * return Long.parseLong(sb.toString(), 2);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * BigInteger input = new BigInteger(String.valueOf(a)); StringBuilder sb = new
	 * StringBuilder(); sb.append(input.toString(2)); BigInteger ab =
	 * BigInteger.valueOf(Long.parseLong(sb.reverse().toString(),2)); return
	 * ab.longValue();
	 * 
	 * 
	 * }
	 */
	
	public static long reverse(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;

    }

	public static void main(String[] args) {
		ReverseBits reverseBits = new ReverseBits();
		long result = reverseBits.reverse(4);
		// 1073741824
		// 1,073,741,824
		System.out.println(result);

	}

}
