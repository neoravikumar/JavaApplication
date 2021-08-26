package com.intermediate.bitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XorArraySubArrays {

	public int solve(ArrayList<Integer> A) {
		
		int res = 0;
		if(null != A && (A.size() >=1 && A.size()<=Math.pow(10, 5)) ) {
			int N = A.size();
			for (int i = 0; i < N; i++) {
				int value = A.get(i);
				if(value>=1 && value <=Math.pow(10, 8)) {
					int freq = (i + 1) * (N - i);
					if (freq % 2 == 1)
						res = res ^ value;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		
		
		List<Integer> lst = Arrays.asList(3, 5, 2, 4, 6);
		//List<Integer> lst = Arrays.asList(4, 5, 7, 5);
		//List<Integer> lst = Arrays.asList(4, 5, 7, 5);
		
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);
		
		XorArraySubArrays xorArraySubArrays = new XorArraySubArrays();
		
		System.out.println(xorArraySubArrays.solve(abc));

	}

}
