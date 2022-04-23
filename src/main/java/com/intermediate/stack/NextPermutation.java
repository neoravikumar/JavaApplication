package com.intermediate.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 Next Permutation
Problem Description
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:

The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.


Problem Constraints
1 <= N <= 5 * 105

1 <= A[i] <= 109



Input Format
The first and the only argument of input has an array of integers, A.



Output Format
Return an array of integers, representing the next permutation of the given array.



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

 Next permutaion of [1, 2, 3] will be [1, 3, 2].
Explanation 2:

 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order.
 */
public class NextPermutation {
	
	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
		
		Stack<Integer> stack = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            if (stack.isEmpty() || A.get(i) >= stack.peek()) {
                stack.push(A.get(i));
            } else {
                int element = -1;
                List<Integer> list = new ArrayList<Integer>();
                while (!stack.isEmpty() && A.get(i) < stack.peek()) {
                    element = stack.pop();
                    list.add(element);
                }
                stack.push(A.get(i));
                for (int p = list.size() - 1 - 1; p >= 0; p--) {
                    stack.push(list.get(p));
                }
                A.set(i, element);
                for (int j = A.size() - 1; j > i; j--) {
                    A.set(j, stack.pop());
                }
            }
        }
        
        for (int j = A.size() - 1; j >= 0; j--) {
        	System.out.println(stack.pop());
            //nums[j] = stack.pop();
        }
        
        return A;
    }

	public static void main(String[] args) {
		NextPermutation nextPermutation = new NextPermutation();
		ArrayList<Integer> result = nextPermutation.nextPermutation(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		System.out.println(result);

	}

}
