package arden.dertat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMissingElement {
	public static void main(String[] args) {
		int[] a = new int[] {4, 1, 0, 3, 9, 6, 8, 5, 5, 3, 7};
		int[] b = new int[] {6, 4, 5, 3, 1, 0, 8, 3, 9, 7};
		System.out.println(missingElement(a, b));
		System.out.println(missingElementByHash(a, b));
	}
	private static int missingElement(int[] a, int[] b) {
		int c[] = new int[a.length + b.length];
		int missingElement = 0;
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		int j = 0;
		for (int i = a.length; i < c.length; i++) {
			c[i] = b[j++];
		}
		for (int i = 0; i < c.length; i++) {
			missingElement ^= c[i];
		}
		return missingElement;
	}
	
	private static int missingElementByHash(int a[], int b[]) {
		Map<Integer, Integer> eleMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (eleMap.containsKey(a[i])) {
				eleMap.put(a[i], eleMap.get(a[i]) + 1);
			} else {
				eleMap.put(a[i], 1);
			}
		}
		for (int i = 0; i < b.length; i++) {
			if (eleMap.containsKey(b[i])) {
				int val = eleMap.get(b[i]);
				if (val == 1) {
					eleMap.remove(b[i]);
				} else {
					eleMap.put(b[i], val - 1);
				}
			}
		}
		return (int) eleMap.keySet().toArray()[0];
	}
}
