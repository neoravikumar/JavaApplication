package com.intermediate.recurssion;

import java.util.Scanner;

/*
 Print reverse string
Problem Description

Write a recursive function that, given a string S, prints the characters of S in reverse order.



Problem Constraints
1 <= |s| <= 1000



Input Format
First line of input contains a string S.



Output Format
Print the character of the string S in reverse order.



Example Input
Input 1:

 scaleracademy
Input 2:

 cool


Example Output
Output 1:

 ymedacarelacs
Output 2:

 looc


Example Explanation
Explanation 1:

 Print the reverse of the string in a single line.
 */
public class PrintReverseString {
	
	public void reverse(String input, int index, char[] resultArray){
		if(index == input.length()){
			resultArray[index-1] = input.charAt(input.length()-index);
            return; 
        }
        resultArray[index-1] = input.charAt(input.length()-index);
        index = index + 1;
        reverse(input, index, resultArray);
    }
	
	
    public String solve(String A) {
    	char[] resultArray= new char[A.length()];
    	reverse(A, 1, resultArray);
        return new String(resultArray);
    }
    
    public static void reverse(char str[], int k)
    {
        // base case: end of the string is reached
        if (k == str.length) {
            return;
        }
 
        // recur for the next character
        reverse(str, k + 1);
 
        // print current character
        System.out.print(str[k]);
    }

	public static void main(String[] args) {
		/*
		 * PrintReverseString printString = new PrintReverseString(); 
		 * String result = printString.solve("COOL"); 
		 * System.out.println(result) ; 
		 */
		
		  Scanner sc= new Scanner(System.in); String input= sc.nextLine(); 
		  char str[] = input.toCharArray(); reverse(str, 0);
		 

	}

}
