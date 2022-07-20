package com.intermediate.tree;

import java.util.*;

/**
 Vertical Order traversal
 
 Vertical Order traversal
Problem Description

Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
 */
public class VerticalOrdertraversal {
	
	class Pair {
		int hd;
		TreeNode node;

		Pair(int hd, TreeNode node) {
			this.hd = hd;
			this.node = node;
		}
	}

	public int[][] verticalOrderTraversal(TreeNode A) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		int hd = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		Pair temp = new Pair(hd, A);
		q.add(temp);
		while (true) {
			int qcount = q.size();
			if (qcount == 0)
				break;
			while (qcount > 0) {
				temp = q.poll();
				ArrayList list = map.get(temp.hd);
				if (list == null) {
					list = new ArrayList<Integer>();
					list.add(temp.node.val);
				} else {
					list.add(temp.node.val);
				}
				map.put(temp.hd, list);
				if (temp.node.left != null) {
					Pair leftpair = new Pair(temp.hd - 1, temp.node.left);
					q.add(leftpair);
				}
				if (temp.node.right != null) {
					Pair rightpair = new Pair(temp.hd + 1, temp.node.right);
					q.add(rightpair);
				}
				qcount--;
			}
		}
		int ans[][] = new int[map.size()][];
		int index = 0;
		for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
			ArrayList list = e.getValue();
			// System.out.println(list);
			int[] t = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				t[i] = (int) (list.get(i));
			}
			ans[index++] = t;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
