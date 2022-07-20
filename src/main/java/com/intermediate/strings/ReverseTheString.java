package com.intermediate.strings;

/**
 * Reverse the String as below 
 * "ab123cd output will be dc123ba" 
 * "123abcd output will be 123dcba" 
 * "123abcd33 output will be 123dcba33".
 */
public class ReverseTheString {
	
	 public String reverseOnlyLetters(String S) {
	        StringBuilder ans = new StringBuilder();
	        int j = S.length() - 1;
	        for (int i = 0; i < S.length(); ++i) {
	            if (Character.isLetter(S.charAt(i))) {
	                while (!Character.isLetter(S.charAt(j)))
	                    j--;
	                ans.append(S.charAt(j--));
	            } else {
	                ans.append(S.charAt(i));
	            }
	        }
	        return ans.toString();
	 }
	        

	public String reverseString(String input) {
		String result = "";
		input = input.toLowerCase();
		
		StringBuffer myString = new StringBuffer();
		
		for(int k=0;k<input.length()-1;k++) {
			if(Character.isDigit(input.charAt(k)) && Character.isAlphabetic(input.charAt(k+1))) {
				myString.append(input.charAt(k));
				result +=myString.toString();
				myString = new StringBuffer();
			}else if (Character.isAlphabetic(input.charAt(k)) && Character.isDigit(input.charAt(k+1))) {
				myString.append(input.charAt(k));
				result += myString.reverse().toString();
				myString = new StringBuffer();
			}else {
				if(Character.isDigit(input.charAt(k))) {
					myString.append(input.charAt(k));
				}
				else {
					myString.append(input.charAt(k));
				}
			}
			
			if(k+2 == input.length()) {
				if(Character.isDigit(input.charAt(k))) {
					myString.append(input.charAt(k+1));
					result +=myString.toString();
					myString = new StringBuffer();
				}
				else {
					myString.append(input.charAt(k+1));
					result += myString.reverse().toString();
					myString = new StringBuffer();
				}
			}
			
		}
		return result;
	}

	public static void main(String args[]) {
		ReverseTheString reverseTheString = new ReverseTheString();
		String result = reverseTheString.reverseString("ab123cd");
		
		/*
		 * "ab123cd output will be dc123ba" 
		 * "123abcd output will be 123dcba"
		 * "123abcd33 output will be 123dcba33".
		 */
		
		//String result = reverseTheString.reverseString("123dcba33");
		System.out.println(result);
		
		String result2 = reverseTheString.reverseOnlyLetters("ab123cd");
		System.out.println(result);

	}

}
