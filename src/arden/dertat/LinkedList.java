package arden.dertat;

public class LinkedList {
	static class Node {
		int value;
		Node next;
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
		Node current = head;
		while (current.next != null) {
			System.out.print(current.value + ", ");
			current = current.next;
		}
		System.out.println(current.value);
	}
	
	private void remove(int x) {
		while(head != null && head.value == x) {
			head = head.next;
		}
		Node current = head;
		while(current.next != null) {
			if (current.next.value == x) {
				current.next = current.next.next; 
			} else {
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = {1, 1, 1, 4, 1, 1, 3, 2, 1, 3};
		LinkedList l = new LinkedList();
		l.buildList(a);
		l.printList();
		l.remove(1);
		l.printList();
	}

}
