package arden.dertat;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancedParentheses {
	private static boolean isBanlancedParentheses(String parentheses) {
		Stack<Character> parenthesesStack = new Stack<>();
		Set<Character> opening = new HashSet<>();
		opening.add('(');
		opening.add('[');
		opening.add('{');
		Set<Character> closing = new HashSet<>();
		closing.add(')');
		closing.add(']');
		closing.add('}');
		Set<String> match = new HashSet<>();
		match.add("()");
		match.add("[]");
		match.add("{}");
		for (int i = 0; i < parentheses.length(); i++) {
			if (opening.contains(parentheses.charAt(i))) {
				parenthesesStack.push(parentheses.charAt(i));
			} else if (closing.contains(parentheses.charAt(i))) {
				if (parenthesesStack.isEmpty()) {
					return false;
				}
				Character popOpeningParentheses = parenthesesStack.pop();
				String combination = (popOpeningParentheses + "") + (parentheses.charAt(i) + "");
				if (!match.contains(combination)) {
					return false;
				}
			}
		}
		return parenthesesStack.isEmpty();
	}
	public static void main(String[] args) {
		String parentheses = "(2 + [1 + {2 * [1 + (1 + 3) + 4] + 1}])";
		System.out.println(isBanlancedParentheses(parentheses));
	}
}
