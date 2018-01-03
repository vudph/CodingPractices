package array.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

//http://javaconceptoftheday.com/java-array-interview-programs/

public class JavaArrayInterview {
	
	//find duplicate elements
	private static List<Object> findDuplicateElement(Object input[]) {
		Set<Object> distinctElements = new HashSet<>();
		List<Object> dups = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (!distinctElements.add(input[i])) {
				dups.add(input[i]);
			}
		}
		return dups;
	}
	
	//find the second max
	private static int findSecondLargest(int a[]) {
		if (a.length == 1) {
			return a[0];
		}
		int max1 = a[0];
		int max2 = a[1];
		if (a[0] < a[1]) {
			max1 = a[1];
			max2 = a[0];
		}
		for (int i = 2; i < a.length; i++) {
			if (a[i] > max1) {
				max2 = max1;
				max1 = a[i];
			} else if (a[i] > max2) {
				max2 = a[i];
			}
		}
		return max2;
	}
	
	private static boolean areEqualArrays(int a[], int b[]) {
		return Arrays.equals(a, b);
	}
	
	// find all pairs of elements in an integer array whose sum is equal to a given number?
	private static void findPairsSumEqualNumber(int a[], int n) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < a.length; i++) {
//			if (map.containsKey(a[i])) {
//				map.put(a[i], map.get(a[i]) + 1);
//			} else {
//				map.put(a[i], 1);
//			}
//		}
//		for (int i = 0; i < a.length; i++) {
//			if (map.containsKey(n - a[i])) {
//				map.remove(n - a[i]);
//				map.remove(a[i]);
//				System.out.println(a[i] + " + " + (n - a[i]));
//			}
//		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			int target = n - a[i];
			if (set.contains(target)) {
				set.remove(target);
				set.remove(a[i]);
				System.out.println(a[i] + " " + target);
			}
		}
	}
	
	//find continuous sub array whose sum is equal to a given number?
	private static void findContinuousSubArraySumEqualNumber(int a[], int n) {
		List<Integer> subList = new ArrayList<>();
		for (int i = 0; i < a.length - 1; i++) {
			int sum = n;
			for (int j = i; j < a.length; j++) {
				if (sum - a[j] > 0) {
					sum = sum - a[j];
					subList.add(a[j]);
				} else if (sum - a[j] == 0) {
					subList.add(a[j]);
					for (Integer integer : subList) {
						System.out.print(integer + ", ");
					}
					System.out.println();
					return;
				} else {
					subList = new ArrayList<>();
					break;
				}
			}
		}
		subList.toArray();
	}
	
	//find the largest continuous sum in given array with negative and positive elements
	private static int findLargestContinousSum(int a[]) {
		int finalSum = a[0];
		int currentSum = a[0];
		for (int i = 1; i < a.length; i++) {
			if (currentSum + a[i] > a[i]) {
				currentSum = currentSum + a[i];
			} else {
				currentSum = a[i];
			}
			if (currentSum > finalSum) {
				finalSum = currentSum;
			}
		}
		return finalSum;
	}
	
	//find missing element
	private static int findMissingElement(int a1[], int a2[]) {
		int a[] = IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).toArray();
		int missingEle = a[0];
		for (int i = 1; i < a.length; i++) {
			missingEle ^= a[i];
		}
		return missingEle;
	}
	
	private static int[] rotateArrayCircularly(int A[], int K) {
		if (A.length == 0) {
			return A;
		}
		for (int k = 0; k < K; k++) {
			int lastElement = A[A.length - 1];
			for (int i = A.length - 2; i >= 0 ; i--) {
				A[i + 1] = A[i];
			}
			A[0] = lastElement;
		}
		return A;
	}
	
	public static void main(String[] args) {
		findDuplicateElement(new String[]{"Java", "JSP", "Servlets", "Java", "Struts", "JSP", "JDBC"});
		System.out.println(findSecondLargest(new int[]{47498, 14526, 74562, 42681, 75283, 45796}));
		System.out.println(areEqualArrays(new int[]{47498, 14526, 74562, 42681, 75283, 45796}, new int[]{47498, 14526, 74562, 42681, 75283, 45795}));
		findPairsSumEqualNumber(new int[] {4, 6, 6, -10, 8, 2, 20}, 10);
		findContinuousSubArraySumEqualNumber(new int[]{15, 51, 7, 81, 5, 11, 25}, 41);
		System.out.println(findLargestContinousSum(new int[]{-10, -1, 2, -5, 10, 15, 2, -1, 10, 30}));
		System.out.println(findMissingElement(new int[] {4, 1, 0, 3, 9, 6, 8, 5, 5, 3}, new int[] {6, 4, 5, 3, 1, 0, 8, 3, 9}));
		rotateArrayCircularly(new int[]{}, 1);
	}

}
