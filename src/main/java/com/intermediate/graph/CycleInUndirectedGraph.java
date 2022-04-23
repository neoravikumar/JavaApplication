package com.intermediate.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 Cycle in Undirected Graph
 
 Problem Description

Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].



Output Format

Return 1 if cycle is present else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:

 A = 3
 B = [  [1. 2]
        [1, 3]
     ]


Example Output

Output 1:

 1
Output 2:

 0
 */
public class CycleInUndirectedGraph {

	public static void main(String[] args) {
		CycleInUndirectedGraph cycleInUndirectedGraph = new CycleInUndirectedGraph();
		ArrayList<ArrayList<Integer>>  B = new ArrayList<>();
		B.add(new ArrayList<>(Arrays.asList(1,2)));
		B.add(new ArrayList<>(Arrays.asList(1,3)));
		B.add(new ArrayList<>(Arrays.asList(2,3)));
		B.add(new ArrayList<>(Arrays.asList(1,4)));
		B.add(new ArrayList<>(Arrays.asList(4,5)));
		int result = cycleInUndirectedGraph.solve(5, B);
		System.out.println(result);

	}
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    for (ArrayList<Integer> connection : B) {
	      map.computeIfAbsent(connection.get(0), k -> new ArrayList<>()).add(connection.get(1));
	      map.computeIfAbsent(connection.get(1), k -> new ArrayList<>()).add(connection.get(0));
	    }
	    Map<Integer, Integer> state = new HashMap<>();
	    for (int i = 1; i <= A; i++) {
	      state.put(i, -1);
	    }
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i = 1; i <= A; i++) {
	      if (state.get(i) == -1) {
	        queue.add(i);
	        state.put(i, 0);
	        while (!queue.isEmpty()) {
	          int removed = queue.remove();
	          state.put(removed, 1);
	          for (Integer neighbor : map.getOrDefault(removed, new ArrayList<>())) {
	            if (state.get(neighbor) == -1) {
	              queue.add(neighbor);
	              state.put(neighbor, 0);
	            }
	            else if (state.get(neighbor) == 0) {
	              return 1;
	            }
	          }
	        }
	      }
	    }
	    return 0;
	  }

}
