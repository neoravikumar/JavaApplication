package com.intermediata.test;

import sun.nio.cs.Surrogate;

public class IsStringPalindrome {

    public boolean isStrPalindrome(String input){
        // base case
        if(input.length() == 0 || input.length()==1){
            return true;
        }
        if(input.charAt(0) == input.charAt(input.length()-1)){
            return isStrPalindrome(input.substring(1,input.length()-1));
        }
        return false;
    }

    public static void main(String[] args) {

        IsStringPalindrome isStrPalindrome = new IsStringPalindrome();
        boolean result = isStrPalindrome.isStrPalindrome("racecar");
        System.out.println(result);
    }
}
