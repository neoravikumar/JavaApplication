package com.intermediate.linkedList;

/*
 Delete middle node of a Linked List
Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

Return the head of the linked list after removing the middle node.

If the input linked list has 1 node, then this node should be deleted and a null node should be returned.


Input Format

The only argument given is the node pointing to the head node of the linked list
 */
public class DeleteMiddleNodeOfALinkedList {
	
	static void printList(ListNode ptr) {
		while (ptr != null) {
			System.out.print(ptr.val + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	public ListNode solve(ListNode A) {
		ListNode head = A;
		if (head == null)
			return null;
		if (head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode prevNode = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prevNode = slow;
			slow = slow.next;
		}
		prevNode.next = slow.next;
		return head;
	}

	public static void main(String[] args) {
		DeleteMiddleNodeOfALinkedList middleElementOfLlinkedList = new DeleteMiddleNodeOfALinkedList();
		ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
		ListNode dNode = middleElementOfLlinkedList.solve(head);
		printList(dNode);
	}

}
