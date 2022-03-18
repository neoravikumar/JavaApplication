package com.intermediate.linkedList;

/**
 * Merge Two Sorted Lists
 * 
 * Problem Description
 * 
 * Merge two sorted linked lists A and B and return it as a new list.
 * 
 * The new list should be made by splicing together the nodes of the first two
 * lists, and should also be sorted.
 * 
 * 
 * 
 * Problem Constraints 0 <= |A|, |B| <= 105
 * 
 * 
 * 
 * Input Format The first argument of input contains a pointer to the head of
 * linked list A.
 * 
 * The second argument of input contains a pointer to the head of linked list B.
 * 
 * 
 * 
 * Output Format Return a pointer to the head of the merged linked list.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = 5 -> 8 -> 20 B = 4 -> 11 -> 15 Input 2:
 * 
 * A = 1 -> 2 -> 3 B = Null
 * 
 * 
 * Example Output Output 1:
 * 
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20 Output 2:
 * 
 * 1 -> 2 -> 3
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 Explanation 2:
 * 
 * We don't need to merge as B is empty.
 */
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		if (A == null)
			return B;
		if (B == null)
			return A;

		ListNode first = A;
		ListNode second = B;
		ListNode head = null;
		ListNode last = null;

		while (first != null && second != null) {
			if (first.val < second.val) {
				if (last != null) {
					last.next = first;
				}
				last = first;
				first = first.next;
			} else {
				if (last != null) {
					last.next = second;
				}
				last = second;
				second = second.next;
			}
			if (head == null) {
				head = last;
			}
		}

		if (first == null) {
			last.next = second;
		}
		if (second == null) {
			last.next = first;
		}

		return head;

	}

	public static void main(String[] args) {

		ListNode head = new ListNode(5);
		head.next = new ListNode(8);
		head.next.next = new ListNode(20);

		ListNode head2 = new ListNode(4);
		head.next = new ListNode(11);
		head.next.next = new ListNode(15);

		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode result = mergeTwoSortedLists.mergeTwoLists(head, head2);
		System.out.println(result);

	}

}
