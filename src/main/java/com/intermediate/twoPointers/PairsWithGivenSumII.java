package com.intermediate.twoPointers;

import java.util.*;

/*
 Pairs with given sum II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

 
A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.
 */
public class PairsWithGivenSumII {
	
	
	
	public int printPairsUsingSet(int[] numbers, int n){
	   
		Map<Integer, Integer> dataMap = new HashMap<>();
		
		int count = 0;
	    
	    for(Integer num : numbers) {
	    	if(dataMap.containsKey(num)) {
	    		dataMap.put(num, dataMap.get(num)+1);
	    	}else {
	    		dataMap.put(num, 1);
	    	}
	    }
	    
	    
		Set<Integer> set = new HashSet<>(numbers.length);

		for (int value : numbers) {
			int target = n - value;

			// if target number is not in set then add
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
				int noOfElement = dataMap.get(target);
				count += noOfElement * 1;
			}
		}
		    
	    return count;
	    
    }	
	
	
	public int printPairs(int[] A, int B) {
		int n = A.length;
		HashMap<Integer,Integer> map = new HashMap<>();
		long pairs=0;
        long MOD = (long) (Math.pow(10, 9)+7);
        for (int i=0; i<n; i++)
        {
            if (map.containsKey(B - A[i]))
            {
                pairs += map.get(B - A[i]);
            }
            map.put(A[i] , map.getOrDefault(A[i],0)+1);
        }
        return (int) (pairs % MOD);
	}

	public int solve(int[] A, int B) {

		int start = 0;
		int end = A.length - 1;
		int pairs_count = 0;
		while (start < end) {
			int temp_sum = A[start] + A[end];
			if (temp_sum > B) {
				end -= 1;
			} else if (temp_sum < B) {
				start += 1;
			} else {
				pairs_count += 1;
				start += 1;
				end -= 1;
			}
		}
		return pairs_count;

	}

	
	public static void printSumPairs(int []input, int k){
		int count =0;
	    Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

	    for(int i=0;i<input.length;i++){

	        if(pairs.containsKey(input[i])) {
	            System.out.println(input[i] +", "+ pairs.get(input[i])); 
	            count++;
	            System.out.println(count);
	        }else
	            pairs.put(k-input[i], input[i]);
	    }

	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,1};
		int k = 2;
		
		PairsWithGivenSumII pairsWithGivenSumII = new PairsWithGivenSumII();
		ArrayList<Integer> inputArrayList = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 6, 10));
		System.out.println("Count of pairs with given SUM is " + pairsWithGivenSumII.solve(arr, k));
		
		int result = pairsWithGivenSumII.printPairsUsingSet(arr, k);
		System.out.println("new method:>>"+result/2);
		
		System.out.println("// 3rd Approach");
		PairsWithGivenSumII.printSumPairs(arr, k);
		
		
		System.out.println("// Another Approach");
		int kResult = pairsWithGivenSumII.printPairs(arr, k);
		System.out.println(kResult);

	}

}
