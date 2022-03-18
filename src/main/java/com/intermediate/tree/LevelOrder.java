package com.intermediate.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Problem Description
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * Output Format Return a 2D integer array denoting the zigzag level order
 * traversal of the given binary tree.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * 3 / \ 9 20 / \ 15 7 Input 2:
 * 
 * 1 / \ 6 2 / 3
 * 
 * 
 * Example Output Output 1:
 * 
 * [ [3], [9, 20], [15, 7] ] Output 2:
 * 
 * [ [1] [6, 2] [3] ]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrder {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(A);
		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;
			ArrayList<Integer> row = new ArrayList<Integer>();
			while (nodeCount > 0) {
				int fResult = 0;
				TreeNode tempNode  = q.peek();
                System.out.print(tempNode.val + " ");
                row.add(tempNode.val);
                q.remove();
				/* Enqueue left child */
				if (tempNode.left != null) {
					q.add(tempNode.left);
					System.out.println("Left :>> >>"+tempNode.left.val);
				}
				/* Enqueue right child */
				if (tempNode.right != null) {
					q.add(tempNode.right);
					System.out.println("Right :>> >>"+tempNode.right.val);
				}
				nodeCount--;
			}
			//System.out.println();
			if (row != null && row.size() > 0) {
				result.add(row);
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
		//root.left.left.left = new TreeNode(8);

		ArrayList<ArrayList<Integer>> result = new LevelOrder().levelOrder(root);
		System.out.println(result);
	}

}
