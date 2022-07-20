package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/*
 Merge Overlapping Intervals
Problem Description

Given a collection of intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.



Input Format
First argument is a list of intervals.



Output Format
Return the sorted list of intervals after merging all the overlapping intervals.



Example Input
Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output
Output 1:

[1,6],[8,10],[15,18]


Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
 */

class Interval2 {
	int start;
	int end;

	Interval2() {
		start = 0;
		end = 0;
	}

	Interval2(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
    public String toString() {
        return "{" + start + ", " + end + "}";
    }
}

public class MergeOverlappingIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		ArrayList<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

		// create an empty stack
		Stack<Interval> stack = new Stack<>();

		for (Interval curr : intervals) {
			if (stack.empty() || curr.start > stack.peek().end) {
				stack.push(curr);
			}
			if (stack.peek().end < curr.end) {
				stack.peek().end = curr.end;
			}
		}
		while (!stack.empty()) {
			result.add(stack.pop());
		}

		Collections.sort(result, Comparator.comparingInt(a -> a.start));
		return result;

	}

	public static void main(String[] args) {

		ArrayList<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(2, 6));
		input.add(new Interval(8, 10));
		input.add(new Interval(15, 18));
		
		MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
		ArrayList<Interval> result = mergeOverlappingIntervals.merge(input);
		
		if(result.size()>0) {
			for(Interval a : result) {
				System.out.println(a.toString());
			}
		}

	}

}
