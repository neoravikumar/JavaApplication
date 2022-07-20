package com.intermediate.hashing;

import java.util.*;

/*Hotel Occurrences
Problem Description

You are given an array A, consisting of the street numbers of hotels your friend has visited. Every street has just one hotel. Your friend can visit a hotel multiple times too.

You are supposed to make another array, that stores the indices of the hotels your friend has visited. The array should ignore the multiple visits to each hotel, and should only consider the last visit made to that hotel.

The array elements should be in order of visiting the hotels.



Problem Constraints
1 <= size(A) <= 50
1 <= Integer in A <= 1000



Input Format
First argument is an integer array A denoting the indices of the hotel he has visited.



Output Format
Return an integer array consisting of the hotels visited.



Example Input
Input 1:

 A = [1, 2, 3, 2, 5, 3, 2, 4]
Input 2:

 A = [1, 2, 3, 4]


Example Output
Output 1:

 [1, 5, 3, 2, 4]
Output 2:

 [1, 2, 3, 4]


Example Explanation
Explanation 1:

 We are supposed to take the last visit of the hotels. So, the output array is [1, 5, 3, 2, 4]
Explanation 2:

 Each hotel is visited once. So the output is same as input.*/
public class HotelOccurrences {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {

		HashSet<Integer> hotelList = new HashSet<Integer>();
		hotelList.addAll(A);
		
		ArrayList<Integer> myList = new ArrayList<Integer>();

		for (int k = A.size() - 1; k >= 0; k--) {
			if(hotelList.contains(A.get(k))) {
				if(!myList.contains(A.get(k))) {
					myList.add(A.get(k));
				}
			}
		}
		Collections.reverse(myList);
		return myList;
	}

	public static void main(String[] args) {
		HotelOccurrences hotelOccurrences = new HotelOccurrences();

		List<Integer> lst = Arrays.asList(1, 2, 3, 2, 5, 3, 2, 4);
		// List<Integer> lst = Arrays.asList(-4, -2, 0, -1, -6 );

		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		System.out.println(hotelOccurrences.solve(abc));

	}

}
