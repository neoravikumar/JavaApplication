package com.intermediate.tree;

public class Pair implements Comparable<Pair>{
	TreeNode node;
	int pos;
	
	Pair(TreeNode node, int pos){
		this.node = node;
		this.pos = pos;
	}
	
	public int compareTo(Pair o) {
    	return this.node.val - o.node.val;
	}
}