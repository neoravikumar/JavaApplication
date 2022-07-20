package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSetofArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(5);
		input.add(2);
		
		int sum=0;
		Long MOD = new Long((long) (Math.pow(10, 9) + 7));
		
		for(int i = 0; i < Math.pow(2,input.size()); i++){
            List<Integer> toAdd = generateList(i,input);
           if(null != toAdd && toAdd.size()>0) {
        	   sum += sumOfArray(toAdd);
           }
        }
		
		
	}

	private static List<Integer> generateList(int n, ArrayList<Integer> input) {
		
		 int index =0;
	        List<Integer> list = new ArrayList<Integer>();
	        while(n!=0){
	            if((n & 1) == 1){
	                list.add(input.get(index));
	            }
	            index++;
	            n >>= 1;
	        }
	        return list;
	}
	
	private static int sumOfArray(List<Integer> list) {
		int tSum = 0;
		int N = list.size();
		Collections.sort(list);
		if (N == 1) {
			tSum = list.get(0) - list.get(0);
			return tSum;
		} else {
			tSum = list.get(N - 1) - list.get(0);
		}
		return tSum;
	}

}
