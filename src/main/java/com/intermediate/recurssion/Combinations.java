package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 Combinations
Problem Description

Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A .

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.



Problem Constraints
1 <= A, B <= 10



Input Format
First argument is an integer A.
Second argument is an integer B.



Output Format
Return a 2-D vector denoting all possible combinations.



Example Input
Input 1:

 A = 4
 B = 2
Input 2:

 A = 3
 B = 2


Example Output
Output 1:

 [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 3],
  [2, 4],
  [3, 4],
 ]
Output 2:

 [
  [1, 2],
  [1, 3],
  [2, 3]
 ] 


Example Explanation
Explanation 1:

All the possible combinations of size 2 in sorted order.

 */
public class Combinations {
	
	public static void main(String[] args) {
		
		Combinations combinations = new Combinations();
		ArrayList<ArrayList<Integer>> result = combinations.combine(3,2);
		System.out.println(result);

	}
	
	ArrayList<ArrayList<Integer>> result;
	
	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        generate(1,A,ans,new ArrayList<>(),B);
        return ans;
    }

	
	void generate(int start,int n,ArrayList<ArrayList<Integer>> ans,List<Integer> curr,int k){
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=n;i++){
            curr.add(i);
            generate(i+1,n,ans,curr,k);
            curr.remove(curr.size()-1);
        }
        
    }
	
	private void helper(int n, int k, ArrayList curr) {
		 if(k == 0){
	            result.add(new ArrayList<>(curr));
	            return;
	        }
	        if(n == 0) return;
	        curr.add(n);
	        helper(n - 1, k - 1, curr);
	        curr.remove(curr.size() - 1);
	        helper(n - 1, k, curr);
		
	}

	

}
