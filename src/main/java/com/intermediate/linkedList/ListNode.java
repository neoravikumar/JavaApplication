package com.intermediate.linkedList;

public class ListNode {

	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static void printLinkedList(ListNode head) {
		while(head !=null) {
			System.out.print(head.val +"->");
			head = head.next;
		}
	}
}
