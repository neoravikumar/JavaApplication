package com.intermediate.linkedList;

import java.util.Scanner;

public class Main {
	
	static int length;
	static ListNode head;

	class Node {
		int val;
		ListNode next;

		Node(int x) {
			this.val = x;
		}
	}

	public Main() {
		this.length = 0;
		this.head = null;
	}

	public static void insert_node(int position, int value) {
		ListNode newNode = new ListNode(value);
		ListNode temp = head;
		int counter = 0;
		if ((position) == length) {
			addAtTail(value);
			return;
		}
		if (position > length) {
			return;
		}
		if (position == 0) {
			addAtHead(value);
			return;
		}
		while (counter != (position - 1)) {
			temp = temp.next;
			counter++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
	}

	private static void addAtTail(int value) {
		// TODO Auto-generated method stub
		
	}

	private static void addAtHead(int value) {
		// TODO Auto-generated method stub
		
	}

	public static void delete_node(int position) {

		if (position < 0 || position >= length) {
			return;
		}
		ListNode curr = head;
		if (position == 0) {
			head = curr.next;
		} else {
			ListNode current = head;
			ListNode pre = null;
			int counter = 0;
			while (counter != position) {
				pre = current;
				current = current.next;
				counter++;
			}
			pre.next = current.next;
			length--;
		}
	}

	public static void print_ll() {

		ListNode currNode = head;

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = 0, position = 0, value = 0;
		cases = s.nextInt();
		for (int i = 0; i < cases; i++) {
			char ch = s.next().charAt(0);
			switch (ch) {
			case 'i':
				position = s.nextInt();
				value = s.nextInt();
				insert_node(position, value);
				break;
			case 'd':
				position = s.nextInt();
				delete_node(position);
				break;
			case 'p':
				print_ll();
				System.out.println();
				break;
			default:
				System.out.println("Check Your Input");
			}
		}
	}
}
