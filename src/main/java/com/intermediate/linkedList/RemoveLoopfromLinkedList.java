package com.intermediate.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
Remove Loop from Linked List
Problem Description

Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000



Input Format
Only argument is the head of the linked list.



Output Format
return the head of the updated linked list.



Example Input
Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
 */
public class RemoveLoopfromLinkedList {
	
	public static ListNode push(ListNode head, int data)
    {
		ListNode node = new ListNode(data);
        node.val = data;
        node.next = head;
        return node;
    }
	
	public static ListNode solve(ListNode A) {

        ListNode prev = null;        // previous pointer
        ListNode curr = A;        // main pointer
 
        // maintain a set to store visited nodes
        Set<ListNode> set = new HashSet<>();
 
        // traverse the list
        while (curr != null)
        {
            // set the previous pointer to null if the current node is seen before
            if (set.contains(curr))
            {
                prev.next = null;
            }
 
            // insert the current node into the set
            set.add(curr);
 
            // update the previous pointer to the current node and
            // move the main pointer to the next node
            prev = curr;
            curr = curr.next;
        }
        return curr;
    }
	
    // Utility function to print a linked list
    public static void printList(ListNode head)
    {
    	ListNode curr = head;
        while (curr != null)
        {
            System.out.print(curr.val + " —> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

	public static void main(String[] args) {
		// total number of nodes in the linked list
        int n = 5;
 
        // construct a linked list
        ListNode head = null;
        for (int i = n; i > 0; i--) {
            head = push(head, i);
        }
 
        // insert cycle
        head.next.next.next.next.next = head.next;
 
        solve(head);
        printList(head);

	}

}
