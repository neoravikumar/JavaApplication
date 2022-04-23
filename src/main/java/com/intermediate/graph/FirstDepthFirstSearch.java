package com.intermediate.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 Problem Description

You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i.

NOTE: Array A is 0-indexed.



Problem Constraints

1 <= n <= 100000



Input Format

First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format

Return 1 if reachable, 0 otherwise.



Example Input

Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */
public class FirstDepthFirstSearch {

	public static void main(String[] args) {
        ArrayList<Integer> dataset = new ArrayList<>(Arrays.asList(1,1,2));
        FirstDepthFirstSearch pathInDirectedGraph = new FirstDepthFirstSearch();
        System.out.println(pathInDirectedGraph.solve(dataset,2,1));
    }

	public int solve(ArrayList<Integer> A, final int B, final int C) {
		int N = A.size();
        boolean[] visited = new boolean[N+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<A.size();i++){
            graph.get(A.get(i)).add(i+1);
        }
        
        
        dfs(graph,visited,C);
        return visited[B] ? 1 : 0;
    }

	public void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited, int current){
        ArrayList<Integer> neighbors = graph.get(current);
        visited[current] = true;
        for(int neighbor : neighbors){
            if(!visited[neighbor])  dfs(graph,visited,neighbor);
        }
    }

}
