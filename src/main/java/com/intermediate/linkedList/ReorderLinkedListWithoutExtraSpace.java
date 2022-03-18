package com.intermediate.linkedList;

/**
Reorder List
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output
Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].
 */
public class ReorderLinkedListWithoutExtraSpace {
	
	
	public ListNode reorderList(ListNode head) {
		//find middle of linked list
		ListNode fast = head;
		ListNode slow = head;
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		//reverse second half of list
		ListNode prev = null;
		ListNode curr = slow;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		//rebuild linked list with reversed second half on odd indexes
		ListNode reverse = prev;
		boolean isEven = true;
		ListNode result = new ListNode(-1);
		ListNode ptr = head;
		while(ptr != slow || reverse != null) {
			result.next = isEven ? ptr : reverse;
			ptr = isEven && ptr.next != null ? ptr.next : ptr;
			reverse = isEven && reverse.next != null ? reverse : reverse.next;
			isEven = !isEven;
			result = result.next;
		}
		return result;
	}
	 

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ReorderLinkedListWithoutExtraSpace reorderLinkedList = new ReorderLinkedListWithoutExtraSpace();
		ListNode result = reorderLinkedList.reorderList(head);
		System.out.println(result);

	}

}
