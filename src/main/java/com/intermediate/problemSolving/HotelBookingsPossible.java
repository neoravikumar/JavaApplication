package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Hotel Bookings Possible
Problem Description

A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms.

Bookings contain an arrival date and a departure date.

He wants to find out whether there are enough rooms in the hotel to satisfy the demand.

Write a program that solves this problem in time O(N log N) .



Problem Constraints
1 <= N <= 106

1 <= K <= 106

0 <= arrive[i] <= depart[i] <= 108



Input Format
First argument is an integer array named arrive denoting the arrival times of bookings.

Second argument is an integer array named depart denoting the departure times of bookings.

Third argument is an integer K which denotes count of rooms.



Output Format
A boolean which tells whether its possible to make a booking.

Return 0/1 for C programs.

O -> No there are not enough rooms for N booking.

1 -> Yes there are enough rooms for N booking.



Example Input
Input 1:

 arrive = [1, 3, 5]
 depart = [2, 6, 8]
 K = 1


Example Output
Output 1:

 False / 0 


Example Explanation
Explanation 1:

 At day = 5, there are 2 guests in the hotel. But hotel has only one room so it is not possible to take the booking
 so we will return false or 0 for C Program.*/
public class HotelBookingsPossible {

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		
		
			/*Solution approach :

			1. Create event points for every interval start, and end.

			2. Sort it according to the day.

			3. Now, iterate over them one by one. If you encounter a start, then the number of active guests increase by one. 
			If you encounter an end, the number of active guests decrease by one.

			4. If at any point, the number of active guests exceed K, we know that scheduling is not possible.

			GOTCHAS : What if there are multiple start and end on the same day ? How should they be ordered ?
			
			
			if (AA < DD) {
				count++;
				i++;
				if (count > K) {
					result = false;
				}
			} else if (AA == DD) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			ans = (int) Math.max(ans, count);
			if (ans > K) {
				result = false;
			}
			
			
			*/

		int N = arrive.size();
		int M = depart.size();

		Collections.sort(arrive);
		Collections.sort(depart);

		int count = 0;
		boolean result = true;

		int i = 0, j = 0;
		int ans = 0;
		
		if (N >= 1 && N <= Math.pow(10, 6)) {
			if (K >= 1 && K <= Math.pow(10, 6)) {
				
				
				while (i < N && j < N) {
					System.out.println("inside while:"+i);
					int AA = arrive.get(i);
					int DD = depart.get(j);
					if (AA >= 0 && AA <= Math.pow(10, 8)) {
						if (AA < DD) {
							count++;
							i++;
							if (count > K) {
								return false;
							}
						} else if (AA == DD) {
							count++;
							i++;
						} else {
							count--;
							j++;
						}
						ans = Math.max(ans, count);
						if (ans > K) {
							return false;
						}
					}
				}
				

			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		HotelBookingsPossible hotelBookingsPossible = new HotelBookingsPossible();
		// boolean result = hotelBookingsPossible.hotel(new ArrayList(Arrays.asList( 11,
		// 24, 36, 15, 16, 23, 20, 19)), new ArrayList(Arrays.asList(14, 32, 67, 25, 21,
		// 54, 61, 34)), 4);
		boolean result = hotelBookingsPossible.hotel(new ArrayList(Arrays.asList(47, 4, 0, 12, 47, 31, 15, 49, 29, 33, 7, 22, 26, 24, 16)),
				new ArrayList(Arrays.asList(95, 4, 26, 16, 51, 79, 43, 58, 32, 80, 30, 27, 29, 54, 16)), 10);
		// boolean result = hotelBookingsPossible.hotel(new ArrayList(Arrays.asList(
		// 1,2,3)), new ArrayList(Arrays.asList(2,3,4)), 1);
		System.out.println(result);

	}

}
