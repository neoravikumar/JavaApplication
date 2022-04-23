package com.intermediate.leetcode;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
	    int xor = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	      xor ^= nums[i];
	    }
	    return xor;
	  }

	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();
		int[] input = {7,8,9,11,8,9,7};
		int result = singleNumber.singleNumber(input);
		System.out.println(result);

	}

}
