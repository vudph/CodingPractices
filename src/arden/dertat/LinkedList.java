package arden.dertat;

import java.awt.image.RescaleOp;

public class LinkedList {
	static class Node {
		int value;
		Node next;
		
		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}
	private Node head;
	private Node tail;
	private int n = 0;
	
	private void addLast(int x) {
		Node node = new Node();
		node.value = x;
		node.next = null;
		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		n++;
	}
	
	private boolean isEmpty() {
		return n == 0 ? true : false;
	}
	
	private Node buildList(int a[]) {
		Node head = null;
		for (int i = 0; i < a.length; i++) {
			addLast(a[i]);
		}
		return head;
	}
	
	private void printList() {
		if (head == null) return;
		Node current = head;
		while (current.next != null) {
			System.out.print(current.value + ", ");
			current = current.next;
		}
		System.out.println(current.value);
	}
	
	private void reverse() {
		tail = reverse(head);
		tail.next = null;
	}
	
	private Node reverse(Node node) {
		if (node == tail) {
			head = node;
			return node;
		}
		Node t = reverse(node.next);
		t.next = node;
		return node;
	}

	public void reverseIterative() {
		Node prev = null;
		Node current = head;
		tail = head;
		Node next;
		while (current.next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = current;
		head.next = prev;
	}
	private void remove(int x) {
//		while(head != null && head.value == x) {
//			head = head.next;
//		}
//		if (head == null) 
//			return;
//		Node current = head;
//		while(current.next != null) {
//			if (current.next.value == x) {
//				current.next = current.next.next; 
//			} else {
//				current = current.next;
//			}
//		}
		Node current = head;
		while (current.next != null) {
			if (current.next.value == x) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		tail = current;
		if (head != null && head.value == x) {
			head = head.next;
			if (head == null) {
				tail = null;
			}
		}
	}
	
	public int getMiddle() {
		Node iter = head;
		Node fastIter = null;
		if (head.next != null) {
			fastIter = head.next.next;
		}
		while (iter.next != null && fastIter != null) {
			iter = iter.next;
			if (fastIter.next != null) {
				fastIter = fastIter.next.next;
			} else {
				return iter.value;
			}
		}
		return iter.value;
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7};
		LinkedList l = new LinkedList();
		l.buildList(a);
		l.printList();
//		l.remove(1);
//		l.printList();
//		l.reverse();
//		l.reverseIterative();
//		l.printList();
		System.out.println(l.getMiddle());
	}

}
