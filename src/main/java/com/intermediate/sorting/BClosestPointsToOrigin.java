package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 B Closest Points to Origin
Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */
public class BClosestPointsToOrigin {
	
	class KeyValue implements Comparator<KeyValue>{
		Integer key;
		Integer value;
		
		@Override
		public int compare(KeyValue o1, KeyValue o2) {
			return o1.key.compareTo(o2.key);
		}

		public KeyValue(Integer key, Integer value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		} 
	}

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		List<KeyValue> keyList = new ArrayList<KeyValue>();
		int index = 0;
		for (ArrayList<Integer> a : A) {
			Integer first = a.get(0);
			Integer last = a.get(1);
			
			long operation = first*first + last*last;
			//Long operation = new Double(Math.sqrt(Math.pow(first, 2) + Math.pow(last, 2))).longValue();
			KeyValue kb = new KeyValue(new Long(operation).intValue(), index);
			keyList.add(kb);
			index++;
		}
		
		Comparator<KeyValue> cm1=Comparator.comparing(KeyValue::getKey);  
		Collections.sort(keyList,cm1);  

		for (int i = 0; i < B; i++) {
			result.add(A.get(keyList.get(i).getValue()));
		}

		return result;
	}

	public static void main(String[] args) {
		BClosestPointsToOrigin bClosestPointsToOrigin = new BClosestPointsToOrigin();

		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(40, 35));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(31, 40));
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(20, 14));
		ArrayList<Integer> a4 = new ArrayList<Integer>(Arrays.asList(50, 45));
		ArrayList<Integer> a5 = new ArrayList<Integer>(Arrays.asList(48, 28));
		ArrayList<Integer> a6 = new ArrayList<Integer>(Arrays.asList(17, 44));
		ArrayList<Integer> a7 = new ArrayList<Integer>(Arrays.asList(19, 2));
		ArrayList<Integer> a8 = new ArrayList<Integer>(Arrays.asList(34, 41));
		ArrayList<Integer> a9 = new ArrayList<Integer>(Arrays.asList(44, 47));
		ArrayList<Integer> a10 = new ArrayList<Integer>(Arrays.asList(25, 14));
		ArrayList<Integer> a11 = new ArrayList<Integer>(Arrays.asList(44, 7));

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(a1);
		input.add(a2);
		input.add(a3);
		input.add(a4);
		input.add(a5);
		input.add(a6);
		input.add(a7);
		input.add(a8);
		input.add(a9);
		input.add(a10);
		input.add(a11);

		ArrayList<ArrayList<Integer>> result = bClosestPointsToOrigin.solve(input, 11);
		System.out.println(result);

	}

}
