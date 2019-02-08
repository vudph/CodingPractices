package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
	
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int currentMax = 1;
		Set<Character> set = new HashSet<>();
		int i = 0;
		int k = 0;
		while (i < s.length()) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(k));
				k++;
			} else {
				set.add(s.charAt(i));
				currentMax = Math.max(currentMax, set.size());
				i++;
			}
		}
        return currentMax;
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcdb"));
	}

}
