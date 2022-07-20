package com.practice;

import com.intermediate.arrays.AntiDiagonals;

import java.util.ArrayList;
import java.util.Arrays;

public class MultidimensionArraySample {

	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));

		ArrayList<ArrayList<Integer>> blist = new ArrayList<ArrayList<Integer>>();
		blist.add(a1);
		blist.add(a2);
		blist.add(a3);

		AntiDiagonals eq = new AntiDiagonals();
		ArrayList<ArrayList<Integer>> result = eq.diagonal(blist);
		System.out.println("Result:>>" + result);

	}

}
