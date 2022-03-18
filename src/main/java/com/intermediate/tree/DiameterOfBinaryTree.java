package com.intermediate.tree;



/**
 Diameter of binary tree
Problem Description

Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints
0 <= N <= 105



Input Format
First and only Argument represents the root of binary tree A.



Output Format
Return an single integer denoting the diameter of the tree.



Example Input
Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output
Output 1:

 3
Output 2:

 4


Example Explanation
Explanation 1:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */
public class DiameterOfBinaryTree {
	
	int diameter = 0;

	public int solve(TreeNode root) {
		findHeight(root);
		return diameter;
	}

	private int findHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int l = findHeight(root.left);
		int r = findHeight(root.right);
		diameter = Math.max(diameter, l + r + 2);
		return Math.max(l, r) + 1;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(6);
		//root.left.left.left = new TreeNode(8);

		DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
		int result = diameterOfBinaryTree.solve(root);
		System.out.println(result);
		
		//System.out.println(diameterOfBinaryTree.diameter);

	}

}
