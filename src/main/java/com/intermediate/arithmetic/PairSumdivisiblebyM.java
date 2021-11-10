package com.intermediate.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Pair Sum divisible by M
Problem Description

Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 2
Input 2:

 A = [5, 17, 100, 11]
 B = 28


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
 */
public class PairSumdivisiblebyM {

	public int solve(ArrayList<Integer> A, int B) {
		int N = A.size();
		final int MOD = (int) (Math.pow(10, 9) + 7);
		/*
		 * //Brute Force int count = 0; int MOD = (int) (Math.pow(10, 9) + 7); for(int
		 * i=0;i<N;i++) { for(int j=i+1;j<N;j++) { int sum = A.get(i) + A.get(j);
		 * 
		 * if(sum%B == 0) { count++; } } } return count%MOD;
		 */

		// Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        long freq[] = new long[B];
 
        // Count occurrences of all remainders
        for (int i = 0; i < N; i++) {
        	++freq[A.get(i) % B];
        }
            
 
        // If both pairs are divisible by 'B'
        long sum = freq[0] * (freq[0] - 1) / 2;
 
        // count for all i and (B-i) freq pairs
        for (int i = 1; i <= B / 2 && i != (B - i); i++) {
        	long value = ((freq[i]% MOD) * (freq[B - i]% MOD))% MOD;
        	sum = sum % MOD + value % MOD;
        	sum %= MOD;
        }
            
        // If B is even
        if (B % 2 == 0) {
        	long value = ((freq[B / 2] * (freq[B / 2] - 1) ))/2;
        	sum += value;
        	sum %= MOD;
        }
        	
        return new Long(sum).intValue();
	}

	public static void main(String[] args) {
		PairSumdivisiblebyM pairSumdivisiblebyM = new PairSumdivisiblebyM();
		int result = pairSumdivisiblebyM.solve(new ArrayList(Arrays.asList(169, 291, 899, 864, 809, 102, 755, 715, 216, 933, 625, 33, 648, 305, 38, 160, 290, 684, 343, 607, 26, 303, 985, 328, 36, 940, 690, 635, 125, 797, 791, 52, 867, 487, 795, 89, 472, 952, 346, 32, 822, 796, 934, 378, 219, 138, 65, 462, 258, 588, 100, 158, 643, 351, 674, 269, 950, 795, 389, 385, 57, 42, 490, 515, 441, 255, 355, 775, 613, 349, 936, 776, 713, 784, 709, 106, 683, 961, 344, 528, 521, 466, 25, 20, 788, 116, 289, 859, 971, 281, 340, 274, 278, 458, 986, 46, 163, 445, 790, 602, 213, 749, 514, 805, 996, 52, 681, 614, 174, 668, 898, 262, 455, 907, 638, 408, 929, 202, 299, 944, 974, 646, 727, 832, 184, 334, 849, 341, 692, 508, 692, 552, 880, 59, 893, 849, 698, 386, 706, 372, 714, 929, 661, 127, 589, 1000, 275, 463, 877, 635, 628, 188, 926, 320, 199, 442, 189, 362, 101, 758, 419, 600, 716, 472, 102, 902, 789, 718, 924, 625, 252, 803, 276, 761, 375, 666, 579, 58, 390, 438, 674, 758, 367, 917, 674, 969, 977, 842, 408, 842, 742, 472, 72, 938, 502, 880, 757, 123, 156, 772, 270, 330, 138, 398, 106, 357, 736, 283, 433, 604, 103, 132, 722, 363, 728, 204, 980, 778, 225, 869, 607, 127, 512, 874, 560, 410, 853, 25, 862, 556, 766, 638, 487, 703, 522, 88, 288, 156, 789, 271, 986, 603, 8, 575 )), 16);
		// int result = pairSumdivisiblebyM.solve(new ArrayList(Arrays.asList(5, 17,
		// 100, 11)), 28);
		System.out.println("Result is:>" + result);
	}

}
