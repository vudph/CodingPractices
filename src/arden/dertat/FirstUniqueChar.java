package arden.dertat;

import java.util.HashMap;
import java.util.Map;

//Find the first non-repeated (unique) character in a given string.
public class FirstUniqueChar {

	public static void main(String[] args) {
		String test = "ongu PHam HoangV VuPm";
		System.out.println(getFirstUniqueChar(test));
	}

	private static Character getFirstUniqueChar(String test) {
		Map<Character, Integer> characterMap = new HashMap<>();
		for (int i = 0; i < test.length(); i++) {
			if (characterMap.containsKey(test.charAt(i))) {
				characterMap.put(test.charAt(i), characterMap.get(test.charAt(i)) + 1);
			} else {
				characterMap.put(test.charAt(i), 1);
			}
		}
		for (int i = 0; i < test.length(); i++) {
			if (characterMap.get(test.charAt(i)) == 1) {
				return test.charAt(i);
			}
		}
		return null;
	}

}
