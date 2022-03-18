package com.intermediate.tree;



/**
 Next Pointer Binary Tree
Problem Description

Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree and try to solve this in constant extra space.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return the head of the binary tree after the changes are made.



Example Input
Input 1:

 
     1
    /  \
   2    3
Input 2:

 
        1
       /  \
      2    5
     / \  / \
    3  4  6  7


Example Output
Output 1:

 
        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2:

 
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL


Example Explanation
Explanation 1:

Next pointers are set as given in the output.
Explanation 2:

Next pointers are set as given in the output.
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class NextPointerBinaryTree {
	
	private TreeLinkNode DFS(TreeLinkNode root) {
        if(root == null) return root;
        if(root.left != null) root.left.next = root.right;
        if(root.next != null && root.next.left != null) root.right.next = root.next.left;
        DFS(root.left);
        DFS(root.right);
        return root;
    }
   
    
	public void connect(TreeLinkNode root) {
		DFS(root);
	}

	public static void main(String[] args) {
		
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		//root.left.left.left = new TreeNode(8);

		NextPointerBinaryTree nextPointerBinaryTree = new NextPointerBinaryTree();
		nextPointerBinaryTree.connect(root);

	}

}
