package com.intermediate.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 Right View of Binary tree
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



Example Input
Input 1:

 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:

 
            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.
 */
public class RightViewofBinarytree {
	
	public ArrayList<Integer> solve(TreeNode A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (A == null) {
			return result;
		}
		q.add(A);

		while (!q.isEmpty()) {
			int nodeCount = q.size();
			// Traverse all nodes of current level
			for (int i = 1; i <= nodeCount; i++) {
				TreeNode temp = q.poll();
				if (i == nodeCount) {
					System.out.print(temp.val + " ");
					result.add(temp.val);
				}
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		ArrayList<Integer> result = new RightViewofBinarytree().solve(root);
		System.out.println(result);

	}

}
