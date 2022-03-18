package com.intermediate.linkedList;

import java.util.Arrays;

/**
 Problem Description

Sort a linked list, A in O(n log n) time using constant space complexity.



Problem Constraints

0 <= |A| = 105



Input Format

The first and the only arugment of input contains a pointer to the head of the linked list, A.



Output Format

Return a pointer to the head of the sorted linked list.



Example Input

Input 1:

A = [3, 4, 2, 8]
Input 2:

A = [1]


Example Output

Output 1:

[2, 3, 4, 8]
Output 2:

[1]


Example Explanation

Explanation 1:

 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:

 The sorted form of [1] is [1].
 */
public class SortList {
	
	public ListNode sortList(ListNode A) {
		
		if (A == null || A.next == null)
			return A;
		ListNode l = A;
		int c = 0;
		while (l != null) {
			c++;
			l = l.next;
		}
		int a[] = new int[c];
		l = A;
		int i = 0;
		while (l != null) {
			a[i++] = l.val;
			l = l.next;
		}
		Arrays.sort(a);
		l = A;
		i = 0;
		while (l != null) {
			l.val = a[i++];
			l = l.next;
		}
		return A;
	}
	
	 
	 public static void main(String[] args) {
		 
			ListNode head = new ListNode(1);
			head.next = new ListNode(2);
			head.next.next = new ListNode(3);
			head.next.next.next = new ListNode(4);
			head.next.next.next.next = new ListNode(5);
			
			SortList sortList = new SortList();
			ListNode result = sortList.sortList(head);
			ListNode.printLinkedList(head);
			System.out.println();
			System.out.println(result);
	}

}
