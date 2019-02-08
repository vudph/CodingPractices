package codility;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatChar {
	
	private static String longestString(String s) {
		int currentLength = 0;
		int finalLongest = currentLength;
		String longestSubstring = null;
		Set<Character> charSet = new HashSet<>();
		int i = 0;
		int j = i;
		while (i < s.length() && j < s.length()) {
			if (charSet.contains(s.charAt(j))) {
				if (currentLength > finalLongest) {
					finalLongest = currentLength;
					longestSubstring = s.substring(j - finalLongest, j);
				}
				currentLength = 0;
				charSet.clear();
				i++;
				j = i;
			} else {			
				charSet.add(s.charAt(j));
				currentLength++;
				j++;
			}
		}
		if (currentLength > finalLongest) {
			finalLongest = currentLength;
			longestSubstring = s.substring(j - finalLongest, j);
		}
		return longestSubstring;
	}
	
	public static void main(String[] args) {
		System.out.println(longestString("aaaaa"));
	}

}
