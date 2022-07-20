package com.practice.prefixArray;

import java.util.Arrays;

public class PrefixSumExample {

    public static int[] runningSum(int[] nums) {

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int a=1;a<nums.length;a++){
            result[a] = result[a-1] + nums[a];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(input)));

    }
}
