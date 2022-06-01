package com.intermediate.binaryTree;

import com.intermediate.tree.TreeNode;

import java.util.List;

public class SortedArrayToBalancedBST {
	
	public TreeNode sortedArrayToBST(final List<Integer> A) {

		return solve(A, 0, A.size() - 1);
	}

	private TreeNode solve(List<Integer> A, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start+ (end-start)/2;
		TreeNode node = new TreeNode(A.get(mid));
		node.left = solve(A, start, mid - 1);
		node.right = solve(A, mid+1, end);
		return node;
	}

	public static void main(String[] args) {
		
		/*SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
	        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
	        int n = arr.length;
	        root = tree.sortedArrayToBST(arr);
	        System.out.println("Preorder traversal of constructed BST");
	        tree.preOrder(root);*/

	}

}
