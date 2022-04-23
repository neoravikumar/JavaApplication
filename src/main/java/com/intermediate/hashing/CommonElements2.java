package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*Common Elements
Problem Description

Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.*/
public class CommonElements2 {

	
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		Map<Integer, Integer> inputMap = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(Integer a : B) {
			if(inputMap.containsKey(a)) {
				inputMap.put(a, inputMap.get(a)+1);
			}else
			{
				inputMap.put(a, 1);
			}
		}
		
		for(Integer a: A) {
			if(inputMap.containsKey(a) && inputMap.get(a)>0) {
				result.add(a);
				inputMap.put(a, inputMap.get(a)-1);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		CommonElements2 firstRepatingElement = new CommonElements2();

		List<Integer> lst = Arrays.asList(2, 1, 4, 10);
		// List<Integer> lst = Arrays.asList(2, 1, 4, 10);
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		List<Integer> lst2 = Arrays.asList(3, 6, 2, 10, 10);
		// List<Integer> lst2 = Arrays.asList(3, 6, 2, 10, 10);
		ArrayList<Integer> abc2 = new ArrayList<Integer>();
		abc2.addAll(lst2);

		// ArrayList<Integer> result = firstRepatingElement.solve(abc, abc2);

		// result.forEach(a -> System.out.print(a + " "));

		ArrayList<Integer> result = firstRepatingElement.solve(abc, abc2);
		System.out.println(result);
		result.forEach(a -> System.out.print(a + " "));

	}

}
