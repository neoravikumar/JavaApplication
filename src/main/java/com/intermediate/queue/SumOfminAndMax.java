package com.intermediate.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**

Sum of min and max
Problem Description
Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 
Explanation 2:

 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
 */


public class SumOfminAndMax {
	
	public int solve(ArrayList<Integer> A, int B) {
		/*
		 * int N = A.size(); long maxSum = 0L; final long MOD = (long) (Math.pow(10, 9)
		 * + 7); for (int i = 0; i < N && (i + B <= N); i++) { List<Integer> myList =
		 * A.subList(i, i + B); int min = Integer.MAX_VALUE; int max =
		 * Integer.MIN_VALUE;
		 * 
		 * for (int k = 0; k < myList.size(); k++) { max = Math.max(max, myList.get(k));
		 * min = Math.min(min, myList.get(k)); } maxSum += (max + min) % MOD; } return
		 * (int) maxSum;
		 */
		final long MOD = (long) (Math.pow(10, 9) * + 7);
		long sum = 0l; 
		Deque<Integer> S=new LinkedList<>(), G=new LinkedList<>();
		
		int i = 0;
		
		for (i = 0; i < B; i++)
        {
            while ( !S.isEmpty() && A.get(S.peekLast()) >= A.get(i))
                S.removeLast(); 
   
            while ( !G.isEmpty() && A.get(G.peekLast()) <= A.get(i))
                G.removeLast(); 
   
            G.addLast(i);
            S.addLast(i);
        }
		
		 for (  ; i < A.size(); i++ )
	        {
	            
	            sum += A.get(S.peekFirst()) + A.get(G.peekFirst());
	   
	     
	            while ( !S.isEmpty() && S.peekFirst() <= i - B)
	                S.removeFirst();
	            
	            while ( !G.isEmpty() && G.peekFirst() <= i - B)
	                G.removeFirst();
	   
	            while ( !S.isEmpty() && A.get(S.peekLast()) >= A.get(i))
	                S.removeLast(); 
	            
	            while ( !G.isEmpty() && A.get(G.peekLast()) <= A.get(i))
	                G.removeLast(); 
	            
	            G.addLast(i);
	            S.addLast(i);
	        }
	        sum += (A.get(S.peekFirst()) + A.get(G.peekFirst())) % MOD;
	        return (int)sum;
	}
	
	public int solveII(ArrayList<Integer> A, int B) {
		/*
		 * int N = A.size(); long maxSum = 0L; final long MOD = (long) (Math.pow(10, 9)
		 * + 7); for (int i = 0; i < N && (i + B <= N); i++) { List<Integer> myList =
		 * A.subList(i, i + B); int min = Integer.MAX_VALUE; int max =
		 * Integer.MIN_VALUE;
		 * 
		 * for (int k = 0; k < myList.size(); k++) { max = Math.max(max, myList.get(k));
		 * min = Math.min(min, myList.get(k)); } maxSum += (max + min) % MOD; } return
		 * (int) maxSum;
		 */
		final long MOD = (long) (Math.pow(10, 9) * + 7);
		long sum = 0l; 
		Deque<Integer> S=new LinkedList<>(), G=new LinkedList<>();
		
		int i = 0;
		
		for (i = 0; i < B; i++)
        {
            // Remove all previous greater elements that are useless.
            while ( !S.isEmpty() && A.get(S.peekLast()) >= A.get(i))
                S.removeLast(); // Remove from rear
   
            // Remove all previous smaller that are elements are useless.
            while ( !G.isEmpty() && A.get(G.peekLast()) <= A.get(i))
                G.removeLast(); // Remove from rear
   
            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }
		
		 for (  ; i < A.size(); i++ )
	        {
	            // Element at the front of the deque 'G' & 'S'
	            // is the largest and smallest
	            // element of previous window respectively
	            sum += A.get(S.peekFirst()) + A.get(G.peekFirst());
	   
	            // Remove all elements which are out of this
	            // window
	            while ( !S.isEmpty() && S.peekFirst() <= i - B)
	                S.removeFirst();
	            while ( !G.isEmpty() && G.peekFirst() <= i - B)
	                G.removeFirst();
	   
	            // remove all previous greater element that are
	            // useless
	            while ( !S.isEmpty() && A.get(S.peekLast()) >= A.get(i))
	                S.removeLast(); // Remove from rear
	   
	            // remove all previous smaller that are elements
	            // are useless
	            while ( !G.isEmpty() && A.get(G.peekLast()) <= A.get(i))
	                G.removeLast(); 
	   
	            // Add current element at rear of both deque
	            G.addLast(i);
	            S.addLast(i);
	        }
	   
	        sum += (A.get(S.peekFirst()) + A.get(G.peekFirst())) % MOD;
	   
	        return (int)sum;
		
		
	}


	public static void main(String[] args) {
		SumOfminAndMax sumOfminAndMax = new SumOfminAndMax();
		int result = sumOfminAndMax.solve(new ArrayList<Integer>(Arrays.asList(2, 5, -1, 7, -3, -1, -2)), 4);
		System.out.println(result);

	}

}
