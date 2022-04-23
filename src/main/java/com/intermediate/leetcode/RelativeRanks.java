package com.intermediate.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

 

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

 

Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.
 */

public class RelativeRanks {
	
	public String[] findRelativeRanksII(int[] score) {
		int n = score.length;

		Map<Integer, Integer> playerScore = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			playerScore.put(score[i], i);
		}
		String[] rankList = new String[n];
		Arrays.sort(score);
		
		rankList[playerScore.get(score[n - 1])] = "Gold Medal";
		if (n > 1)
			rankList[playerScore.get(score[n - 2])] = "Silver Medal";
		if (n > 2)
			rankList[playerScore.get(score[n - 3])] = "Bronze Medal";
		for (int i = n - 4, j = 4; i >= 0; i--)
			rankList[playerScore.get(score[i])] = String.valueOf(j++);
		return rankList;
	}
	
	 public String[] findRelativeRanks(int[] nums) {
		    PriorityQueue<Integer> orderedRanking = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
		    orderedRanking.addAll(IntStream.range(0, nums.length).boxed().collect(Collectors.toList()));
		    String[] relativeRanks = new String[nums.length];
		    int currentRank = 1;
		    while (!orderedRanking.isEmpty()) {
		      int removed = orderedRanking.poll();
		      if (currentRank > 3) {
		        relativeRanks[removed] = String.valueOf(currentRank++);
		      } else {
		        relativeRanks[removed] = (
		            currentRank == 1 ? "Gold Medal" : (currentRank == 2 ? "Silver Medal" : "Bronze Medal")
		        );
		        currentRank++;
		      }
		    }
		    return relativeRanks;
		  }
	 
	 public static void main(String[] args) {
		 RelativeRanks relativeRanks = new RelativeRanks();
		 int[] inputArray = {10,3,8,9,4}; 
		 String[] result = relativeRanks.findRelativeRanksII(inputArray);
		 System.out.println(Arrays.asList(result));
	}

}
