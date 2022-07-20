package com.intermediate.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {
		BinaryTreeFromInorderAndPostorder binaryTreeFromInorderAndPostorder = new BinaryTreeFromInorderAndPostorder();
		TreeNode result = binaryTreeFromInorderAndPostorder.buildTree(new ArrayList<>(Arrays.asList(7, 5, 6, 2, 3, 1, 4)),new ArrayList<>(Arrays.asList(5, 6, 3, 1, 4, 2, 7)));
		System.out.println(result);

	}

	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildForRoot(A,B,0,A.size()-1,A.size()-1);
    }

    public TreeNode buildForRoot(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder,int inStart, int inEnd, int postEnd){
        if(inStart > inEnd){
            return null;
        }

        if(inStart == inEnd){
            return new TreeNode(inOrder.get(inStart));
        }

        TreeNode root = new TreeNode(postOrder.get(postEnd));
        int i = inStart;
        while(i<=inEnd && root.val != inOrder.get(i)){
            i++;
        }

        root.left = buildForRoot(inOrder,postOrder,inStart,i-1,postEnd-inEnd+i-1);
        root.right = buildForRoot(inOrder,postOrder,i+1,inEnd,postEnd-1);
        return root;
    }
}
