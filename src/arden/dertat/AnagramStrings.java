package arden.dertat;

import java.util.HashMap;
import java.util.Map;

public class AnagramStrings {

	public static void main(String[] args) {
		String s1 = "Eleven pluss two";
		String s2 = "Twelve plus one";
		System.out.println(isAnagramStrings(s1, s2));
		
	}

	private static boolean isAnagramStrings(String s1, String s2) {
		char[] ch1 = s1.toLowerCase().toCharArray();
		char[] ch2 = s2.toLowerCase().toCharArray();
//		if (ch1.length != ch2.length) {
//			return false;
//		}
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] >= 97 && ch1[i] <= 122) {
				if (charMap.containsKey(ch1[i])) {
					charMap.put(ch1[i], charMap.get(ch1[i]) + 1);
				} else {
					charMap.put(ch1[i], 1);
				}
			}
		}
		for (int i = 0; i < ch2.length; i++) {
			if (ch2[i] >= 97 && ch2[i] <= 122) {
				if (!charMap.containsKey(ch2[i])) {
					return false;
				} else {
					int count = charMap.get(ch2[i]);
					if (count == 1) {
						charMap.remove(ch2[i]);
					} else {
						charMap.put(ch2[i], count-1);
					}
				}
			}
		}
		return charMap.isEmpty();
	}

}
