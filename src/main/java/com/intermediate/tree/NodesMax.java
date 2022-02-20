package com.intermediate.tree;

/**
 * Nodes Max Problem Description
 * 
 * You are given the root node of a binary tree A. You have to find the max
 * value of all node values of this tree.
 * 
 * 
 * 
 * Problem Constraints 1 <= Number of nodes in the tree <= 105
 * 
 * 0 <= Value of each node <= 104
 * 
 * 
 * 
 * Input Format First and only argument is a tree node A.
 * 
 * 
 * 
 * Output Format Return an integer denoting the max of all node values of the
 * tree.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * Values = 1 / \ 4 3 Input 2:
 * 
 * 
 * Values = 1 / \ 8 3 / 2
 * 
 * 
 * Example Output Output 1:
 * 
 * 4 Output 2:
 * 
 * 8
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Clearly, among 1, 4, 3: 4 is maximum. Explanation 2:
 * 
 * Clearly, among 1, 8, 3, 2: 8 is maximum.
 */
public class NodesMax {

	public int solve(TreeNode root) {

		if (root == null)
			return Integer.MIN_VALUE;

		int res = root.val;
		int lres = solve(root.left);
		int rres = solve(root.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(8);
		root.right = new TreeNode(3);
		// root.left.left = new TreeNode(2);
		// root.left.right = newNode(5);
		// root.right.left = newNode(6);
		// root.right.right = newNode(7);
		// root.right.left.right = newNode(8);

		int max = new NodesMax().solve(root);
		System.out.println("Max of all the elements is: " + max);

	}

}
