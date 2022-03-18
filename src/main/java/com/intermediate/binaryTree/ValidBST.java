package com.intermediate.binaryTree;

import com.intermediate.tree.TreeNode;

public class ValidBST {

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public static boolean isValidBST(TreeNode root, Integer max, Integer min) {

		// an empty binary trees is a valid BST.
		if (root == null)
			return true;

		if (max != null && root.val >= max)
			return false;

		if (min != null && root.val <= min)
			return false;

		return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
	}

	public static void main(String args[]) {
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

		if (ValidBST.isValidBST(root))
			System.out.println("A valid BST");
		else
			System.out.println("Not a valid BST");
	}

}
