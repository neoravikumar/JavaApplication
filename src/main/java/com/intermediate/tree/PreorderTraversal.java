package com.intermediate.tree;

import java.util.ArrayList;

/*
 Preorder Traversal
Problem Description

Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the preorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 6, 2, 3]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:

 The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
public class PreorderTraversal {
	
	public ArrayList<Integer> preorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		ans = calculatePreOrderTraversal(A, ans);
		return ans;
	}

	private ArrayList<Integer> calculatePreOrderTraversal(TreeNode A, ArrayList<Integer> ans) {
		if (A == null)
			return null;

		ans.add(A.val);
		calculatePreOrderTraversal(A.left, ans);
		calculatePreOrderTraversal(A.right, ans);

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

		ArrayList<Integer> result = new PreorderTraversal().preorderTraversal(root);
		System.out.println(result);

	}

}
