package com.intermediate.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
Problem Description
Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

NOTE: The value comes first in the array which have lower level.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format
First and only argument is a root node of the binary tree, A.



Output Format
Return an integer array denoting the left view of the Binary tree.



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

 [1, 2, 4, 8]
Output 2:

 [1, 2, 4, 5]


Example Explanation
Explanation 1:

 The Left view of the binary tree is returned.
 */
public class LeftViewofBinarytree {
	
	public ArrayList<Integer> solve(TreeNode A) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(A == null) {
			return result;
		}
		q.add(A);
		
		while (!q.isEmpty()) {
			int nodeCount = q.size();
			// Traverse all nodes of current level
			for (int i = 1; i <= nodeCount; i++) {
				TreeNode temp = q.poll();
				if (i == 1) {
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

		ArrayList<Integer> result = new LeftViewofBinarytree().solve(root);
		System.out.println(result);
	}

}
