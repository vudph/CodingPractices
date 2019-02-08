package leetcode;

import java.util.Stack;

public class AddTwoNumber {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		ListNode res = new ListNode(0);
		ListNode resTail = res;
		int carry = 0;
		while (curr1 != null && curr2 != null) {
			int sum = curr1.val + curr2.val + carry;
			ListNode node = new ListNode(sum % 10);
			resTail.next = node;
			resTail = node;
			carry = sum / 10;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		ListNode remains = null;
		if (curr1 != null) {
			remains = curr1;
		} else if (curr2 != null) {
			remains = curr2;
		}
		while (remains != null) {
			int sum = remains.val + carry;
			ListNode node = new ListNode(sum % 10);
			resTail.next = node;
			resTail = node;
			carry = sum / 10;
			remains = remains.next;
		}
		if (carry != 0) {
			ListNode node = new ListNode(carry);
			resTail.next = node;
			resTail = node;
		}
		res = res.next;
		return res;
    }
	
	private static Stack<Integer> buildStack(ListNode l) {
		Stack<Integer> stack = new Stack<>();
		ListNode current = l;
		while (l.next != null) {
			stack.push(current.val);
			current = current.next;
		}
		return stack;
	}
	
	public static void main(String[] args) {
		int a1[] = new int[]{5};
		int a2[] = new int[]{5};
		ListNode l1Head = new ListNode(a1[0]);
		ListNode l1Tail = l1Head;
		
		ListNode l2Head = new ListNode(a2[0]);
		ListNode l2Tail = l2Head;
		for (int i = 1; i < a1.length; i++) {
			ListNode node = new ListNode(a1[i]);
			l1Tail.next = node;
			l1Tail = node;
		}
		for (int i = 1; i < a2.length; i++) {
			ListNode node = new ListNode(a2[i]);
			l2Tail.next = node;
			l2Tail = node;
		}
		ListNode l = addTwoNumbers(l1Head, l2Head);
		ListNode curr = l;
		while (curr != null) {
			System.out.print(curr.val + ", ");
			curr = curr.next;
		}
	}

}
