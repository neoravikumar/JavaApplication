package com.intermediate.arrays;

import java.util.ArrayList;

/*
 Beggars Outside Temple
There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.

Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.

Example:

Input:
N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

Return: [10, 55, 45, 25, 25]

Explanation:
=> First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]

=> Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]

=> Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 */
public class BeggarsOutsideTemple {

	public ArrayList<Integer> solve(int N, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> beggerList = new ArrayList<Integer>();
		if (N > 0) {
			for (int i = 0; i < N; i++) {
				beggerList.add(0);
			}

			for (int i = 0; i < B.size(); i++) {

				int left = B.get(i).get(0) - 1;
				int right = B.get(i).get(1) - 1;
				int amount = B.get(i).get(2);

				
				if ((right + 1) < N) {
					int finalamount2 = beggerList.get(right + 1) - amount;
					beggerList.set(right + 1, finalamount2);
				}

				int finalamount = beggerList.get(left) + amount;
				beggerList.set(left, finalamount);
			}

			for (int i = 1; i < N; i++) {
				beggerList.set(i, beggerList.get(i - 1) + beggerList.get(i));
			}

		}
		return beggerList;
	}

	public static void main(String[] args) {

		BeggarsOutsideTemple beggarsOutsideTemple = new BeggarsOutsideTemple();

		
		  //A : 10 B : [ [1, 3, 10] [6, 9, 2] [3, 5, 3] [2, 8, 4] [6, 7, 5] ]
		  
		  
		/*
		 * int A = 10; ArrayList<Integer> devotee1 = new ArrayList<Integer>();
		 * devotee1.add(1); devotee1.add(3); devotee1.add(10);
		 * 
		 * ArrayList<Integer> devotee2 = new ArrayList<Integer>(); devotee2.add(6);
		 * devotee2.add(9); devotee2.add(2);
		 * 
		 * ArrayList<Integer> devotee3 = new ArrayList<Integer>(); devotee3.add(3);
		 * devotee3.add(5); devotee3.add(3);
		 * 
		 * ArrayList<Integer> devotee4 = new ArrayList<Integer>(); devotee4.add(2);
		 * devotee4.add(8); devotee4.add(4);
		 * 
		 * ArrayList<Integer> devotee5 = new ArrayList<Integer>(); devotee5.add(6);
		 * devotee5.add(7); devotee5.add(5); ArrayList<ArrayList<Integer>> devoteeList =
		 * new ArrayList<ArrayList<Integer>>(); devoteeList.add(devotee1);
		 * devoteeList.add(devotee2); devoteeList.add(devotee3);
		 * devoteeList.add(devotee4); devoteeList.add(devotee5);
		 */
		 
		
		
		  int A=5; ArrayList<Integer> devotee1 = new ArrayList<Integer>();
		  devotee1.add(1); devotee1.add(2); devotee1.add(10);
		  
		  ArrayList<Integer> devotee2 = new ArrayList<Integer>(); devotee2.add(2);
		  devotee2.add(3); devotee2.add(20);
		  
		  ArrayList<Integer> devotee3 = new ArrayList<Integer>(); devotee3.add(2);
		  devotee3.add(5); devotee3.add(25);
		  
		  
		  ArrayList<ArrayList<Integer>> devoteeList = new
		  ArrayList<ArrayList<Integer>>(); devoteeList.add(devotee1);
		  devoteeList.add(devotee2); devoteeList.add(devotee3);
		 

		ArrayList<Integer> result = beggarsOutsideTemple.solve(A, devoteeList);
		result.forEach(a -> System.out.println(a));

	}

}
