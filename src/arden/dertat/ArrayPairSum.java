package arden.dertat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayPairSum {
	static class Pair {
		int x, y;
		public Pair(int x1, int y1) {
			this.x = x1;
			this.y = y1;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Pair)) {
				return false;
			}
			Pair p = (Pair)obj;
			if (this.x != p.x || this.y != p.y) {
				return false;
			}
			return true;
		}
		@Override
		public int hashCode() {
			int result = 17;
			result += 31 * result + x;
			result += 31 * result + y;
			return result;
		}
	}
	
	private static void pairSum(int sum, Integer a[]) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Pair> output = new HashSet<Pair>();
		for (int i = 0; i < a.length; i++) {
			int target = sum - a[i];
			if (!set.contains(target)) {
				set.add(a[i]);
			} else {
				output.add(new Pair(Math.min(a[i], target), Math.max(a[i], target)));
			}
		}
		
//		Iterator iter = set.iterator();
//		while(iter.hasNext()) {
//			Integer x = (Integer)iter.next();
//			Integer y = sum - x;
//			if(set.contains(y) && x != y) {
//				output.add(new Pair(Math.min(x, y), Math.max(x, y)));
//			}
//		}
		System.out.println(output);
	}
	
	public static int getSum(int[] input) {
		int currentMax = input[0];
		int finalMax = input[0];
		for (int i = 1; i < input.length; i++) {
			if (currentMax + input[i] > input[i])
				currentMax = currentMax + input[i];
			else
				currentMax = input[i];

			if (currentMax > finalMax)
				finalMax = currentMax;

		}
		return finalMax;
	}
	
	public static void main(String[] args) {
//		int a[] = {10, 6, 6, 6, 10};
//		pairSum(10, new Integer[]{3, 4, 5, 6, 7}); // [[6, 4], [7, 3]]
//		pairSum(8, new Integer[]{3, 4, 5, 4, 4}); // [[3, 5], [4, 4], [4, 4], [4, 4]]
//		pairSum(8, new Integer[]{4}); // []
//		pairSum(0, new Integer[]{4,-4}); // [[-4,4]]
		
		int[] input = {-10, -1, 2, -5, 10, 15, 2, -1, 10, 30};
		System.out.print(longestSum(input));
		
//		int[] a = new int[] {4, 1, 0, 3, 9, 6, 8, 5, 5, 3, 7};
//		int[] b = new int[] {6, 4, 5, 3, 1, 0, 8, 3, 9, 5};
//		System.out.println(missingElement(a, b));
	}
	
	private static int longestSum(int a[]) {
		int finalSum = a[0];
		int currentSum = a[0];
		for (int i = 1; i < a.length; i++) {
			currentSum = Math.max(currentSum + a[i], a[i]);
			finalSum = Math.max(currentSum, finalSum);
		}
		return finalSum;
	}
	
	private static int missingElement(int a[], int b[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < b.length; i++) {
			Integer x = map.get(b[i]);
			if (x != null) {
				map.put(b[i], x + 1);
			} else {
				map.put(b[i], 1);
			}
		}
		for (int i = 0; i < a.length; i++) {
			Integer x = map.get(a[i]);
			if (x == null) {
				return a[i];
			} else {
				if (x == 1) {
					map.remove(a[i]);
				} else {
					map.put(a[i], x-1);
				}
			}
		}
		return -1;
	}
}
