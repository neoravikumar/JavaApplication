package com.intermediate.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 ALL GCD PAIR
Problem Description

Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



Problem Constraints
1 <= N <= 10000

1 <= A[i] <= 109



Input Format
The first and only argument given is the integer array A.



Output Format
Find and return the original numbers which are used to calculate the GCD array in any order.



Example Input
Input 1:

 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:

 A = [5, 5, 5, 15]


Example Output
Output 1:

 [2, 8, 10]
Output 2:

 [5, 15]


Example Explanation
Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
 */
public class ALLGCDPAIR {

	private int gcd(int a, int b) {
		if (a == 0)
			return b;
		if (a == 1)
			return 1;
		return gcd(b % a, a);

	}

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		
		int n = A.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		Collections.sort(A, Collections.reverseOrder());
		int freq[] = new int[A.get(0) + 1];
        // Count frequency of each element
        for (int i = 0; i < n; i++)
        {
            freq[A.get(i)]++;
        }
        // Size of the resultant array
        int size = (int) Math.sqrt(n);
        int tempArray[] = new int[size], x, l = 0;
        for (int i = 0; i < n; i++)
        {
            if (freq[A.get(i)] > 0 && l < size)
            {
                // Store the highest element in the resultant array
            	tempArray[l] = A.get(i);
 
                // Decrement the frequency of that element
                freq[tempArray[l]]--;
                l++;
                for (int j = 0; j < l; j++)
                {
                    if (i != j)
                    {
                        // Compute GCD
                        x = gcd(A.get(i), tempArray[j]);
                        // Decrement GCD value by 2
                        freq[x] -= 2;
                    }
                }
            }
        }
        
        for(int a : tempArray) {
        	result.add(a);
        }
        
		
		return result;
    }

	public static void main(String[] args) {
		ALLGCDPAIR allgcdpair = new ALLGCDPAIR();
		ArrayList<Integer> result = allgcdpair.solve(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10)));
		System.out.println(result);

	}

}
