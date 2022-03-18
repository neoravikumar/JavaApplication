package com.intermediate.tree;

/**
 Path Sum
Problem Description

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.



Problem Constraints
1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the sum.



Output Format
Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.



Example Input
Input 1:

 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

 B = 22
Input 2:

 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4

 B = -1


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
Explanation 2:

 There is no path which has sum -1.
 */
public class PathSum {
	
	public boolean treeSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		int sum = targetSum - root.val;
		if (sum == 0 && (root.left == null && root.right == null))
			return true;
		return treeSum(root.left, sum) || treeSum(root.right, sum);
	}

	public int hasPathSum(TreeNode A, int B) {
		boolean result = treeSum(A, B);
		if (result) {
			return 1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		TreeNode tree = new TreeNode(5);

		tree.left = new TreeNode(4);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(11);
		tree.left.left.left = new TreeNode(7);
		tree.left.left.right = new TreeNode(2);
		tree.right.left = new TreeNode(13);
		tree.right.right = new TreeNode(4);
		tree.right.right.right = new TreeNode(1);

		System.out.println("Height of tree is : " + new PathSum().hasPathSum(tree, 88));

	}

}
