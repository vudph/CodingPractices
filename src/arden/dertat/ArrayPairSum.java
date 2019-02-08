package arden.dertat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	
//	public static void main(String[] args) {
////		int a[] = {10, 6, 6, 6, 10};
////		pairSum(10, new Integer[]{3, 4, 5, 6, 7}); // [[6, 4], [7, 3]]
////		pairSum(8, new Integer[]{3, 4, 5, 4, 4}); // [[3, 5], [4, 4], [4, 4], [4, 4]]
////		pairSum(8, new Integer[]{4}); // []
////		pairSum(0, new Integer[]{4,-4}); // [[-4,4]]
//		
//		int[] a = new int[] {4, 1, 0, 3, 9, 6, 8, 5, 5, 3, 7};
//		int[] b = new int[] {6, 4, 5, 3, 1, 0, 8, 3, 9, 5};
//		System.out.println(missingElement(a, b));
//	}
	
//	private static int missingElement(int a[], int b[]) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < b.length; i++) {
//			Integer x = map.get(b[i]);
//			if (x != null) {
//				map.put(b[i], x + 1);
//			} else {
//				map.put(b[i], 1);
//			}
//		}
//		for (int i = 0; i < a.length; i++) {
//			Integer x = map.get(a[i]);
//			if (x == null) {
//				return a[i];
//			} else {
//				if (x == 1) {
//					map.remove(a[i]);
//				} else {
//					map.put(a[i], x-1);
//				}
//			}
//		}
//		return -1;
//	}
	
	
    public static void printsByPair(List<Integer> inputNumbers, Integer targetSum){ // O(N + N)
        //Retrieve all the pairs, where sum = targetSum & Print them
        Set<Integer> numbers = new HashSet<>();
        //for (Integer n : inputNumbers) {
        //    numbers.add(n);
        //}
        for (Integer n : inputNumbers) {
            int target = targetSum - n;
            if (numbers.contains(target)) {
                System.out.println(n + "," + target);
                numbers.remove(n);
                numbers.remove(target);
            } else {
               numbers.add(n); 
            }
        }
    }
    
    public static void main(String[] args){
    	List<Integer> inputNumbers = new ArrayList<>();
    	int arr[] = new int[] {2,3,7,4,6,8,-1,9,11,5, 5};
    	for (int i = 0; i < arr.length; i++) {
			inputNumbers.add(arr[i]);
		}
        printsByPair(inputNumbers, 10);
    }
}
