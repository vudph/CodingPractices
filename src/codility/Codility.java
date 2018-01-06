package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
//https://codility.com/programmers/lessons/1-iterations/binary_gap/
//https://codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/

public class Codility {

	public static void main(String[] args) {
		int A[] = {5, 4, 1, 3};
		System.out.println(missingElement(A));
		System.out.println(oddOccurences(new int[]{9, 3, 9, 5, 9, 9, 5}));
		System.out.println(binaryGap(9));
		System.out.println(frogJump(10, 85, 30));
		System.out.println(smallestDifference(new int[]{3, 1, 2, 4, 3}));
		System.out.println(isPermutation(new int[] {2, 1, 3}));
		System.out.println(earliestJump(new int[]{1, 3, 1, 4, 4, 3, 5, 4}, 5));
		System.out.println(smallestPositiveMissing(new int[]{-1, 1, 3, 4}));
		System.out.println(decimalZip(12345, 678));
		System.out.println(findValidMaxTime(1, 2, 2, 5));
	}

	private static int missingElement(int[] A) {
		int n = A.length + 1;
		int xor = 0;
		for (int i = 0; i < A.length; i++) {
			xor ^= A[i] ^ (i + 1);
		}
        return xor ^ n;
	}
	
	private static int oddOccurences(int A[]) {
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			res ^= A[i];
		}
		return res;
	}
	
	private static int binaryGap(int n) {
		String bin = Integer.toBinaryString(n);
//		System.out.println(bin);
		int idx = bin.indexOf("1");
//		System.out.println(idx);
		int longestGap = 0;
		while (idx != -1) {
			int idxFrom = bin.indexOf("1", idx + 1);
			if (idxFrom == -1)
				break;
			longestGap = Math.max(longestGap, idxFrom - idx);
//			System.out.println(idxFrom);
			idx = idxFrom;
		}
		return longestGap == 0 ? 0 : longestGap - 1;
	}
	
	private static int frogJump(int X, int Y, int D) {
		double step = (Y - X) / (D * 1.0);
		int k = (int) Math.ceil(step);
		return k;
	}
	
	private static int smallestDifference(int A[]) {
		int totalSum = 0;
		for (int i = 0; i < A.length; i++) {
			totalSum += A[i];
		}
		int leftSum = A[0];
		int rightSum = totalSum - leftSum;
		int minDiff = Math.abs(rightSum - leftSum);
		for (int k = 1; k < A.length; k++) {
			leftSum += A[k];
			rightSum = totalSum - leftSum;
			if (Math.abs(rightSum - leftSum) < minDiff) {
				minDiff = Math.abs(rightSum - leftSum);
			}
		}
		return minDiff;
	}
	
	private static int isPermutation(int A[]) {
		int n = A.length;
		Map<Integer, Integer> mapElement = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (mapElement.containsKey(A[i])) {
				mapElement.put(A[i], mapElement.get(A[i]) + 1);
			} else {
				mapElement.put(A[i], 1);
			}
		}
		for (int i = 1; i <= n; i++) {
			if (mapElement.containsKey(i)) {
				int val = mapElement.get(i);
				if (val == 1) {
					mapElement.remove(i);
				} else {
					mapElement.put(i, val - 1);
				}
			} else {
				return 0;
			}
		}
		return mapElement.isEmpty() ? 1 : 0;
	}
	
	private static int earliestJump(int A[], int X) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i])) {
				map.put(A[i], i);
			}
		}
		int earliestTime = -1;
		for (int i = 1; i <= X; i++) {
			if (map.containsKey(i)) {
				if (map.get(i) > earliestTime) {
					earliestTime = map.get(i);
				}
			} else {
				return -1;
			}
		}
		return earliestTime;
	}

	private static int smallestPositiveMissing(int A[]) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		int k = 1;
		while (set.contains(k)) {
			k++;
		}
		return k;
	}
	
	private static int decimalZip(int A, int B) { //12 5678 => 152678
		char a[] = Integer.toString(A).toCharArray();
		char b[] = Integer.toString(B).toCharArray();
		char c[] = new char[a.length + b.length];
		int n = Math.min(a.length, b.length);
		int k = 0;
		for (int i = 0; i < n; i++) {
			c[k++] = a[i];
			c[k++] = b[i];
		}
		if (a.length > b.length) {
			for (int i = b.length; i < a.length; i++) {
				c[k++] = a[i];
			}
		} else {
			for (int i = a.length; i < b.length; i++) {
				c[k++] = b[i];
			}
		}
		return Integer.parseInt(String.copyValueOf(c));
	}
	
	private static String findValidMaxTime(int A, int B, int C, int D) {//1225
		String s = Integer.toString(A) + Integer.toString(B) + Integer.toString(C) + Integer.toString(D);
		int vals[] = {A, B, C, D};
		int counts[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	    for (int i = 0; i < vals.length; i++) {
	        for (int j = vals[i]; j < counts.length; j++) counts[j]++;
	    }
	    
		List<String> possibilities = permutation(s, 4);
		String maxValidTime = "NOT POSSIBLE";
		int maxMinutes = -1;
		for (String p : possibilities) {
			if (isValidMinute(p)) {
				int hourInMinutes = Integer.parseInt(p.substring(0, 2)) * 60;
				int sumMinutes = hourInMinutes + Integer.parseInt(p.substring(2));
				if (sumMinutes > maxMinutes) {
					maxMinutes = sumMinutes;
					maxValidTime = p.substring(0, 2) + ":" + p.substring(2);
				}
			}
		}
		return maxValidTime;
	}
	
	private static List<String> permutation(String s, int len) {
		if (len == 1) {
			return Arrays.asList(s.substring(0, 1));
		}
		List<String> pers = permutation(s, len - 1);
		char lastCharacter = s.charAt(len - 1);
		List<String> nextPers = new ArrayList<>();
		for (String per : pers) {
			for (int i = 0; i <= per.length(); i++) {
				String nextper = addCharToStringAt(lastCharacter, per, i);
				if (isValidHour(nextper)) {
					nextPers.add(nextper);
				}
			}
		}
		return nextPers;
	}
	
	private static boolean isValidHour(String s) {
		if (Character.digit(s.charAt(0), 10) > 2) {
			return false;
		} else if (Character.digit(s.charAt(0), 10) == 2) {
			if (Character.digit(s.charAt(1), 10) > 3) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
	
	private static boolean isValidMinute(String s) {
		if (s.length() > 2) {
			if (Character.digit(s.charAt(2), 10) > 5) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	private static String addCharToStringAt(char lastCharacter, String per, int i) {
		return per.substring(0, i) + lastCharacter + per.substring(i, per.length());
	}
}
