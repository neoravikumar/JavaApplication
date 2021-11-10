package com.intermediate.bitWise;

/*
 Divide Integers
Problem Description

Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1



Problem Constraints
-231 <= A, B <= 231-1

B!= 0



Input Format
First argument is an integer A denoting the dividend.
Second argument is an integer B denoting the divisor.



Output Format
Return an integer denoting the floor value of the division.



Example Input
Input 1:

 A = 5
 B = 2
Input 2:

 A = 7
 B = 1


Example Output
Output 1:

 2
Output 2:

 7


Example Explanation
Explanation 1:

 floor(5/2) = 2
 */
public class DivideIntegers {
	
	public int divide(int dividend, int divisor) {
		 //if the outpur is greater then 2^31-1;     
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        boolean sign = (dividend>=0)==(divisor>=0)?true:false;
        
        // converting to positive integer
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        int temp = 0;
        int prev = 0;
        //checking id dividend is smaller then divisor
        //we can divide 10 by 3 but not 1 by 3
        while(dividend-divisor>=0){
            int count = 0;
            temp = divisor;
            prev =0;
            // checking not for every multiple of divsor but 2^count multiple of divisor
            while(dividend-temp>=0){
                prev = temp;
                temp = temp<<1;
                count++;
            }
            result+=1<<count-1;
            dividend -=prev;
        }
        return sign?result:-result;
    }
   

	public static void main(String[] args) {
		System.out.println(new DivideIntegers().divide(5, 2));

	}

}
