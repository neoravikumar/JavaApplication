package com.intermediate.hashing;

import java.util.Arrays;

public class BoringSubstring {
	
	public static boolean checkConsecutive(String s) {
		boolean ok = true;
		for (int i = 0; i + 1 < s.length(); ++i)
	        ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
	    return ok;
	}

	public int solve(String A) {
		
		String odd = "", even = "";

		for (int i = 0; i < A.length(); ++i) {
			if (A.charAt(i) % 2 == 0)
				odd += A.charAt(i);
			else
				even += A.charAt(i);
		}

		// Sorting the two buckets
		char oddArray[] = odd.toCharArray();
		Arrays.sort(oddArray);
		odd = new String(oddArray);

		char evenArray[] = even.toCharArray();
		Arrays.sort(evenArray);
		even = new String(evenArray);

		if (checkConsecutive(odd + even))
			return 1;
		else if (checkConsecutive(even + odd))
			return 1;
		return 0;
		
	}

	public static void main(String[] args) {
		String str = "aab";
	    int ans = new BoringSubstring().solve(str);
	    System.out.println( ans);

	}

}
