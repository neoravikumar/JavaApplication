package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 Subsets II
Problem Description

Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.


Problem Constraints
0 <= N <= 16



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D vector denoting all the possible subsets.



Example Input
Input 1:

 A = [1, 2, 2]
Input 2:

 A = [1, 1]


Example Output
Output 1:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:

 [
    [],
    [1],
    [1, 1]
 ]


Example Explanation
Explanation 1:

All the subsets of the array [1, 2, 2] in lexicographically sorted order.
 */
public class SubsetsII {

	/*
	 * public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
	 * 
	 * Collections.sort(A); ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	 * LinkedList<Integer> output = new LinkedList(); int n = A.size(); for (int i =
	 * 0; i <= n; ++i) { backtrack(ans, output, A, n, i, 0); } return ans; }
	 * 
	 * 
	 * public void backtrack(ArrayList<ArrayList<Integer>> ans, LinkedList<Integer>
	 * output, ArrayList<Integer> nums, int n, int k, int start) { if (output.size()
	 * == k) { ans.add(new ArrayList(output)); return; } for (int i = start; i < n;
	 * ++i) { if (i > start && nums.get(i) == nums.get(i-1)) continue;
	 * output.add(nums.get(i)); backtrack(ans, output, nums, n, k, i + 1);
	 * output.removeLast(); } }
	 */
	
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    Collections.sort(A);
	    solve(A, new ArrayList<>(), ans, 0);
	    return ans;
	  }

	  private void solve(ArrayList<Integer> a, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int idx) {
	    ans.add(new ArrayList<>(curr));
	    if (idx >= a.size()) {
	      return;
	    }
	    for (int i = idx; i < a.size(); i++) {
	      if (i > idx && a.get(i).equals(a.get(i - 1))) {
	        continue;
	      }
	      curr.add(a.get(i));
	      solve(a, curr, ans, i + 1);
	      curr.remove(curr.size() - 1);
	    }
	  }
	


	
	public static void main(String[] args) {
		
		SubsetsII subset = new SubsetsII();
		 ArrayList<ArrayList<Integer>> result = subset.subsets(new ArrayList<Integer>(Arrays.asList(5, 4)));
		 System.out.println(result);
		 //[] [4 ] [4 5 ] [5 ] 

	}

}
