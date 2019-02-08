package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
	
	public static boolean isValid(String s) {
		char openParenthesis[] = {'{', '[', '('};
		Set<Character> setOpenParenthesis = new HashSet<>();
		for (int i = 0; i < openParenthesis.length; i++) {
			setOpenParenthesis.add(Character.valueOf(openParenthesis[i]));
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (setOpenParenthesis.contains(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char open = stack.pop();
				int combine = open + s.charAt(i);
				if (combine != 81 && combine != 184 && combine != 248) {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }

	public static void main(String[] args) {
		System.out.println(isValid("["));
	}

}
