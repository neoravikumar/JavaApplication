package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
 Merge Intervals
Problem Description

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */

class Interval implements Comparable<Interval>{
	Integer start;
	Integer end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
	
	@Override
	public int compareTo(Interval o) {
		return this.getStart().compareTo(o.getStart());
	}
	
}

public class MergeIntervals {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		intervals.add(newInterval);
		Collections.sort(intervals);
        ArrayList<Interval>res=new ArrayList<Interval>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<=end)
            {
                end=Math.max(intervals.get(i).end,end);
            }
            else
            {
                res.add(new Interval(start,end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
        }
        res.add(new Interval(start,end));
        
        return res;
	}

	public static void main(String[] args) {
		MergeIntervals mergeIntervals = new MergeIntervals();
		Interval newInterval = new Interval(2,5);

		ArrayList<Interval> intervals = new ArrayList<Interval>();
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(6,9);
		intervals.add(i1);
		intervals.add(i2);

		ArrayList<Interval> result = mergeIntervals.insert(intervals, newInterval);
		System.out.println(result);

	}

}
