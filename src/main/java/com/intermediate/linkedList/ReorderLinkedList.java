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
public class ReorderLinkedList {
	
	
	public ListNode reorderList(ListNode head) {
	    ListNode slow=head,fast=head;
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    ListNode mid = slow.next;
	    slow.next=null;
	    ListNode rev = reverse(null,mid);
	    head = merge(head,rev);
	    return head;
	    }

	ListNode merge(ListNode head,ListNode rev){
	    if(head==null) return rev;
	    if(rev==null) return head;
	    
	    head.next=merge(rev,head.next);
	    return head;
	}

	ListNode reverse(ListNode prev,ListNode cur){
	    if(cur==null) return prev;
	    ListNode tem = cur.next;
	    cur.next=prev;
	    return reverse(cur,tem);
	}
	
	/*
	 * public ListNode reorderList(ListNode head) {
	 * 
	 * if (head == null || head.next == null) return null; Stack<ListNode> s = new
	 * Stack<>(); int count = 0; ListNode curr = head; while (curr != null) {
	 * s.add(curr); curr = curr.next; count++; } curr = head; for (int i = 0; i <=
	 * count / 2; i++) { ListNode temp = curr.next; curr.next = s.pop(); curr =
	 * curr.next; curr.next = temp; curr = curr.next;
	 * 
	 * } if (count % 2 != 0) curr.next.next = null; else curr.next = null;
	 * 
	 * return curr; }
	 */

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
		ListNode result = reorderLinkedList.reorderList(head);
		System.out.println(result);

	}

}
