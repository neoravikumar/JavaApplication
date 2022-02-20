package com.intermediate.linkedList;

/*
 Reverse Link List II
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output
Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation
Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
 */
public class ReverseLinkListII {

	public ListNode reverseBetween(ListNode A, int start, int end) {

		if(A==null || A.next==null){
            return A;
        } 
		
		ListNode temp = new ListNode(-1);
        temp.next=A;
        ListNode currNode = temp;
        ListNode prevNode = null;
        
        int i=0;
        while(i<start){
            prevNode=currNode;
            currNode=currNode.next;
            i++;
        }
        
        ListNode prev = currNode;
        ListNode curr = currNode.next;
        
        while(start<end){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            start++;
        }
        
        prevNode.next=prev;
        currNode.next=curr;
        
        return temp.next;
        
	}
	
	public static void print_ll(ListNode head) {
		ListNode current = head;
		while (current != null) {
			if(current.next == null) {
				System.out.print(current.val);
			}else {
				System.out.print(current.val+" ");
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ReverseLinkListII reverseLinkListII = new ReverseLinkListII();
		ListNode result = reverseLinkListII.reverseBetween(head, 2, 4);
		print_ll(result);
	}

}
