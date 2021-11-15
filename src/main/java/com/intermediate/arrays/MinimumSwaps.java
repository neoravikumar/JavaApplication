package com.intermediate.arrays;

/*
 Minimum Swaps
Problem Description

Given an Aay of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



Problem Constraints
1 <= length of the Aay <= 100000
-109 <= A[i], B <= 109



Input Format
The first argument given is the integer Aay A.
The second argument given is the integer B.



Output Format
Return the minimum number of swaps.



Example Input
Input 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
Input 2:

 A = [5, 17, 100, 11]
 B = 20


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 Now, all elements less than or equal to 8 are together.
Explanation 2:

 A = [5, 17, 100, 11]
 After swapping 100 and 11, A => [5, 17, 11, 100].
 Now, all elements less than or equal to 20 are together.
 */
public class MinimumSwaps {

	public int solve(int[] A, int B) {
		//count the elements less than k
        int count =0;
        for(int x: A)
            if(x<=B)
                count++;

        //count the elements greater then k in first window of size=count
        int num_elem_greater_then_k=0;
        for(int i=0;i<count;i++)
            if(A[i]>B)
                num_elem_greater_then_k++;


        /*
            Now we have the sliding window size=count,
            As the idea is to have a window or subAay of size count ie all elements<=k together
            we can slide the window keep track of element going out from left and coming from right
         */
        int ans = num_elem_greater_then_k;
        for(int i=0,j=count;j<A.length;i++,j++){

            //if element going out was greater than k then in the window we decrement the count
            if(A[i]>B)
                num_elem_greater_then_k--;

            //if element coming in is greater than k then in the window we increment the count
            if(A[j]>B)
                num_elem_greater_then_k++;

            ans = Math.min(ans,num_elem_greater_then_k); //after covering all the window we can find out
        }
        return ans;
    }
	public static void main(String[] args) {
		int arr[] = {1, 12, 10, 3, 14, 10, 5};
        System.out.println(new MinimumSwaps().solve(arr,8));

	}

}
