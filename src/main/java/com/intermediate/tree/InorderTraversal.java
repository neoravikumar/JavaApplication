package com.intermediate.tree;

import java.util.ArrayList;

/**
 * Inorder Traversal Problem Description
 * 
 * Given a binary tree, return the inorder traversal of its nodes values.
 * 
 * NOTE: Using recursion is not allowed.
 * 
 * 
 * 
 * Problem Constraints 1 <= number of nodes <= 105
 * 
 * 
 * 
 * Input Format First and only argument is root node of the binary tree, A.
 * 
 * 
 * 
 * Output Format Return an integer array denoting the inorder traversal of the
 * given binary tree.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * 1 \ 2 / 3 Input 2:
 * 
 * 1 / \ 6 2 / 3
 * 
 * 
 * Example Output Output 1:
 * 
 * [1, 3, 2] Output 2:
 * 
 * [6, 1, 3, 2]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * The Inorder Traversal of the given tree is [1, 3, 2]. Explanation 2:
 * 
 * The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class InorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode A) {

		ArrayList<Integer> ans = new ArrayList<>();

		ans = calculateInOrderTraversal(A, ans);

		return ans;
	}

	private ArrayList<Integer> calculateInOrderTraversal(TreeNode A, ArrayList<Integer> ans) {
		if (A == null)
			return null;

		/* first recur on left child */
		calculateInOrderTraversal(A.left, ans);

		/* then Add the data to the ArrayList */
		ans.add(A.val);

		/* first recur on Right child */
		calculateInOrderTraversal(A.right, ans);

		return ans;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.right.left = newNode(6);
		// root.right.right = newNode(7);
		// root.right.left.right = newNode(8);

		ArrayList<Integer> result = new InorderTraversal().inorderTraversal(root);
		System.out.println(result);

	}

}
