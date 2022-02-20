package com.intermediate.linkedList;

/*
 Remove Nth Node from List End
Problem Description

Given a linked list A, remove the B-th node from the end of list and return its head.

For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.

NOTE: Try doing it using constant additional space.



Problem Constraints
1 <= |A| <= 106



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second argument of input contains the integer B.



Output Format
Return the head of the linked list after deleting the B-th element from the end.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 2
Input 2:

A = [1]
B = 1


Example Output
Output 1:

[1, 2, 3, 5]
Output 2:

 [] 


Example Explanation
Explanation 1:

In the first example, 4 is the second last element.
Explanation 2:

In the second example, 1 is the first and the last element.
 */
/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class RemoveNthNodefromListEnd {

	public ListNode removeNthFromEnd(ListNode A, int B) {
		if ((A == null || A.next == null)) {
			if (B == 1) {
				return null;
			}
		}
		ListNode head = A;
		int totalCount = 0;
		ListNode current = head;
		while (current != null) {
			if (current.next == null) {
				++totalCount;
			} else {
				++totalCount;
			}
			current = current.next;
		}

		int deleteNodeAt = totalCount - B;
		current = head;

		if (B >= totalCount) {
			current = head.next;
			head = current;
			return head;
		}

		totalCount = 0;
		ListNode prev = null;

		while (current != null) {
			if (totalCount == deleteNodeAt) {
				if (prev.next != null) {
					ListNode temp = current.next;
					prev.next = temp;
					current = prev;
					temp = null;
				}
			} else {
				prev = current;
				current = current.next;
			}
			totalCount++;
		}
		return head;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		// head.next.next.next.next.next = new ListNode(6);
		// head.next.next.next.next.next.next = new ListNode(7);
		// head.next.next.next.next.next.next.next = new ListNode(8);

		RemoveNthNodefromListEnd rmlvNxt = new RemoveNthNodefromListEnd();

		ListNode result = rmlvNxt.removeNthFromEnd(head, 5);
		System.out.println(result);

		ReverseLinkListII.print_ll(result);

	}
}