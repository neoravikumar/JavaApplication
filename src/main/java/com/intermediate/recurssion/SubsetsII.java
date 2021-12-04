package com.intermediate.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Set<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();
		//A.clear();
		//A.addAll(set);
		Collections.sort(A);
		subsetsHelper(result, new ArrayList<>(), A, 0);
		
		HashSet<Integer> aa = new HashSet<Integer>();
		for(ArrayList<Integer> a : result) {
			System.out.println(">>"+a);
			aa.addAll(a);
			System.out.println("<<"+aa);
		}
		
		return result;
	}

 
    private void subsetsHelper(ArrayList<ArrayList<Integer>>  list , ArrayList<Integer> resultList, ArrayList<Integer> nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.size(); i++){
           // add element
            resultList.add(nums.get(i));
           // Explore
            subsetsHelper(list, resultList, nums, i + 1);
           // remove
            resultList.remove(resultList.size() - 1);
        }
    }

	public static void main(String[] args) {
		
		SubsetsII subset = new SubsetsII();
		 ArrayList<ArrayList<Integer>> result = subset.subsets(new ArrayList<Integer>(Arrays.asList(1,2,2)));
		 System.out.println(result);

	}

}
