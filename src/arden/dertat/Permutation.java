package arden.dertat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		String test = "AFBC";
		List<String> per = permutation(test, test.length());
		for (String res : per) {
			System.out.print(res + ", ");
		}
		System.out.println();
		System.out.println(per.size());
	}
	private static List<String> permutation(String s, int len) {
		if (len == 1) {
			List<String> result = new ArrayList<>();
			result.add(s.substring(0, len));
			return result;
		}
		List<String> perms = permutation(s, len - 1);
		char ch = s.charAt(len - 1);
		List<String> result = new ArrayList<>();
		for (String per : perms) {
			for (int i = 0; i <= per.length(); i++) {
				String aa = addCharAt(per, ch, i);
				result.add(aa);
			}
		}
		return result;
	}
	private static String addCharAt(String s, char ch, int idx) {
		return s.substring(0, idx) + ch + s.substring(idx);
	}
}
