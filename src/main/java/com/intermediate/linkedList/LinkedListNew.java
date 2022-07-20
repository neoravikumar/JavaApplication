package com.intermediate.linkedList;

public class LinkedListNew {
	
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	    private Node head;
	    private int size;

	    public LinkedListNew() {
	    }

	    public void addToEnd(char data) {
	        addAtIndex(data, size);
	    }

	    public void addToBeginning(char data) {
	        addAtIndex(data, 0);
	    }

	    public void addAtIndex(char data, int index) {
	        Node temp = new Node(data);
	        if (index < 0 || index > size) {
	            throw new IndexOutOfBoundsException();
	        } else if (index == 0) {
	        	temp.next = head;
	            head = temp;
	            incrementCount();
	        } else {
	            Node current = head;
	            for (int i = 1; i < index; i++) {
	                current = current.next;
	            }
	            temp.next = current.next;
	            current.next= temp;
	            incrementCount();
	        }
	    }

	    public void deleteFromBeginning() {
	        deleteFromIndex(0);
	    }

	    public void deleteFromEnd() {
	        deleteFromIndex(size - 1);
	    }

	    public void deleteFromIndex(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException();
	        } else if (index == 0) {
	            head = head.next;
	            decrementCount();
	        } else {
	            Node current = head;
	            for (int i = 1; i < index; i++) {
	                current = current.next;
	            }
	            current = current.next.next;
	            decrementCount();
	        }
	    }

	    public char getFirst() {
	        return getAtIndex(0);
	    }

	    public char getLast() {
	        return getAtIndex(size - 1);
	    }

	    public char getAtIndex(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException();
	        } else {
	            Node current = head;
	            for (int i = 0; i < index && current != null; i++) {
	                current = current.next;
	            }
	            return (char) current.data;
	        }
	    }

	    public void decrementCount() {
	        size--;
	    }

	    public void incrementCount() {
	        size++;
	    }

	    public int getSize() {
	        return size;
	    }

	    public Node getHead() {
	        return head;
	    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
