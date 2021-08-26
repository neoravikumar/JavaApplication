package com.intermediate.basic;

/*Vowel it
Raman is very fond of vowels. One day, he got a string as a gift for his birthday. He got very excited and wanted to obtain the longest subsequence of vowels from the original string. You are asked to help Raman.

Given a string A of lowercase English alphabets, find and return a string which is the longest subsequence of vowels in the string A.

Note:

1. Vowels are 'a' , 'e' ,'i' , 'o' , 'u'. 
2. A subsequence is a sequence that can be derived from another sequence by deleting some or no elements from the original sequence without changing the order of the remaining elements.
3. It is guaranteed that atleast one vowel will be present in the given string.

Input Format

The only argument given is string A.
Output Format

Return a string which is the longest subsequence of vowels in the string A.
Constraints

1 <= length of the string <= 100000
For Example

Input 1:
   abcdye
Output 1:
    ae

Input 2:
    abhishek
Output 2:
    aie

Input 3:
    interviewbit
Output 3:
    ieiei*/

public class VowelIt {
	
	public String solve(String A) {
		
		char[] vowelList = {'a','e','i','o','u'};
		
		String lower = A.toLowerCase();
		char[] list = lower.toCharArray();
		String resultString = "";
		
		for(int i=0;i<list.length;i++) {
			
			char vowel = list[i];
			
			for(int j=0;j<vowelList.length;j++) {
				if(vowel == vowelList[j]) {
					resultString += vowelList[j];
					break;
				}
			}
		}
		return resultString;
    }
	
	public static void main(String[] args) {
		VowelIt vowelIt = new VowelIt();
		System.out.println(vowelIt.solve("abhishek"));
		System.out.println(vowelIt.solve("aednvdldkktzfmrhzqsdsbnjijmbodzteivq"));
	}

}
