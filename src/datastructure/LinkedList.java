package datastructure;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList<E extends Comparable<E>> {
	static class Node<E extends Comparable<E>> {
		E data;
		Node<E> next;
		Node<E> prev;
		
		public Node(E data) {
			this.data = data;
		}
		
		public void setData(E data) {
			this.data = data;
		}
		
		public E getData() {
			return this.data;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> node) {
			this.next = node;
		}
		
		public Node<E> getPrevious() {
			return prev;
		}
		
		public void setPrevious(Node<E> node) {
			this.prev = node;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (obj == null || (!(obj instanceof Node))) {
				return false;
			}
			Node<E> node = (Node<E>) obj;
			return this.data.compareTo(node.data) == 0;
		}
		
		@Override
		public int hashCode() {
			return this.data.hashCode();
		}
		
		@Override
		public String toString() {
			return this.data.toString();
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int n; 
	
	public LinkedList() {
		this.head = null; 
		this.tail = null;
		this.n = 0;
	}
	
	public void addLast(E data) {
		Node<E> node = new Node<E>(data);
		node.next = null;
		node.prev = null;
		if (isEmpty()) {
			this.head = this.tail = node;
		} else {
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;
		}
		n++;
	}
	
	public void addFirst(E data) {
		Node<E> node = new Node<E>(data);
		node.next = null;
		node.prev = null;
		if (isEmpty()) {
			this.head = this.tail = node;
		} else {
			this.head.prev = node;
			node.next = this.head;
			this.head = node;
		}
		n++;
	}
	
	public void removeFirst() throws Exception {
		if (!isEmpty()) {
			Node<E> oldHead = this.head;
			this.head = oldHead.next;
			this.head.prev = null;
			if (oldHead.next == null) {
				this.tail = null;
			}
			oldHead = null;
			n--;
		} else {
			throw new Exception("Linked list is empty");
		}
	}
	
	public void removeLast() throws Exception {
		if (!isEmpty()) {
			Node<E> oldTail = this.tail;
			this.tail = oldTail.prev;
			this.tail.next = null;
			if (oldTail.prev == null) {
				this.head = null;
			}
			oldTail = null;
			n--;
		} else {
			throw new Exception("Linked list is empty");
		}
	}
	
	public void removeMiddle() throws Exception {
		Node<E> middle = getMiddle();
		if (middle != null) {
			middle.prev.next = middle.next;
			middle.next.prev = middle.prev;
			middle = null;
		} else {
			throw new Exception("No exact middle found");
		}
	}
	
	public Node<E> getMiddle() throws Exception {
		Node<E> pleft = this.head;
		Node<E> pright = this.tail;
		while (pleft != pright) {
			pleft = pleft.next;
			pright= pright.prev;
		}
		return pleft;
	}
	
	public void removeDuplicates() throws Exception {
		Set<Node<E>> set = new HashSet<>();
		Node<E> current = this.head;
		while (current != null) {
			if (set.contains(current)) {
				remove(current);
			} else {
				set.add(current);
			}
			current = current.next;
		}
	}
	
	private void remove(Node<E> node) throws Exception {
		if (node == this.tail) {
			removeLast();
		} else if (node == this.head) {
			removeFirst();
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node = null;
		}
		n--;
	}

	public boolean isEmpty() {
		return n == 0;
	}
	
	public void reverseStack() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E> current = this.head;
		while (current.next != null) {
			stack.push(current);
			current = current.next;
		}
		this.head = current;
		this.head.prev = null;
		while (!stack.isEmpty()) {
			Node<E> node = stack.pop();
			node.prev = current;
			current.next = node;
			current = node;
		}
		this.tail = current;
		this.tail.next = null;
	}
	
	public void reverseIterative() {
		Node<E> current = this.tail;
		while(current.prev != null) {
			Node<E> oldNext = current.next;
			current.next = current.prev;
			if (current == this.tail) {
				current.prev = null;
				this.head = current;
			} else {
				current.prev = oldNext;
			}
			current = current.next;
		}
		current.prev = current.next; 
		current.next = null;
		this.tail = current;
	}
	
	public void reverseRecursive() {
		reverseHelper(this.head);
	}
	
	private Node<E> reverseHelper(Node<E> node) {
		if (node == null) {
			return null;
		}
		Node<E> ret = reverseHelper(node.next);
		if (ret == null) {
			this.head = node;
			this.head.prev = null;
		} else {
			if (node.prev == null) {
				this.tail = node;
				this.tail.next = null;
			}
			ret.next = node;
			node.prev = ret;
		}
		return node;
	}

	public void print() {
		Node<E> current = this.head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		LinkedList<String> l = new LinkedList<>();
		l.addLast("A");
		l.addLast("C");
		l.addLast("D");
		l.addLast("B");
		l.print();
		l.removeFirst();
		l.print();
		l.addFirst("E");
		l.print();
		l.removeLast();
		l.print();
		l.addFirst("A");
		l.addLast("F");
		l.print();
		Node<String> middle = l.getMiddle();
		System.out.println("Middle element: " + (middle == null ? "null" : middle.data));
		l.removeMiddle();
		l.print();
		l.addFirst("B");
		l.addLast("A");
		l.addLast("H");
		l.addFirst("B");
		l.addLast("A");
		l.addLast("D");
		l.print();
		System.out.println("Remove duplicates:");
		l.removeDuplicates();
		l.print();
		System.out.println("Reverse list:");
//		l.reverseStack();
//		l.reverseRecursive();
		l.reverseIterative();
		l.print();
	}
}
