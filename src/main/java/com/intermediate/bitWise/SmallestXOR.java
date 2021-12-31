package com.intermediate.bitWise;

/*
 Smallest XOR
Problem Description

Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.



Problem Constraints
0 <= A <= 109
0 <= B <= 30



Input Format
First argument contains a single integer A. Second argument contains a single integer B.



Output Format
Return a single integer X.



Example Input
Input 1:

 A = 3
 B = 3
Input 2:

 A = 15
 B = 2


Example Output
Output 1:

 7
Output 2:

 12


Example Explanation
Explanation 1:

 3 xor 7 = 4 which is minimum
Explanation 2:

 15 xor 12 = 3 which is minimum
 */
public class SmallestXOR {

	// Function to return the value x such that (x XOR a) is minimum and the number
	// of set bits in x is equal to the number of set bits in b
	static int minVal(int a, int b) {
		// Count of set-bits in bit
		int setBits = countSetBitInN(b);
		int ans = 0;

		for (int i = 30; i >= 0; i--) {
			int mask = 1 << i;

			// If i'th bit is set also set the
			// same bit in the required number
			if ((a & mask) > 0 && setBits > 0) {
				ans |= (1 << i);

				// Decrease the count of setbits
				// in b as the count of set bits
				// in the required number has to be
				// equal to the count of set bits in b
				setBits--;
			}
		}
		return ans;
	}

	private static int countSetBitInN(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	/*
	 * public int solve(int A, int B) {
	 * 
	 * int setBitsA = countSetBitInN(A); int setBitsB = countSetBitInN(B);
	 * if(setBitsA == setBitsB) { return A; } else if(setBitsA>setBitsB) { int diff
	 * = setBitsA - setBitsB;
	 * 
	 * }else { }
	 * 
	 * 
	 * 
	 * int ans = 0; for (int i = 30; i >= 0; i--) { int mask = 1 << i; if ((A &
	 * mask) > 0 && setBits > 0) { ans |= (1 << i); setBits--; } } return ans; }
	 */

	public int solve(int A, int B) {
		int number = A;
		int res = 0;
		int i = 0;
		int setBits = 0;
		while (number > 0) {
			number = number & (number - 1);
			setBits += 1;
		}
		while (setBits < B) {
			if ((A & (1 << i)) > 0) {
				res = res | (1 << i);
				setBits -= 1;
				B -= 1;
			} else {
				res = res | (1 << i);
				B -= 1;
			}
			i += 1;
		}
		while (setBits > B) {
			if ((A & (1 << i)) > 0) {
				setBits -= 1;
			}
			i += 1;
		}
		while (setBits > 0 && B > 0) {
			if ((A & (1 << i)) > 0) {
				res = res | (1 << i);
				setBits -= 1;
				B -= 1;
			}
			i += 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int a = 4, b = 6;
		System.out.println(new SmallestXOR().solve(a, b));

	}

}
