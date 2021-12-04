package com.intermediata.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test3 {


	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(2,2, 3, 6, 7));
		new Test3().subsetsWithDupSum(input, 7);

	}

	public ArrayList<ArrayList<Integer>> subsetsWithDupSum(ArrayList<Integer> input, int target) {
		Collections.sort(input);
		ArrayList<ArrayList<Integer>> result = helper(input, 0, new ArrayList<>(), target);
		System.out.println(result);
		
		return result;
	}
	
	
	
	private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> candidates, int start, ArrayList<Integer> list, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
		if(target == 0) {
			result.add(new ArrayList<>(list));
            return result;
        }
        if(start == candidates.size()) {
            return result;
        }
        for(int i = start; i < candidates.size(); i++) {
        	
            if(i > start && candidates.get(i) == candidates.get(i-1)) {
                continue;
            }
            if(candidates.get(i) > target) {
                break;
            }
            list.add(candidates.get(i));
            result.addAll(helper(candidates, i + 1, list, target - candidates.get(i)));
            list.remove(list.size() - 1);
        }
        return result;
    }
	
}
