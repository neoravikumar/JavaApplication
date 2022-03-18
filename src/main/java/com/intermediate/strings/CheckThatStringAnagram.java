package com.intermediate.strings;

import java.util.Arrays;

public class CheckThatStringAnagram {
	
	
	// Approach A
	public boolean checkAnagaram(String a, String b) {
		
		if((a !=null && b !=null) ) {
			
			if(a.length() != b.length()) {
				return false;
			}
			
			char[] chara = a.toCharArray();
			char[] charb = b.toCharArray();
			
			Arrays.sort(chara);
			Arrays.sort(charb);
			
			for(int i=0;i<chara.length;i++) {
				if(chara[i] != charb[i]) {
					return false;
				}
			}
			
		}else {
			return false;
		}
		return true;
	}
	
	// Approach B using HashMap TC = N;
	
public boolean checkAnagaramii(String a, String b) {
		
		if((a !=null && b !=null) ) {
			
			if(a.length() != b.length()) {
				return false;
			}
			
			char[] chara = a.toCharArray();
			char[] charb = b.toCharArray();
			
			Arrays.sort(chara);
			Arrays.sort(charb);
			
			for(int i=0;i<chara.length;i++) {
				if(chara[i] != charb[i]) {
					return false;
				}
			}
			
		}else {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckThatStringAnagram checkThatString = new CheckThatStringAnagram();
		boolean result = checkThatString.checkAnagaram("listen", "sislent");
		System.out.println(result);
	}

}
