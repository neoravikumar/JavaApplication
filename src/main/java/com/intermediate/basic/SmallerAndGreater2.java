package com.intermediate.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallerAndGreater2 {
	
	public int solve(ArrayList<Integer> A) {
		int count = 0;
		if (null != A && (A.size() >= 1 && A.size() <= Math.pow(10, 5))) {
			int min = (Integer) A.get(0);
			int max = (Integer) A.get(0);
			for (int k = 0; k < A.size(); k++) {
				int value = (Integer) A.get(k);
				min = min < value ? min : value;
				max = max > value ? max : value;
			}

			for (int k = 0; k < A.size(); k++) {
				int value = (Integer) A.get(k);
				if (value > min && value < max) {
					count++;
				}
			}
		}
		return count;
	}
	
	private int minMaxCount(ArrayList<Integer> A, int count, int value) {
		if (value >= 1 && value < Math.pow(10, 6)) {
			int upper = value;
			int smaller = value;
			boolean upflag = false;
			boolean downFlag = false;

			for (int j = 0; j < A.size(); j++) {
				int newValue = (Integer) A.get(j);

				if (newValue > upper) {
					upflag = true;
				    continue;
				}
				else if (newValue < smaller) {
					downFlag = true;
					continue;
				}
			}

			if (upflag && downFlag) {
				++count;
			}

		}
		return count;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		SmallerAndGreater2 smallerAndGreater2 = new SmallerAndGreater2();
		
		List<Integer> lst = Arrays.asList(913, 440, 865, 72, 612, 445, 101, 994, 356, 91, 461, 930, 583, 448, 543, 170, 333, 107, 425, 73, 172, 416, 899, 826, 659, 561, 314, 25, 110 );
		//List<Integer> lst = Arrays.asList(1,2,3 );
		
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);
		
		
		System.out.println(smallerAndGreater2.solve(abc));
		
		
	}
	

}
