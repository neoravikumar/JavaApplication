package com.intermediate.tree;

import java.util.ArrayList;
import java.util.Collections;

public class PrintPathRootToNode {

	public static ArrayList<Integer> path;

	public Boolean printPath(TreeNode root, TreeNode dest, ArrayList<Integer> mypath) {
		if (root == null)
			return false;
		if (root == dest || printPath(root.left, dest,mypath) || printPath(root.right, dest,mypath)) {
			// System.out.print(" " + root.data);
			mypath.add(root.val);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws java.lang.Exception {
		
		/*
		 * TreeNode root = new TreeNode(1); root.left = new TreeNode(2); root.right =
		 * new TreeNode(3); TreeNode n1 = new TreeNode(4); root.left.left = n1;
		 * root.left.right = new TreeNode(5); TreeNode n2 = new TreeNode(8);
		 * root.left.right.right = n2; root.left.right.left = new TreeNode(7);
		 */
		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		//root.left.left = new TreeNode(4);
		TreeNode n2 = new TreeNode(4);
		root.left.right = n2;
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(5);

		PrintPathRootToNode i = new PrintPathRootToNode();
		ArrayList<Integer> mypath = new ArrayList<>();
		i.printPath(root, n2, mypath);
		Collections.reverse(mypath);
		System.out.println(" mypath " + mypath);
	}

}
