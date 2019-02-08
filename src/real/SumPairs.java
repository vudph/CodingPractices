package real;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// - Given an array (unsorted) numbers how would you find every pair of numbers that add up to a given sum? 
// 4 3 5 2 6 8 9 1 3 4, n = 7 => (4, 3), (5, 2), (6, 1)

public class SumPairs {

	private static void printSumPairs(int a[], int n) {
		Set<Integer> numbers = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			numbers.add(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			if (numbers.contains(n - a[i])) {
				System.out.println("(" + a[i] + "," + (n - a[i]) + ")");
				numbers.remove(a[i]);
				numbers.remove(n - a[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		printSumPairs(new int[] {4, 3, 5, 2, 6, 8, 9, 1, 3, 4}, 7);
	}

}
