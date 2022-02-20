package com.intermediate.tree;


/*
 Nodes Count
Problem Description

You are given the root node of a binary tree A. You have to find the number of nodes in this tree.



Problem Constraints
1 <= Number of nodes in the tree <= 105

0 <= Value of each node <= 107



Input Format
First and only argument is a tree node A.



Output Format
Return an integer denoting the number of nodes of the tree.



Example Input
Input 1:

 Values =  1 
          / \     
         4   3                        
Input 2:

 
 Values =  1      
          / \     
         4   3                       
        /         
       2                                     


Example Output
Output 1:

 3 
Output 2:

 4 


Example Explanation
Explanation 1:

Clearly, there are 3 nodes 1, 4 and 3.
Explanation 2:

Clearly, there are 4 nodes 1, 4, 3 and 2.
 */
public class NodeCount {

	public int solve(TreeNode root) {
		
		if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        
        int a = checkLeft(root);
        int b = checkRight(root);
        
        if(a == b){
            return (int) Math.pow(2, a) - 1;
        }
        
        return 1 + solve(root.left) + solve(root.right);
    }
    
    int checkLeft(TreeNode root){
        if(root == null) return 0;
        
        return 1 + checkLeft(root.left);
    }
    
    int checkRight(TreeNode root){
        if(root == null) return 0;
        
        return 1 + checkRight(root.right);
    }


	static TreeNode newNode(int data) {
		TreeNode node = new TreeNode(data);
		node.val = data;
		node.left = null;
		node.right = null;
		return (node);
	}

	public static void main(String[] args) {

		TreeNode root = newNode(1);
		root.left = newNode(4);
		root.right = newNode(3);
		//root.left.right = newNode(2);
		//root.left.right.left = newNode(1);
		//root.left.right.right = newNode(11);
		root.right.right = newNode(2);
		//root.right.right.left = newNode(4);

		NodeCount nc = new NodeCount();
		System.out.println(nc.solve(root));

	}

}
