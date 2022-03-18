package com.intermediate.binaryTree;

import com.intermediate.tree.TreeNode;

/**
Valid Binary Search Tree
Problem Description

Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:

 
   1
  /  \
 2    3
Input 2:

 
  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.
 */
public class ValidBinarySearchTree {

	public int isValidBST(TreeNode A) {
		return solve(A, null, null) ? 1 : 0;
	}

	private boolean solve(TreeNode root, Integer max, Integer min) {

		// an empty binary trees is a valid BST.
		if (root == null)
			return true;

		if (max != null && root.val >= max)
			return false;

		if (min != null && root.val <= min)
			return false;

		return solve(root.left, root.val, min) && solve(root.right, max, root.val);
	}

	public static void main(String[] args) {
		ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
		// Creating a binary tree
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.left.right = new TreeNode(14);
		root.right.right = new TreeNode(21);
		System.out.println(validBinarySearchTree.isValidBST(root));

	}

}
