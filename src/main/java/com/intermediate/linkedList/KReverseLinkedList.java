package com.intermediate.linkedList;

/*
K reverse linked list
Problem Description

Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return modified linked list.



Problem Constraints
1 <= |A| <= 103

B always divides A



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
 */

//public ListNode next;
//
//ListNode(int x) {
//	val = x;
//	next = null;
//}
public class KReverseLinkedList {

	public ListNode reverseList(ListNode A, int B) {

		if (A == null || A.next == null) {
			return A;
		}

		ListNode prev = null;
		ListNode curr = A;
		ListNode nxt = null;
		int count = 0;
		while (curr != null && count < B) {
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
			count++;
		}

		if (nxt != null) {
			A.next = reverseList(nxt, B);
		}
		return prev;
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
		KReverseLinkedList kReverseLinkedList = new KReverseLinkedList();
		ListNode resultHead = kReverseLinkedList.reverseList(head, 2);
		ReverseLinkListII.print_ll(resultHead);
		
	}

}
