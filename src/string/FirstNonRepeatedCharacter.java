package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
	public static void main(String[] args) {
		String s = "abcabc dac bacd nngagb h";
		System.out.println(firstNonRepeatedCharacter(s));
	}
	private static Character firstNonRepeatedCharacter(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (charCount.containsKey(s.charAt(i))) {
				charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
			} else {
				charCount.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (charCount.get(s.charAt(i)) == 1) {
				return s.charAt(i);
			}
		}
		return null;
	}
}
