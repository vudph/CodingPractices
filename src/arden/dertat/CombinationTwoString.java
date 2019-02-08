package arden.dertat;

import java.util.Stack;

public class CombinationTwoString {
	private static boolean isValidShuffle(String a, String b, String c) {
		if (a.length() + b.length() != c.length()) 
			return false;
		Stack<Character> stack = new Stack<>();
		for (int i = c.length() - 1; i >= 0; i--) {
			stack.push(c.charAt(i));
		}
		int ai = 0;
		int bi = 0;
		while (!stack.isEmpty()) {
			char ch = stack.pop();
			if (ai < a.length() && ch == a.charAt(ai)) {
				ai++;
			} else if (bi < b.length() && ch == b.charAt(bi)) {
				bi++;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValidShuffle("abc", "def", "dabecf"));
	}
}
