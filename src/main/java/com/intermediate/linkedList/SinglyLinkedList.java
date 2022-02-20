package com.intermediate.linkedList;

public class SinglyLinkedList {

	public static int length;
	public static Node head = null;
	public static Node tail = null;

	// Represent a node of the singly linked list
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public SinglyLinkedList() {
		this.length = length;
		this.head = head;
		this.tail = tail;
	}

	public static void addAtHead(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		length++;
	}

	public static void addAtTail(int val) {
		if (length == 0) {
			addAtHead(val);
			return;
		}
		Node newNode = new Node(val);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = null;
		length++;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {

		if (index < 0 || index >= this.length) {
			return -1;
		} else {
			int counter = 0;
			Node curr = head;
			while (counter != (index)) {
				curr = curr.next;
				counter++;
			}
			return curr.data;
		}

	}

	// function to create and return a Node
	static Node GetNode(int data) {
		return new Node(data);
	}

	public static void insert_node22(int position, int value) {

		if (head == null) {
			Node newNode = new Node(value);
			head = newNode;
			tail = newNode;
			length++;
			return;
		} else {
			while (position-- != 0) {
				if (position == 1) {
					Node newNode = GetNode(value);
					newNode.next = head.next;
					head.next = newNode;
					break;
				}
				head = head.next;
			}
		}

	}

	/*
	 * public static void insert_node(int position, int value) { if (position <= 1)
	 * { Node newNode = new Node(value); newNode.next = head; head = newNode; } else
	 * { int i = 1; Node newnode = head; while (newnode.next != null && i < position
	 * - 1) { newnode = newnode.next; i++; } Node newN = new Node(value); newN.next
	 * = newnode.next; newnode.next = newN; }
	 * 
	 * }
	 */
	
	public static void insert_node(int position, int value) {
        
        if (position <= 1) {
			Node newNode = new Node(value);
			newNode.next = head;
			head = newNode;
		} else {
			int i = 1;
			Node newnode = head;
			while (newnode.next != null && i < position - 1) {
				newnode = newnode.next;
				i++;
			}
			Node newN = new Node(value);
			newN.next = newnode.next;
			newnode.next = newN;
		}
    }
	
	
	
	

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public static void addAtIndex(int position, int value) {

		Node newNode = new Node(value);

		if (head == null) {
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
			length++;
		}

		Node temp = head;
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

	// addNode() will add a new node to the list
	public void addNode(int data) {
		// Create a new node
		Node newNode = new Node(data);

		// Checks if the list is empty
		if (head == null) {
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
			this.length++;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tail.next = newNode;
			// newNode will become new tail of the list
			tail = newNode;
			this.length++;
		}
	}

	public static void delete_node(int position) {

		if(head==null) {
			return;
		}
		if(head.next==null) {
			head = null;
			return;
		}
		if(position<=1) {
			head = head.next;
		}
		int i=1;
		Node node = head;
		while(node.next != null) {
			if(i+1 == position) {
				node.next = node.next.next;
				break;
			}
			node = node.next;
			i++;
		}
		
	}

	public static void print_ll() {
		Node current = head;
		while (current != null) {
			if(current.next == null) {
				System.out.print(current.data);
			}else {
				System.out.print(current.data+" ");
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {

		insert_node(1, 226);
		insert_node(2, 875);
		insert_node(3, 604);
		insert_node(4, 550);
		insert_node(5, 498);
		insert_node(6, 875);
		insert_node(7, 847);
		insert_node(8, 633);
		insert_node(9, 793);
		insert_node(10, 872);
		insert_node(11, 313);
		insert_node(12, 440);
		insert_node(13, 331);
		insert_node(14, 582);
		insert_node(15, 188);
		insert_node(16, 476);
		insert_node(17, 722);
		insert_node(18, 402);
		insert_node(19, 890);
		insert_node(20, 713);
		insert_node(21, 421);
		insert_node(22, 930);
		insert_node(23, 579);
		insert_node(24, 459);
		insert_node(25, 278);
		insert_node(26, 818);
		insert_node(27, 320);
		insert_node(28, 549);
		insert_node(29, 240);
		insert_node(30, 528);
		insert_node(31, 367);
		insert_node(32, 835);
		insert_node(33, 20);
		insert_node(34, 170);
		insert_node(35, 903);
		insert_node(36, 242);
		insert_node(37, 943);
		insert_node(38, 802);
		insert_node(39, 145);
		insert_node(40, 291);
		insert_node(41, 224);
		insert_node(42, 400);
		insert_node(43, 43);
		insert_node(44, 355);
		insert_node(45, 83);
		insert_node(46, 26);
		insert_node(47, 816);
		insert_node(48, 477);
		insert_node(49, 425);
		insert_node(50, 543);
		insert_node(51, 211);
		insert_node(52, 799);
		insert_node(53, 185);
		insert_node(54, 5);
		insert_node(55, 184);
		insert_node(56, 150);
		insert_node(57, 572);
		insert_node(58, 626);
		insert_node(59, 109);
		insert_node(60, 807);
		delete_node(25);
		print_ll();
		delete_node(53);
		print_ll();
		delete_node(12);
		delete_node(54);
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		delete_node(39);
		delete_node(42);
		print_ll();
		delete_node(47);
		delete_node(45);
		delete_node(35);
		print_ll();
		delete_node(13);
		print_ll();
		delete_node(18);
		delete_node(59);
		delete_node(47);
		delete_node(43);
		delete_node(38);
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		delete_node(8);
		print_ll();
		delete_node(8);
		print_ll();
		delete_node(39);
		delete_node(60);
		delete_node(16);
		print_ll();
		print_ll();

	}
}
