package arden.dertat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EvenOccurringElement {

	public static void main(String[] args) {
		int a[] = new int[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 6, 6, 6};
		System.out.println(evenOccuringElement1(a));
		System.out.println(evenOccuringElement2(a));
	}

	private static int evenOccuringElement2(int[] a) {
		//construct new distinct elements array A. Then construct a new array B with elements of A and original array. Applying XOR operator for all elements in B
		for (int i = 0; i < a.length; i++) {
			
		}
		return 0;
	}

	private static int evenOccuringElement1(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			if(map.get(key) % 2 == 0) {
				return key;
			}
		}
		return 0;
	}

}
