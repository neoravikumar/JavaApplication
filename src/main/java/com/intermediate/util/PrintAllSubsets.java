package com.intermediate.util;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllSubsets {

	public void printAllSubsets(ArrayList<Integer> A) {
		byte[] counter = new byte[A.size()];

		StringBuilder sb = new StringBuilder();
		String temp = "";

		while (true) {
			// Print combination
			for (int i = 0; i < counter.length; i++) {
				if (counter[i] != 0)
					System.out.print(A.get(i) + " ");
				sb.append(A.get(i));
			}
			System.out.println();
			// Increment counter
			int i = 0;
			while (i < counter.length && counter[i] == 1)
				counter[i++] = 0;
			if (i == counter.length)
				break;
			counter[i] = 1;
		}
	}

	public static void main(String[] args) {
		PrintAllSubsets pubAllSubsets = new PrintAllSubsets();
		pubAllSubsets.printAllSubsets(new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9)));
	}

}
