package com.intermediate.tree;

import java.util.ArrayList;
import java.util.List;

/**
 Node distance C in binary tree
Given a binary tree of integers. All nodes in the binary tree have distinct values. You are given an integer B.

You have to find all the nodes that are at a distance of exactly C from the node containing value B.

Return an array of integers consisting all the nodes that are C distance from node containing value B.

Note:

You may return the nodes in any order.

Your solution will run on multiple test cases, if you are using global variables make sure to clear every time .

Constraints

1 <= Number of nodes in binary tree <= 100000
0 <= Node values <= 10^9 
0 <= B <= 10^9
0 <= C <= 100
For Example

Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 

     B = 3
     C = 3
Output 1:
    [4, 5]

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
        B = 4
        C = 1
Output 2:
    [2, 5]
 */
public class NodeDistanceCInBinaryTree {
	
	List<TreeNode> mypath = null;
	
	public ArrayList<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		ArrayList<TreeNode> mypath = new ArrayList<>();
		printPath(root, target,mypath);
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < mypath.size(); i++) {
			findDistance(mypath.get(i), K - i, result, i == 0 ? null : mypath.get(i - 1));
		}
		//Returning list of all nodes at a distance K
		return result;
	}
	
	
	public Boolean printPath(TreeNode root, TreeNode dest, ArrayList<TreeNode> mypath) {
		if (root == null)
			return false;
		if (root == dest || printPath(root.left, dest,mypath) || printPath(root.right, dest,mypath)) {
			mypath.add(root);
			return true;
		}
		return false;
	}
	
	public void findDistance(TreeNode node, int dist, List<Integer> result, TreeNode temp) {
		if (dist < 0 || node == null || (temp != null && node == temp)) {
			return;
		}
		if (dist == 0) {
			result.add(node.val);
		}
		findDistance(node.left, dist - 1, result, temp);
		findDistance(node.right, dist - 1, result, temp);
	}
	
	public boolean findPath(TreeNode node, TreeNode target, List<TreeNode> path2)
    {
        if (node == null)
            return false;
 
        if (node == target || findPath(node.left, target,path2)
            || findPath(node.right, target,path2)) {
        	path2.add(node);
            return true;
        }
 
        return false;
    }
	
	public ArrayList<Integer> solve(TreeNode A, int B, int C) {
		
		ArrayList<Integer> result = null;
		TreeNode target = new TreeNode(B);
		result = distanceK(A, target, C);
		return result;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		//root.left.left = new TreeNode(4);
		TreeNode n2 = new TreeNode(4);
		root.left.right = n2;
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(5);
		
		NodeDistanceCInBinaryTree nodeDistanceCInBinaryTree = new NodeDistanceCInBinaryTree();
		ArrayList<Integer> mypath = new ArrayList<>();
		TreeNode target = new TreeNode(4);
		nodeDistanceCInBinaryTree.distanceK(root, target, 1);
		System.out.println("Ravi");
		for(Integer t : mypath) {
			System.out.println(t);
		}
	}
}
