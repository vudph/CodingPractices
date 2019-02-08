package arden.dertat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//http://www.ardendertat.com/2011/09/24/programming-interview-questions-3-largest-continuous-sum/
public class LargestContinuousSum {
	private static int findLargestSum(int a[]) {
		int currentSum = a[0];
		int largestSum = currentSum;
		for (int i = 1; i < a.length; i++) {
			currentSum = Math.max(a[i], currentSum + a[i]);
			largestSum = Math.max(largestSum, currentSum);
		}
		return largestSum;
	}

	public static void main(String[] args) {
//		int[] input = {-10, -1, 2, -5, 10, 15, 2, -1, 10, 30};
//		int[] input = {1,1,-5,-6,50,3};
		int input[] = {1, 2, 3, 4, -6, 7, 7, 7};
		System.out.print(findLargestSum(input));
		System.out.println(lonelyinteger(new int[]{0,0, 1, 2, 1}));
	}
	
	static int lonelyinteger(int[] a) {
//		if (a.length == 1) return a[0];
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < a.length; i++) {
//			if (map.containsKey(a[i])) {
//				map.put(a[i], map.get(a[i]) + 1);
//			} else {
//				map.put(a[i], 1);
//			}
//		}
//		Iterator<Integer> iter = map.keySet().iterator();
//		while (iter.hasNext()) {
//			int k = iter.next();
//			if (map.get(k) == 1) return k;
//		}
//		return -1;
		int ret = a[0];
		for (int i = 1; i < a.length; i++) {
			ret = ret ^ a[i];
		}
		return ret;
	}

}
