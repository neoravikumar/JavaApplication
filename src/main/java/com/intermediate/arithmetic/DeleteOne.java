package com.intermediate.arithmetic;

/*
 Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the maximum value of GCD.



Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:

 
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 */
public class DeleteOne {

	public int solve(int[] A) {

		// Prefix and Suffix arrays
        int Prefix[] = new int[A.length + 2];
        int Suffix[] = new int[A.length + 2] ;
     
        Prefix[1] = A[0];
        for (int i = 2; i <= A.length; i += 1)
        {
            Prefix[i] = gcd(Prefix[i - 1], A[i - 1]);
        }
     
        // Initializing Suffix array
        Suffix[A.length] = A[A.length - 1];
     
        for (int i = A.length - 1; i >= 1; i -= 1)
        {
            Suffix[i] = gcd(Suffix[i + 1], A[i - 1]);
        }
     
        // If first or last element of the array has to be removed
        int ans = Math.max(Suffix[2], Prefix[A.length - 1]);
     
        // If any other element is replaced
        for (int i = 2; i < A.length; i += 1)
        {
            ans = Math.max(ans, gcd(Prefix[i - 1], Suffix[i + 1]));
        }
     
        return ans;
	}

	// To Print GCD
	private int gcd(int A, int B) {
		while (B != 0) {
			int r = A % B;
			A = B;
			B = r;
		}
		return A;
	}

	public static void main(String[] args) {
		DeleteOne deleteOne = new DeleteOne();
		int a[] = { 14, 17, 28, 70 };
        int n = a.length;
        System.out.println(deleteOne.solve(a));

	}

}
