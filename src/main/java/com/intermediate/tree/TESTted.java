package com.intermediate.tree;

import java.util.*;

public class TESTted {
	
	/**
	2
	 * Definition for binary tree
	3
	 * class TreeNode {
	4
	 *     int val;
	5
	 *     TreeNode left;
	6
	 *     TreeNode right;
	7
	 *     TreeNode(int x) {
	8
	 *      val = x;
	9
	 *      left=null;
	10
	 *      right=null;
	11
	 *     }
	12
	 * }
	13
	 */
	public class Solution {
	    class Pair
	    {
	        int hd;
	        TreeNode node;
	        Pair(int hd, TreeNode node)
	        {
	            this.hd = hd;
	            this.node = node;
	        }
	    }
	    public int[][] verticalOrderTraversal(TreeNode A) {
	        //TreeMap<Integer,ArrayList<Integer>>map = new TreeMap<Integer,ArrayList<Integer>>();
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
	        int hd=0;
	        Queue<Pair> q = new LinkedList<Pair>();
	        Pair temp = new Pair(hd,A);
	        q.add(temp);
	        while(true)
	        {
	            int qcount = q.size();
	            if(qcount == 0)
	                break;
	            while(qcount>0)
	            {
	                temp = q.poll();
	                ArrayList list = map.get(temp.hd);
	                if(list==null)
	                {
	                    list = new ArrayList<Integer>();
	                    list.add(temp.node.val);
	                }
	                else
	                {
	                   list.add(temp.node.val); 
	                }
	                map.put(temp.hd,list);
	                if(temp.node.left!=null)
	                {
	                    Pair leftpair = new Pair(temp.hd-1,temp.node.left);
	                    q.add(leftpair);
	                }
	                if(temp.node.right!=null)
	                {
	                    Pair rightpair = new Pair(temp.hd+1,temp.node.right);
	                    q.add(rightpair);
	                }
	                qcount--;
	            }
	        }
	        int ans[][]=new int[map.size()][];
	        int index = 0;
	        for(Map.Entry<Integer,ArrayList<Integer>> e : map.entrySet())
	        {
	            ArrayList list = e.getValue();
	            //System.out.println(list);
	           int[] t =new int[list.size()];
	            for(int i=0;i<list.size();i++)
	            {
	              t[i]=(int)(list.get(i));
	            }
	            ans[index++]=t; 
	        }
	        return ans;
	    }
	}

}
