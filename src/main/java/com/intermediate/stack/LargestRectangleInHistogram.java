package com.intermediate.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
Largest Rectangle in Histogram
Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of the largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(ArrayList<Integer> A) {
        
        ArrayList<Integer> minLeft = getMinLeft(A);
       ArrayList<Integer> minRight = getMinRight(A);
       int maxArea = Integer.MIN_VALUE;
       //System.out.format("%10s%10s%10s%10s%10s%10s","i","A","mL","mR","Base","Area","Max");
       for(int i=0;i<A.size();i++){
           int base = minRight.get(i) - minLeft.get(i) - 1;
           //System.out.println("");
           maxArea = Math.max(maxArea,base*A.get(i));
           //System.out.format("%10d%10d%10d%10d%10d%10d%10d",i, A.get(i), minLeft.get(i),minRight.get(i),base,base*A.get(i),maxArea);
       }
       return maxArea;
       
   }
   
   public ArrayList<Integer> getMinLeft(ArrayList<Integer> A){
       ArrayList<Integer> result = new ArrayList<>();
       Stack<Integer> minStack = new Stack<>();

       for(int i=0;i<A.size();i++){
           int a = A.get(i);
           while(!minStack.isEmpty() && A.get(minStack.peek()) >= a){
               minStack.pop();
           }
           result.add(minStack.isEmpty() ? -1 : minStack.peek());
           minStack.push(i);
       }
       return result;
   }

   public ArrayList<Integer> getMinRight(ArrayList<Integer> A){
       ArrayList<Integer> result = new ArrayList<>();
       Stack<Integer> minStack = new Stack<>();

       for(int i=A.size()-1;i>=0;i--){
           int a = A.get(i);
           while(!minStack.isEmpty() && A.get(minStack.peek()) >= a){
               minStack.pop();
           }
           result.add(minStack.isEmpty() ? A.size() : minStack.peek());
           minStack.push(i);
       }
       Collections.reverse(result);
       return result;
   }

	public static void main(String[] args) {
		LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
		int result = largestRectangleInHistogram.largestRectangleArea(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3)));
		System.out.println(result);

	}

}
