package com.intermediate.bitWise;

/*Count Total Set Bits
Problem Description

Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.



Example Input
Input 1:

 A = 3
Input 2:

 A = 1


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1*/

public class BitwiseQuestion4 {

	public int solve(int A) {
		long sum = 0;
		if (A >= 1 && A <= Math.pow(10, 9)) {
			for (int i = 1; i <= A; i++) {
				sum += new Integer(i).bitCount(i);
			}
			
			sum = sum % ((long)Math.pow(10, 9) + 7);
		}
		return (int) sum;
	}

	public static void main(String[] args) {
		BitwiseQuestion4 bitwiseQuestion4 = new BitwiseQuestion4();
		System.out.println(bitwiseQuestion4.solve(1000000000));

	}

}
