package com.intermediate.tree;

/*
 Problem Description

You are given the root node of a binary tree A. You have to find the sum of node values of this tree.



Problem Constraints

1 <= Number of nodes in the tree <= 105

0 <= Value of each node <= 104



Input Format

First and only argument is a tree node A.



Output Format

Return an integer denoting the sum of node values of the tree.



Example Input

Input 1:

 Values =  1 
          / \     
         4   3                        
Input 2:

 
 Values =  1      
          / \     
         8   3                       
        /         
       2                                     


Example Output

Output 1:

 8 
Output 2:

 14 


Example Explanation

Explanation 1:

Clearly, 1 + 4 + 3 = 8.
Explanation 2:

Clearly, 1 + 8 + 3 + 2 = 14.
 */

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class NodesSum {

	public int solve(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return root.val;

		return root.val + solve(root.left) + solve(root.right);
	}

	static TreeNode newNode(int key) {
		TreeNode node = new TreeNode(key);
		node.val = key;
		node.left = node.right = null;
		return (node);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = newNode(8);
		root.right = newNode(3);
		root.left.left = newNode(2);
		// root.left.right = newNode(5);
		// root.right.left = newNode(6);
		// root.right.right = newNode(7);
		// root.right.left.right = newNode(8);

		int sum = new NodesSum().solve(root);
		System.out.println("Sum of all the elements is: " + sum);

	}

}
