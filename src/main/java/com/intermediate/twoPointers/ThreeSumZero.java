package com.intermediate.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 3 Sum Zero
Problem Description

Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0

Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.



Problem Constraints
0 <= N <= 7000

-108 <= A[i] <= 108



Input Format
Single argument representing a 1-D array A.



Output Format
Output a 2-D vector where each row represent a unique triplet.



Example Input
A = [-1,0,1,2,-1,4]


Example Output
[ [-1,0,1],
  [-1,-1,2] ]


Example Explanation
Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */
public class ThreeSumZero {
	
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		Collections.sort(A);
        HashSet<ArrayList<Integer>> hs = new LinkedHashSet<>();
        int n = A.size();
        for(int i=0;i<n-2;i++){
            int v = A.get(i);
            int j = i+1;
            int k = n-1;
            while(j<k){
                long v1 = A.get(j);
                long v2 = A.get(k);
                long sum = v1+v2+v;
                if(sum == 0){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(A.get(i));
                    l.add((int)v1);
                    l.add((int)v2);
                    hs.add(l);
                    j++;
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(hs);
    }

	public static void main(String[] args) {
		ThreeSumZero threeSumZero = new ThreeSumZero();
		 ArrayList<ArrayList<Integer>> result = new ThreeSumZero().threeSum(new ArrayList<Integer>(Arrays.asList(-1,0,1,2,-1,4)));
		 System.out.println(result);

	}

}
