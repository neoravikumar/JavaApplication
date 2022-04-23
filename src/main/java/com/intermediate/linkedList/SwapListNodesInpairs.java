package com.intermediate.linkedList;

/*
 Swap List Nodes in pairs
Problem Description
Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4
Input 2:

 A = 7 -> 2 -> 1


Example Output
Output 1:

 2 -> 1 -> 4 -> 3
Output 2:

 2 -> 7 -> 1


Example Explanation
Explanation 1:

 In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
Explanation 2:

 In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 
 */


public class SwapListNodesInpairs {
	
	public ListNode swapPairs(ListNode A) {
		
		if(A.next == null){
            return A;
        }
        ListNode current = A;
        ListNode firstPrev = null;
        ListNode secondPrev = null;
        int counter = 0;
        while(current!=null){
            counter++;
            ListNode next = current.next;
            if((counter & 1) == 0 ){
                secondPrev.next = next;
                current.next = secondPrev;
                if(firstPrev!=null){
                    firstPrev.next = current;
                }
                if(counter == 2){
                    A = current;
                }
            }else{
                firstPrev = secondPrev;
                secondPrev = current;
            }
            current = next;
        }
        return A;
		
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		SwapListNodesInpairs swapListNodesInpairs = new SwapListNodesInpairs();
		ListNode result = swapListNodesInpairs.swapPairs(head);
		System.out.println(result);
	}

}
